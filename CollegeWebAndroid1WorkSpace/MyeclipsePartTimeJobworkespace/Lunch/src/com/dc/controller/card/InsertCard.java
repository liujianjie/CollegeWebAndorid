package com.dc.controller.card;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dc.dao.card.CardDAO;
import com.dc.dao.card.CardDAOImpl;

public class InsertCard extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String meal=request.getParameter("meal");
		String price=request.getParameter("price");
		String customerid=request.getParameter("customerid");
		System.out.println(customerid);
//		HttpSession sess=request.getSession();
//		Map map=(Map) sess.getAttribute("userinfo");
//		String customerid=map.get("customer_id").toString();
		
		//System.out.println(meal+price+" "+customerid);
		CardDAOImpl card=new CardDAOImpl();
		try {
			List list=card.find(meal, price, customerid);
			if(list!=null&&list.size()>0){
				card.update(meal, customerid);
			}else{
				card.insert(meal, price, customerid);
			}
			response.sendRedirect("/Lunch/card/SelectCard?customerid="+customerid);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
