package com.zuxia.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zuxia.dao.UserInfoDao;
import com.zuxia.model.UserInfo;
import com.zuxia.util.StringUtil;

public class SystemManage extends HttpServlet {

	//处理GET请求
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		String returnURL ="";
		if(op!=null){
			if("resetPass".equals(op)){
				returnURL = resetPass(request,response);
			}else if("login".equals(op)){
				returnURL = validateLogin(request, response);
			}else if("loginOut".equals(op)){
				returnURL = loginOut(request, response);
			}else if("resetUserName".equals(op)){
				returnURL = resetUserName(request,response);
			}else{
				returnURL = "../admin/error.jsp";
			}
		}else{
			Object user = request.getSession().getAttribute("user");
			if(user!=null){
				//重定向至首页
				response.sendRedirect("../admin/index.jsp");
				return;
			}else{
				returnURL = "../admin/login.jsp";
			}
		}
		request.getRequestDispatcher(returnURL).forward(request, response);
	}

	//处理POST请求
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	//修改密码
	private String resetPass(HttpServletRequest request, HttpServletResponse response){
		String oldPass = request.getParameter("oldPwd");
		String newPass = request.getParameter("newPwd");
		//若新密码和旧密码为空
		if(StringUtil.isNullOrEmpty(oldPass) || StringUtil.isNullOrEmpty(newPass)){
			request.setAttribute("msg", "对不起，修改密码失败！请填写完整密码数据!");
			return "../admin/failed.jsp"; //转向失败页面
		}
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo)session.getAttribute("user");
		user.setUserPwd(newPass);
		//修改密码
		boolean flag = new UserInfoDao().update(user, oldPass);
		if(flag){
			request.setAttribute("msg", "恭喜您，修改密码成功！");
			return "../admin/ok.jsp"; //成功页面
		}
		request.setAttribute("msg", "对不起，修改密码失败！");
		return "../admin/failed.jsp";
	}
	
	//修改用户名
	private String resetUserName(HttpServletRequest request, HttpServletResponse response){
		String userName = request.getParameter("userName");
		//若新密码和旧密码为空
		if(StringUtil.isNullOrEmpty(userName)){
			request.setAttribute("msg", "对不起，修改用户名失败！请填写用户名!");
			return "../admin/failed.jsp"; //转向失败页面
		}
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo)session.getAttribute("user");
		user.setUserName(userName);
		//修改用户名
		boolean flag = new UserInfoDao().update(user);
		if(flag){
			//重新存储用户
			session.setAttribute("user", user);
			request.setAttribute("msg", "恭喜您，修改用户名成功！");
			return "../admin/ok.jsp"; //成功页面
		}
		request.setAttribute("msg", "对不起，修改用户名失败！");
		return "../admin/failed.jsp";
	}
	
	//验证登陆
	private String validateLogin(HttpServletRequest request, HttpServletResponse response){
		//用户名、密码
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		UserInfo loginUser = new UserInfo(userName,userPwd);
		//验证登陆
		UserInfo user = new UserInfoDao().validateLogin(loginUser);
		HttpSession session = request.getSession();
		if(user != null){
			session.setAttribute("loginTime", String.valueOf(System.currentTimeMillis()));
			session.setAttribute("user",user);
			return "../admin/index.jsp";
		}else{
			return "../admin/login.jsp";
		}
	}
	
	//退出系统
	private String loginOut(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		try{
			session.invalidate();
		}catch(Exception ex){
		}
		return "../admin/login.jsp";
	}
}
