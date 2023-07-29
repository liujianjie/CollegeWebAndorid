package com.dc.controller.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dc.dao.Login.UserLoginDAO;
import com.dc.dao.Login.UserLoginDAOImpl;

public class Login extends HttpServlet {
	public void destroy() {
		super.destroy(); 	
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String userpwd=request.getParameter("userpwd");
		UserLoginDAO dao=new UserLoginDAOImpl();
		//System.out.println(username);
		//System.out.println(userpwd);
		Map map=dao.Login(username,null);
		System.out.println(map);
		HttpSession sess=request.getSession();
		if(map!=null&&!map.isEmpty()){
			String customer_pwd=map.get("customer_pwd").toString();
			if(customer_pwd.equals(userpwd)){
				sess.setAttribute("UserMap", map);//用户UserMap，员工userinfo
				//System.out.println("成功登录");
				out.print("success");
				//request.getRequestDispatcher("/module/Login/Menu.jsp").forward(request, response);
			}else{
				//request.getRequestDispatcher("/module/Login/Login.jsp").forward(request, response);
				//System.out.println("pwderror");
				out.print("pwderror");
			}
		}
		else{
			//response.sendRedirect("/Lunch/module/Login/Login.jsp");
			//System.out.println("请注册");
			out.print("nouser");
		}
		
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
