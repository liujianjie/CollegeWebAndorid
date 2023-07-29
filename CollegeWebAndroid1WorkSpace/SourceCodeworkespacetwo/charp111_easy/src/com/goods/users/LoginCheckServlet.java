package com.goods.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheckServlet
 */
@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
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
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		if(name.equals("John")&&password.equals("123456"))
		{
			request.setAttribute("name", name);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request,response);
		}else{
			request.setAttribute("error", "用户名或密码错误");
			RequestDispatcher dispatcher=request.getRequestDispatcher("/erro.jsp");
			dispatcher.forward(request,response);
			
		}
	}

}
