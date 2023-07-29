package com.dc.controller.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.order.OrderDAO;
import com.dc.dao.order.OrderDAOImpl;

public class Detail extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String orderid=request.getParameter("orderid");
		String state=request.getParameter("state");
		OrderDAO order=new OrderDAOImpl();
		List orderlist=order.findById(orderid);
		request.setAttribute("orderlist", orderlist);
		List orderdlist=order.findDetail(orderid);
		request.setAttribute("orderdlist", orderdlist);
		List list=order.findpack(orderid);
		request.setAttribute("list", list);
		List emplist=order.findemp();
		request.setAttribute("emplist", emplist);
		request.setAttribute("state", state);
		request.getRequestDispatcher("/module/Order/SelectOrderd.jsp").forward(request, response);
		
	}

}
