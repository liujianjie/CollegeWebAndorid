package com.dc.controller.warehouse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.warehouse.WarehouseDao;
import com.dc.dao.warehouse.WarehouseDaoImpl;

public class UpdateWarehouse extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		WarehouseDao war=new WarehouseDaoImpl();
		String caterialid=request.getParameter("caterialid");
		String number=request.getParameter("number");
		/*war.updateWarehouse(caterialid, number);*/
		request.getRequestDispatcher("/dc/Warehouse").forward(request, response);
	}

}
