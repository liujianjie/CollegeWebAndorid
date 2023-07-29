package com.dc.controller.department;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.department.DepartDAO;
import com.dc.dao.department.DepartDAOImpl;

public class UpdateDepart extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String departid=request.getParameter("departid");
		DepartDAO depart=new DepartDAOImpl();
		Map map=depart.findDepartById(departid);
		request.setAttribute("map", map);
		request.getRequestDispatcher("/module/Depart/UpdateDepart.jsp").forward(request, response);
		
	}

}
