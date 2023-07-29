package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UsersDao;

/**
 * Servlet implementation class LoginServlet
 * 检查用户登陆的servlet，没有带验证码的验证
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UsersDao service =new UsersDao();
		try {
			User user =service.findUserByNameAndPassword(username, password);
			if(user==null) {
				request.setAttribute("registerMessage","用户名或密码错误！" );
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else {
				request.getSession().setAttribute("user", user);
				
				if(user.getRole()==1) {
					response.sendRedirect(request.getContextPath()+"/admin/login/home.jsp");
					return;
				}else {
					response.sendRedirect(request.getContextPath()+"/index.jsp");
					return;
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return;
		}	
		
	}

}
