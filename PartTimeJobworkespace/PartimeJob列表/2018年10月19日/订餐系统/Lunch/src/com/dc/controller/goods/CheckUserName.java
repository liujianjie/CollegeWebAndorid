package com.dc.controller.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.border.EmptyBorder;

import com.dc.dao.goods.GoodsDao;
import com.dc.dao.goods.GoodsDaoImpl;

public class CheckUserName extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * 菜品名称唯一性校验
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String mealid=request.getParameter("mealid");
		String mealname=request.getParameter("mealname");
		GoodsDao goods=new GoodsDaoImpl();
		
		boolean state=goods.checkUserName(mealname, mealid);
		PrintWriter out=response.getWriter();
		if(state){
			
			out.print("{\"state\":"+state+",\"message\":\"格式无误\"}");
		}else{
			out.print("{\"state\":"+state+",\"message\":\"用户名已经存在\"}");

	}
		
	}
}

