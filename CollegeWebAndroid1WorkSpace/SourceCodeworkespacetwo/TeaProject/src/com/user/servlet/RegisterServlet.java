package com.user.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UsersDao;

/**
 * Servlet implementation class RegisterServlet
 * �û�ע���servlet
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
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		int role = Integer.parseInt(request.getParameter("role"));
		String bir = request.getParameter("birthday");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday;
		try {
			birthday = sdf.parse(bir);//���û���������ַ�������ת����Date����
			
			User user = new User();
			user.setUsername(username);
			user.setSex(sex);
			user.setPassword(password);
			user.setEmail(email);
			user.setBirthday(birthday);
			user.setRole(role);
	
			UsersDao u = new UsersDao();
			boolean a = u.find(username);//�ж��û��Ƿ�ע���
			
			if(!a) {//��ע���
				request.setAttribute("errorMessage", "�û��Ѵ���");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
			//û��ע��������û���д��Ϣ�Ϸ����������ݿ�
			boolean b = u.insert(user);
			if(b) {
				response.getWriter().print("ע��ɹ���1���Զ���ת");
				request.getSession().setAttribute("user", username);
				response.setHeader("refresh", "1;url=/charp1_easy/index.jsp");
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
	}

}
