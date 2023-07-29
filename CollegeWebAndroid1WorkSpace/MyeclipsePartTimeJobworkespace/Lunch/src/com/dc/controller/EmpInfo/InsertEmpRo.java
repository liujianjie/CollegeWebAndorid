package com.dc.controller.EmpInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.Empinfo.EmpDAO;
import com.dc.dao.Empinfo.EmpDAOImpl;

public class InsertEmpRo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String empaccountid=request.getParameter("empaccountid");
		String[] roleid=request.getParameterValues("roleid");
		EmpDAO dao=new EmpDAOImpl();
		boolean i=dao.insertEmpRole(empaccountid,roleid);
		if(i){
			request.getRequestDispatcher("/dc/ShowAllEmp").forward(request, response);
		}
		else{
			response.sendRedirect("/Lunch/module/BgLogin/BgLogin.jsp");
		}
	}

}
