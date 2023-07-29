package com.dc.controller.Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.Login.UserLoginDAO;
import com.dc.dao.Login.UserLoginDAOImpl;
import com.dc.util.StringUtil;

public class Register extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
			String customername=request.getParameter("customername");
			String customerid=request.getParameter("customerid");
			String customeruser=request.getParameter("customeruser");
			String pwd=request.getParameter("pwd");
			String birthday=request.getParameter("birthday");
			String sex=request.getParameter("sex");
			String customerphone=request.getParameter("customerphone");
			String province=request.getParameter("province");
			String city=request.getParameter("city");
			String district=request.getParameter("district");
			String customeradd=request.getParameter("customeradd");
			//зЂВс
			UserLoginDAO dao=new UserLoginDAOImpl();
			if(StringUtil.checkNotNull(customerid)){
				int j=dao.updatecustomer(customerid,customername, customeruser, 
						pwd, birthday, sex, customerphone, province, 
						city, district, customeradd);
				if(j!=0){
					request.setAttribute("customeruser", customeruser);
					request.getRequestDispatcher("/module/Login/Menu.jsp").forward(request, response);
				}
				else{
					response.sendRedirect("/Lunch/module/Login/Login.jsp");
				}
			}else{
				//System.out.println(district);
				int i=dao.register(customername, customeruser,
						pwd, birthday, sex, customerphone, province,
						city, district, customeradd);
				if(i!=0){
					request.setAttribute("customeruser", customeruser);
					request.getRequestDispatcher("/module/Login/Login.jsp").forward(request, response);
				}
				else{
					response.sendRedirect("/Lunch/module/Login/Login.jsp");
				}
			}
	}

}
