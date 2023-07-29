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
		// ���ñ����ʽ,�Է���������
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// ע�ᣬ��ȡ�û���ҳ������������Ϣ������java�����������ʹ洢����
		String username = request.getParameter("username");// ����
		String password = request.getParameter("password");// ����
		String email = request.getParameter("email");// ����
		String sex = request.getParameter("sex");// �Ա�
		int role = Integer.parseInt(request.getParameter("role"));// ��ɫ
		String bir = request.getParameter("birthday");// ����
		
		// �ַ�����ʽ�����󣬿��Խ��ַ���ת��Ϊ���ڸ�ʽ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday;
		try {
			// ���û���������ַ�������ת����Date����
			birthday = sdf.parse(bir);
			// ��user����洢�û��������Ϣ������dao����
			User user = new User();
			user.setUsername(username);
			user.setSex(sex);
			user.setPassword(password);
			user.setEmail(email);
			user.setBirthday(birthday);
			user.setRole(role);
			// ʵ��������users��Ķ���
			UsersDao u = new UsersDao();
			// ����users�����Ƿ��������û�����
			boolean a = u.find(username);//�ж��û��Ƿ�ע���
			// ��ע���
			if(!a) {
				// ������Ϣ����
				request.setAttribute("errorMessage", "�û��Ѵ���");
				// ��ת��ע��ҳ��
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
			// û��ע��������û���д��Ϣ�Ϸ����������ݿ�
			boolean b = u.insert(user);
			if(b) {
				// ���ҳ����Ϣ
				response.getWriter().print("ע��ɹ���1���Զ���ת");
				// ��session���浱ǰ����
				request.getSession().setAttribute("user", username);
				// ����HTTP��Ϣͷ����Ӧͷ����1�����ת��ҳ
				response.setHeader("refresh", "1;url=/charp1_easy/index.jsp");
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
	}

}
