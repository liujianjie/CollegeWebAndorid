package com.dc.controller.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.goods.CaterialDao;
import com.dc.dao.goods.CaterialDaoImpl;

public class UpdateCaterial extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	/**
	 * ÐÞ¸Ä²ÄÁÏ
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		CaterialDao caterial=new CaterialDaoImpl();
		String caterialid=request.getParameter("caterialid");
		String demand=request.getParameter("demand");
		
		/*Map map=caterial.fCaterial(caterialid);
		request.setAttribute("caterial",map );*/
		caterial.updateCaterial(caterialid, demand);

		/*request.getRequestDispatcher("/module/warehouse/Caterial.jsp").forward(request, response);*/
		request.getRequestDispatcher("/dc/Caterial").forward(request, response);
	}

}
