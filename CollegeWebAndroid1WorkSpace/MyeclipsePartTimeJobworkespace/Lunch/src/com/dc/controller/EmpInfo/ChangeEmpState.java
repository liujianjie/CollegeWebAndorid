package com.dc.controller.EmpInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.BgLogin.UserDAO;
import com.dc.dao.BgLogin.UserDAOImpl;

public class ChangeEmpState extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
			String empid=request.getParameter("empid");
			UserDAO user=new UserDAOImpl();
			int state=user.changeEmpAccountState(empid);
			//System.out.println(empid+"ChangeEmpid/empid");
			PrintWriter out=response.getWriter();
			out.print(state);
	}

}
