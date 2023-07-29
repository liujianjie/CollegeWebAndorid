package com.goods.servlet;

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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
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
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		
		String password=request.getParameter("password");
		
		String email=request.getParameter("email");
		String sex=request.getParameter("sex");
		int role=Integer.parseInt(request.getParameter("role"));
		String bir=request.getParameter("birthday");
		
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday;
		try{
			birthday =  s.parse(bir);//���û�������������ַ������ڻ���Date����
			
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			user.setEmail(email);
			user.setSex(sex);
			user.setBirthday(birthday);
			user.setRole(role);
			
			UsersDao u =new UsersDao();
			boolean a= u.find(name);//�ж��û����Ƿ��Ѿ�ע���
			
			if(!a) {//��ע���
				request.setAttribute("errorMessage", "��ע����û��Ѵ�");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
			//û��ע��������û���д��Ϣ�Ϸ����������ݿ�
			boolean b =u.insert(user);//���û���Ϣ���뵽users��
			if(b){
				
				response.getWriter().print("��ϲ��ע��ɹ���1���Զ���ת");
				request.getSession().setAttribute("user",user);
				response.setHeader("refresh", "1;url=index.jsp");
			}
		}catch (ParseException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		
			}
			
		}
	}


