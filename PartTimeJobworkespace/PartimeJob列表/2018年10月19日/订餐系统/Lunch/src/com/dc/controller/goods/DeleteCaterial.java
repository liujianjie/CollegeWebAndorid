package com.dc.controller.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.goods.CaterialDao;
import com.dc.dao.goods.CaterialDaoImpl;

public class DeleteCaterial extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}


	/**
	 * É¾³ý²ÄÁÏaction
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		CaterialDao caterial=new CaterialDaoImpl();
		String caterialid=request.getParameter("caterialid");
		caterial.deleteCarterial(caterialid);
		PrintWriter out=response.getWriter();
		out.print("{\"state\":\"true\",\"message\":\"É¾³ý³É¹¦\"}");


	}

}
