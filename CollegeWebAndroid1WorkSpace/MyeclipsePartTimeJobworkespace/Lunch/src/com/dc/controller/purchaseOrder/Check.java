package com.dc.controller.purchaseOrder;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.purchaseOrder.PurchaseOrderDao;
import com.dc.dao.purchaseOrder.PurchaseOrderDaoImpl;

public class Check extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				PurchaseOrderDao pur=new PurchaseOrderDaoImpl();
				String poid=request.getParameter("poid");
				String operatingid=request.getParameter("operatingid");
				boolean state=pur.checkUserName(operatingid, poid);
				PrintWriter out=response.getWriter();
				
				if(state){
					
					out.print("{\"state\":"+state+",\"message\":\"格式无误\"}");
				}else{
					out.print("{\"state\":"+state+",\"message\":\"用户名已经存在\"}");
		
			}*/
	}

}
