package com.dc.controller.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.goods.CaterialDao;
import com.dc.dao.goods.CaterialDaoImpl;
import com.dc.dao.goods.GoodsDao;
import com.dc.dao.goods.GoodsDaoImpl;

public class CheckUserName2 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * 材料名称唯一性校验
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String caterialid=request.getParameter("caterialid");
		String caterialname=request.getParameter("caterialname");
		CaterialDao caterial=new CaterialDaoImpl();	
		boolean state=caterial.checkUserName2(caterialid,caterialname);
	
		PrintWriter out=response.getWriter();
		if(state){
			out.print("{\"state\":"+state+",\"message\":\"格式无误\"}");
			
		}else{
			out.print("{\"state\":"+state+",\"message\":\"材料已经存在\"}");

	}
		
	}

}
