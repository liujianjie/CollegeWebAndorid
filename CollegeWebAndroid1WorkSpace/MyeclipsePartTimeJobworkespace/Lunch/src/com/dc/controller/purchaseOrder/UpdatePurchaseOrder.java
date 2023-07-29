package com.dc.controller.purchaseOrder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.purchaseOrder.PurchaseOrderDao;
import com.dc.dao.purchaseOrder.PurchaseOrderDaoImpl;

public class UpdatePurchaseOrder extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PurchaseOrderDao pur=new PurchaseOrderDaoImpl();
		String poid=request.getParameter("poid");
		Map map=pur.findPur(poid);
		request.setAttribute("pur",map );
		request.getRequestDispatcher("/module/purchaseOrder/InsertPurchaseOrder.jsp").forward(request, response);*/
	}

}
