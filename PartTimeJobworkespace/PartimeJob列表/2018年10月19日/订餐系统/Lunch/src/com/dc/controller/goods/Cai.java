package com.dc.controller.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.Role.RolefunDAO;
import com.dc.dao.Role.RolefunDAOImpl;
import com.dc.dao.goods.GoodsDao;
import com.dc.dao.goods.GoodsDaoImpl;

public class Cai extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * ≤À∆∑≤ƒ¡œ≤È—Øaction
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		GoodsDao good=new GoodsDaoImpl();
		String mealid=request.getParameter("mealid");
		
		List list=good.finCai(mealid);
		request.setAttribute("mealid", mealid);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/module/warehouse/CaiLiao.jsp").forward(request, response);
	}
	
}
