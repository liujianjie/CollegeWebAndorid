package com.goods.userservlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goods.bean.User;
import com.goods.dao.UsersDao;

/**
 * Servlet implementation class RegisterServlet
 * 用户注册的servlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码格式,以防中文乱码
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// 注册，获取用户在页面填入的相关信息，都用java基本数据类型存储起来
		String username = request.getParameter("username");// 姓名
		String password = request.getParameter("password");// 密码
		String email = request.getParameter("email");// 邮箱
		String sex = request.getParameter("sex");// 性别
		int role = Integer.parseInt(request.getParameter("role"));// 角色
		String bir = request.getParameter("birthday");// 生日
		
		// 字符串格式化对象，可以将字符串转换为日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday;
		try {
			// 把用户表单输入的字符串日期转换成Date类型
			birthday = sdf.parse(bir);
			// 用user对象存储用户填入的信息，方便dao操作
			User user = new User();
			user.setUsername(username);
			user.setSex(sex);
			user.setPassword(password);
			user.setEmail(email);
			user.setBirthday(birthday);
			user.setRole(role);
			// 实例化操作users表的对象
			UsersDao u = new UsersDao();
			// 查找users表中是否存在这个用户名称
			boolean a = u.find(username);//判断用户是否注册过
			// 若注册过
			if(!a) {
				// 设置信息存在
				request.setAttribute("errorMessage", "用户已存在");
				// 跳转到注册页面
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
			// 没有注册过，且用户填写信息合法，插入数据库
			boolean b = u.insert(user);
			if(b) {
				// 输出页面信息
				response.getWriter().print("注册成功，1秒自动跳转");
				// 用session保存当前对象
				request.getSession().setAttribute("user", username);
				// 设置HTTP消息头（响应头），1秒后跳转首页
				response.setHeader("refresh", "1;url=/charp1_easy/index.jsp");
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
	}

}
