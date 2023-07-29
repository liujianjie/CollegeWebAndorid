package com.dc.controller.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.goods.GoodsDao;
import com.dc.dao.goods.GoodsDaoImpl;

public class SelectCai extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * ≤À∆∑≤ƒ¡œ≤È—Ø
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		GoodsDao goods=new GoodsDaoImpl();
		String mealid=request.getParameter("mealid");
		String caterialid=request.getParameter("caterialid");
		List list=goods.fCaterial();
		request.setAttribute("list", list);
		request.setAttribute("mealid", mealid);
		request.setAttribute("caterialid", caterialid);
		request.getRequestDispatcher("/module/warehouse/SelectCai.jsp").forward(request, response);
	}

}
