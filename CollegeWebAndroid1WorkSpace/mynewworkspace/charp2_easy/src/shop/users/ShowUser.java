package shop.users;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowUser
 */
@WebServlet("/ShowUser")
public class ShowUser extends HttpServlet {
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
		response.setContentType("text/html;charset=utf-8");
		//仅对post方式有效，表单信息有浏览器传到服务器（默认utf-8），传到服务器端的request中
		//因为是二进制信息，所以要解码，
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		//获取登录的用户名和密码
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String introduce = request.getParameter("introduce");
		
		out.print("<h2>您的信息是：</h2>");
		out.println("用户名：" + name + "<br>");
		out.println("性别：" + sex + "<br>");
		out.println("电话：" + telephone + "<br>");
		out.println("邮箱：" + email + "<br>");
		out.println("个人介绍：" + introduce + "<br>");
	}

}
