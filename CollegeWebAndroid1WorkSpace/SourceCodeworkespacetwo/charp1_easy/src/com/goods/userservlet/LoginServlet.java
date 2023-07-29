package com.goods.userservlet;

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
		// 设置编码格式,以防中文乱码
		request.setCharacterEncoding("utf-8");
		// 获取登录填入的用户名和密码
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		// 实例化操作users表的对象
		UsersDao service = new UsersDao();
		try {
			// 根据用户名和密码查询users表中是否有这个用户
			User user =service.findUserByNameAndPassword(username, password);
			// 为null代表users表中没有这个
			if(user==null) {
				// 返回信息说没有这个用户
				request.setAttribute("registerMessage","用户名或密码错误！" );
				// 跳转到login登录界面
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else {
				// 有这个用户，需要判断是普通用户还是管理管理用户
				// 先保存这个用户信息
				request.getSession().setAttribute("user", user);
				// 判断角色，users表中存储的是0,1，0代表普通用户，1代表管理用户
				if(user.getRole()==1) {
					// 是管理员，去后台页面
					response.sendRedirect(request.getContextPath()+"/admin/login/home.jsp");
					return;
				}else {
					// 是普通用户，去首页页面
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
