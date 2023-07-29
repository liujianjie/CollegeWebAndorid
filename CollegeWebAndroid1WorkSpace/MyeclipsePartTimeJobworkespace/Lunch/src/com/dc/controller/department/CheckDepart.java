package com.dc.controller.department;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.department.DepartDAO;
import com.dc.dao.department.DepartDAOImpl;

public class CheckDepart extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String customername=request.getParameter("customername");
		String customerid=request.getParameter("customerid");
		String departid=request.getParameter("departid");
		String departname=request.getParameter("departname");
		DepartDAO depart=new DepartDAOImpl();
		
		boolean state=depart.checkDepart(departname, departid);
		PrintWriter out=response.getWriter();
		if(state){
			out.print("{\"state\":1}");
		}else{
			out.print("{\"state\":0}");
		}
	}

}