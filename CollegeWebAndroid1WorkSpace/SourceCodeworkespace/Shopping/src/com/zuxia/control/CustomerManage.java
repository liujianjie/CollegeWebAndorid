package com.zuxia.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zuxia.dao.CustomerInfoDao;
import com.zuxia.model.CustomerDetailInfo;
import com.zuxia.model.CustomerInfo;
import com.zuxia.util.PageModel;
import com.zuxia.util.StringUtil;

public class CustomerManage extends HttpServlet {

	/**
	 * 处理请求（GET/POST）
	 */
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		String returnURL = "";
		if (op == null || "".equals(op)) {
			returnURL = queryAll(request, response);
		} else {
			if ("query".equals(op)) {
				returnURL = query(request, response);
			} else if ("toEdit".equals(op)) {
				returnURL = toEdit(request, response);
			} else if ("update".equals(op)) {
				returnURL = update(request, response);
			} else if ("remove".equals(op)) {
				returnURL = remove(request, response);
			} else if ("removeMore".equals(op)) {
				returnURL = removeMore(request, response);
			} else {
				request.setAttribute("msg", "访问资源出错！访问该资源未携带必要的参数！");
				returnURL = "../admin/error.jsp";
			}
		}
		request.getRequestDispatcher(returnURL).forward(request, response);
	}
	
	//关键词搜索
	private String query(HttpServletRequest request,
			HttpServletResponse response) {
		int pageSize = 10;
		int pageNo = 1;
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch (NumberFormatException e) {
		}
		String keyWords = request.getParameter("keywords");
		CustomerInfoDao dao = new CustomerInfoDao();
		 PageModel<CustomerInfo> pm = dao.getAllCustomers(pageSize, pageNo,keyWords);
		request.setAttribute("allCustomers", pm);
		return "../admin/customerManage.jsp";
	}

	//查询所有
	private String queryAll(HttpServletRequest request,
			HttpServletResponse response) {
		int pageSize = 10;
		int pageNo = 1;
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch (NumberFormatException e) {
		}
		CustomerInfoDao dao = new CustomerInfoDao();
		PageModel<CustomerInfo> pm = dao.getAllCustomers(pageSize, pageNo);
		if (pm != null && pm.getData().isEmpty() && pageNo != 1) {
			pm = dao.getAllCustomers(pageSize, 1);
		}
		request.setAttribute("allCustomers", pm);
		return "../admin/customerManage.jsp";
	}

	//前往编辑页面
	private String toEdit(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		if(!StringUtil.isNullOrEmpty(id)){
			CustomerInfo customer = new CustomerInfoDao().getCustomerInfo(Integer.parseInt(id));
			if(customer!=null){
				request.setAttribute("customer", customer);
				return "../admin/updateCustomer.jsp";
			}
		}
		request.setAttribute("msg", "未找到此客户信息！");
		return "../admin/error.jsp";
	}

	//修改
	private String update(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String telphone = request.getParameter("telphone");
		String movePhone = request.getParameter("movePhone");
		String address = request.getParameter("address");
		
		try{
			CustomerInfo customer = new CustomerInfo();
			customer.setId(Integer.parseInt(id));
			customer.setEmail(email);
			CustomerDetailInfo detail = new CustomerDetailInfo();
			detail.setName(name);
			detail.setTelphone(telphone);
			detail.setMovePhone(movePhone);
			detail.setAddress(address);
			customer.setDetailInfo(detail);
			boolean flag = new CustomerInfoDao().updateCustomer(customer);
			if(flag){
				return queryAll(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("msg", "对不起，修改客户信息失败！");
		return "../admin/failed.jsp";
	}

	//删除
	private String remove(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		if(!StringUtil.isNullOrEmpty(id)){
			boolean  flag = new CustomerInfoDao().removeCustomer(Integer.parseInt(id));
			if(flag){
				return queryAll(request, response);
			}
		}
		request.setAttribute("msg", "对不起，删除客户信息失败！");
		return "../admin/failed.jsp";
	}

	//删除多条
	private String removeMore(HttpServletRequest request,
			HttpServletResponse response) {
		String ids = request.getParameter("removeIds");
		if(!StringUtil.isNullOrEmpty(ids)){
			boolean  flag = new CustomerInfoDao().removeCustomers(ids);
			if(flag){
				return queryAll(request, response);
			}
		}
		request.setAttribute("msg", "对不起，删除客户信息失败！");
		return "../admin/failed.jsp";
	}
}
