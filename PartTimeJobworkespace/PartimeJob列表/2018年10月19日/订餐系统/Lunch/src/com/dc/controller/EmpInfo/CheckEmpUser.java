package com.dc.controller.EmpInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.BgLogin.UserDAO;
import com.dc.dao.BgLogin.UserDAOImpl;
import com.dc.dao.Empinfo.EmpDAO;
import com.dc.dao.Empinfo.EmpDAOImpl;


public class CheckEmpUser extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String accountid=request.getParameter("accountid");
		System.out.println(username+"username");
		System.out.println(accountid+"accountid");
		PrintWriter out=response.getWriter();
		EmpDAO dao=new EmpDAOImpl();
		boolean state=dao.checkUserName(username, accountid);
		out.print(state);	
	}

}
