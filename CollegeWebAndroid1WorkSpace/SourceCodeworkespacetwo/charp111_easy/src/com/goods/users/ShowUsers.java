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
		//������post��ʽ��Ч������Ϣ��������˴�����������Ĭ����UTF-8���룩,������������request�У�
		//��Ϊ�Ƕ�������Ϣ������Ҫ���룬ǿ��requestʹ��utf-8���롣
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("username");
		String sex=request.getParameter("sex");
		String telephone=request.getParameter("telephone");
		out.println("<h2>���ĸ�����Ϣ</h2>");
		out.println("�û���:"+name+"<br>");
		out.println("�Ա�:"+sex+"<br>");
		out.println("�绰:"+telephone+"<br>");
	
	}

}
