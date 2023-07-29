package com.dc.controller.card;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dc.dao.card.CardDAOImpl;


public class SelectCard extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
//		HttpSession sess=request.getSession();
//		Map map=(Map) sess.getAttribute("userinfo");
//		String customerid=map.get("customer_id").toString();
		String customerid=request.getParameter("customerid");
		
		CardDAOImpl card=new CardDAOImpl();
		try {
			List list=card.select(customerid);
			request.setAttribute("list", list);
			List cuslist=card.findcustomerById(customerid);
			request.setAttribute("cuslist", cuslist);
			request.setAttribute("customerid", customerid);
			request.getRequestDispatcher("/module/Buy/SelectCard.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
