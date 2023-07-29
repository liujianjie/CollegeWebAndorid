package controll;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DB.DBUtil;

@WebServlet("/ServletLoginCheck")
public class ServletLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String user = request.getParameter("username");
		String pwd = request.getParameter("password");
		System.out.println("用户名："+user+"，密码:"+pwd);
		
		// 数据库工具类
		DBUtil db = new DBUtil();
		try {
			ResultSet rs = db.query("select * from user where username = '"
					+user+"' and password = '"+pwd+"'");
			if(rs.next()){
				HttpSession se =  request.getSession();
				se.setAttribute("name", user);
				response.sendRedirect("loginSuc2.jsp");
			}else{
				response.sendRedirect("login2.jsp");
			}
		} catch (Exception e) {
			response.sendRedirect("login2.jsp");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
