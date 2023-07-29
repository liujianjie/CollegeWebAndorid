package com.zuxia.control;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zuxia.dao.CustomerInfoDao;
import com.zuxia.model.CustomerDetailInfo;
import com.zuxia.model.CustomerInfo;

public class CustomerForwardManage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		String returnURL = "";
		if(op==null || "".equals(op)){
			returnURL = "../index.jsp";
		}else if ("login".equals(op)) {
			returnURL = validateLogin(request,response);
		}else if("loginOut".equals(op)){
			returnURL = loginOut(request, response);
		}else if("detail".equals(op)){
			returnURL = inputDetailInfo(request,response);
		}else if("register".equals(op)){
			returnURL = register(request, response);
		}else{
			request.setAttribute("msg", "访问资源错误：访问该资源未携带参数！");
			returnURL = "../error.jsp";
		}
		request.getRequestDispatcher(returnURL).forward(request, response);
	}
	
	//登录
	private String validateLogin(HttpServletRequest request, HttpServletResponse response){
		//用户名、密码
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		//验证登陆
		CustomerInfo customer = new CustomerInfoDao().validateLogin(userName,userPwd);
		HttpSession session = request.getSession();
		if(customer != null){
			session.setAttribute("customer",customer);
			
			Object status = session.getAttribute("toGo");
			if(status==null){
				return "../index.jsp";
			}else{
				return "PayManage?op=confirm";
			}
		}else{
			request.setAttribute("failed","true");
			return "../login_register.jsp";
		}
	}
	
	//退出
	private String loginOut(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		try{
			session.invalidate();
		}catch(Exception ex){
		}
		return "../index.jsp";
	}
	
	//录入客户详细信息（配送信息）
	private String inputDetailInfo(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		//获取登录客户
		CustomerInfo customer = (CustomerInfo)session.getAttribute("customer");
		if(customer == null){
			return "../login_register.jsp";
		}
		
		//获取提交的表单数据
		String name = request.getParameter("name");
		String telphone = request.getParameter("telphone");
		String movePhone = request.getParameter("movePhone");
		String address = request.getParameter("address");
		
		//将表单数据及登录客户信息封装到JavaBean中
		CustomerDetailInfo detail = new CustomerDetailInfo();
		detail.setName(name);
		detail.setTelphone(telphone);
		detail.setMovePhone(movePhone);
		detail.setAddress(address);
		detail.setCustomerInfo(customer);
		
		//调用Dao类方法执行新增客户详细信息
		CustomerInfoDao dao = new CustomerInfoDao();
		boolean flag = dao.addCustomerDetailInfo(detail);
		if(flag){
			customer = dao.getCustomerInfo(customer.getId());
			session.setAttribute("customer", customer);
			Object status = session.getAttribute("toGo");
			if(status!=null){
				return "PayManage?op=confirm";
			}
			return "../index.jsp";
		}
		request.setAttribute("msg", "可能的原因：配送信息填写错误！");
		return "../failed.jsp";
	}
	
	//注册
	private String register(HttpServletRequest request, HttpServletResponse response){
		//获取客户基本信息
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		CustomerInfo customer = new CustomerInfo();
		customer.setEmail(email);
		customer.setPwd(pwd);
		
		//获取客户配送信息
		CustomerDetailInfo detail = null;
		String chkGaoji = request.getParameter("chkGaoji");
		if(chkGaoji!=null){
			String name = request.getParameter("name");
			String telphone = request.getParameter("telphone");
			String movePhone = request.getParameter("movePhone");
			String address = request.getParameter("address");
			
			detail = new CustomerDetailInfo();
			detail.setName(name);
			detail.setTelphone(telphone);
			detail.setMovePhone(movePhone);
			detail.setAddress(address);
		}
		customer.setDetailInfo(detail);
		
		//新增客户信息
		CustomerInfoDao dao = new CustomerInfoDao();
		boolean flag = dao.addCustomer(customer);
		if(flag){
			//进行登录（主要为了获取包含客户编号的客户信息）
			customer = dao.validateLogin(customer.getEmail(), customer.getPwd());
			//将客户信息保存在session中
			HttpSession session = request.getSession();
			session.setAttribute("customer", customer);
			
			//如果在注册前客户欲进行购物结算，则注册后转向结算
			Object status = session.getAttribute("toGo");
			if(status!=null){
				return "PayManage?op=confirm";
			}else{
				request.setAttribute("msg", "恭喜您，注册成功！");
				return "../ok.jsp";
			}
		}
		request.setAttribute("msg", "对不起，注册失败！");
		return "../failed.jsp";
	}
}
