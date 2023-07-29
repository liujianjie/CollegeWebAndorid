package com.goods.users;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowMessage
 */
@WebServlet("/ShowMessage")
public class ShowMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("username");
		String sex=request.getParameter("sex");
		String telephone=request.getParameter("telephone");
	
		out.println("<h2>您的个人信息</h2>");
		out.println("用户名:"+name+"<br>");
		out.println("性别:"+sex+"<br>");
		out.println("电话:"+telephone+"<br>");
	}
}

