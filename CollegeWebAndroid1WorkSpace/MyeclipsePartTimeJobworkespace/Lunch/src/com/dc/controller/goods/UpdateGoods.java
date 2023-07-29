package com.dc.controller.goods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.goods.GoodsDao;
import com.dc.dao.goods.GoodsDaoImpl;

public class UpdateGoods extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * ÐÞ¸Ä²ËÆ·
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		GoodsDao goods=new GoodsDaoImpl();
		String mealid=request.getParameter("mealid");
		Map map=goods.findGoods(mealid);
	
		//map.put("meal_id",mealid);
		request.setAttribute("goods",map );
	
		request.getRequestDispatcher("/module/warehouse/Goods.jsp").forward(request, response);
	}
}
