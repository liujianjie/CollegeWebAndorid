package com.goods.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goods.bean.User;
import com.goods.dao.UsersDao;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		UsersDao service = new UsersDao();
		try {
			User user = service.findUserByUsernameAndPassword(name, password);
			if(user==null) 
			{
				request.setAttribute("registerMessage", "用户名或密码错误！");
			    request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}else{
			
			request.getSession().setAttribute("user", user);
			
			int role = user.getRole();
						if (role==1) {
				response.sendRedirect(request.getContextPath() + "/admin/login/home.jsp");
				return;
			} else {
				response.sendRedirect(request.getContextPath() + "/index.jsp");
				return;
			}
			
			}
		} catch (Exception e) {
			
			e.printStackTrace();
//			request.setAttribute("register_message", e.getMessage());
//			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
	}	

}
