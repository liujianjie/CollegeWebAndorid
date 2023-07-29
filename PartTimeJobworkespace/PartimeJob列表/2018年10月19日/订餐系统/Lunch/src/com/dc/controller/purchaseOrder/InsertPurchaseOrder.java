package com.dc.controller.purchaseOrder;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.purchaseOrder.PurchaseOrderDao;
import com.dc.dao.purchaseOrder.PurchaseOrderDaoImpl;
import com.dc.util.StringUtil;

public class InsertPurchaseOrder extends HttpServlet {

	
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
		String operatingid=request.getParameter("operatingid");
		String operating=request.getParameter("operating");
		String date=request.getParameter("date");
		String listid=request.getParameter("listid");
		PrintWriter out=response.getWriter();
		if(StringUtil.checkNotNull(poid)){
			pur.updatePurchaseOrder(poid,operatingid, operating);
			out.print("{\"state\":\"true\",\"message\":\"保存成功\"}");
		}else{
			pur.insertPurchaseOrder(operatingid, operating);
			out.print("{\"state\":\"true\",\"message\":\"自增成功\"}");
		}*/
	}

}
