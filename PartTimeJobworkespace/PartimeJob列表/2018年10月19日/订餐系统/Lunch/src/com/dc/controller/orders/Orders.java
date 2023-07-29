package com.dc.controller.orders;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.dc.dao.goods.GoodsDao;
import com.dc.dao.goods.GoodsDaoImpl;
import com.dc.dao.orders.OrdersDao;
import com.dc.dao.orders.OrdersDaoImpl;
import com.dc.entity.PageEntity;
import com.dc.util.StringUtil;

public class Orders extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String customername=request.getParameter("customername");
		String nowpage=request.getParameter("nowpage");
		int pageN=0;
		if(StringUtil.checkNotNull(nowpage)){
			pageN=Integer.parseInt(nowpage);
		}else{
			pageN=1;
		}
		PageEntity page=new PageEntity();
		page.setNowpage(pageN);
		Map map=new HashMap();
		map.put("customername", customername);
		OrdersDao order=new OrdersDaoImpl();
		List list=order.findAllOrders(map, page);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		request.setAttribute("tongji", map);
		PrintWriter out=response.getWriter();//Òì²½Êä³ö//json
		JSONArray json=new JSONArray();//json
		json=JSONArray.fromObject(list);//json
		out.print(json.toString());//json
		request.getRequestDispatcher("/module/orders/Orders.jsp").forward(request, response);
	}
	}


	
	

