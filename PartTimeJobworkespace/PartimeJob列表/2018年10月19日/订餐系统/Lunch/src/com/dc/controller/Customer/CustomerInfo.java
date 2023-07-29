package com.dc.controller.Customer;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.BgLogin.UserDAO;
import com.dc.dao.BgLogin.UserDAOImpl;
import com.dc.dao.CustomerDAO.customerDAO;
import com.dc.dao.CustomerDAO.customerDAOImpl;
import com.dc.entity.PageEntity;
import com.dc.util.StringUtil;

public class CustomerInfo extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String customername=request.getParameter("customername");
		String customeruser=request.getParameter("customeruser");
		String nowpage=request.getParameter("nowpage");
		Map map=new HashMap();
		map.put("customername", customername);
		map.put("customeruser", customeruser);
		//System.out.println(customeruser);
		PageEntity page=new PageEntity();
		int pageN=0;
		if(StringUtil.checkNotNull(nowpage)){
			pageN=Integer.parseInt(nowpage);
		}else{
			pageN=1;
		}
		page.setNowpage(pageN);
		
		//显示顾客列表
		customerDAO dao=new customerDAOImpl();
		//List<HashMap> list=dao.selectAllCustomer();
		List<HashMap> customerlist=dao.selectCustomerBycheck(map, page);
		//if(customerlist!=null&&customerlist.size()>0){
			request.setAttribute("customerinfo", customerlist);
			request.setAttribute("map", map);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/module/Customer/Customer.jsp").forward(request, response);
	}

}
