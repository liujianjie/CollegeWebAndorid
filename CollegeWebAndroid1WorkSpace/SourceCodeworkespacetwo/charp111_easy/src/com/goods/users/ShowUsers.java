package com.goods.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowUsers
 */
@WebServlet("/ShowUsers")
public class ShowUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//仅仅对post方式有效，表单信息由浏览器端传到服务器（默认用UTF-8编码）,传到服务器的request中，
		//因为是二进制信息，所以要解码，强制request使用utf-8解码。
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
