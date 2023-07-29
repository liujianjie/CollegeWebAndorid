package com.dc.controller.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.Login.UserLoginDAO;
import com.dc.dao.Login.UserLoginDAOImpl;

public class CheckUsername extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("ºÏ≤È–’√˚");
		String username=request.getParameter("username");
		String customerid=request.getParameter("customerid");
		UserLoginDAO dao=new UserLoginDAOImpl();
		PrintWriter out=response.getWriter();
		Map map=dao.Login(username,customerid);
		if(map!=null&&!map.isEmpty()){
			out.print(true);
		}
		else{
			out.print(false);
		}
	}

}
