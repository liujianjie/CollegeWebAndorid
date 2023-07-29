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
 * ����û���½��servlet��û�д���֤�����֤
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
		// ���ñ����ʽ,�Է���������
		request.setCharacterEncoding("utf-8");
		// ��ȡ��¼������û���������
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		// ʵ��������users��Ķ���
		UsersDao service = new UsersDao();
		try {
			// �����û����������ѯusers�����Ƿ�������û�
			User user =service.findUserByNameAndPassword(username, password);
			// Ϊnull����users����û�����
			if(user==null) {
				// ������Ϣ˵û������û�
				request.setAttribute("registerMessage","�û������������" );
				// ��ת��login��¼����
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else {
				// ������û�����Ҫ�ж�����ͨ�û����ǹ�������û�
				// �ȱ�������û���Ϣ
				request.getSession().setAttribute("user", user);
				// �жϽ�ɫ��users���д洢����0,1��0������ͨ�û���1��������û�
				if(user.getRole()==1) {
					// �ǹ���Ա��ȥ��̨ҳ��
					response.sendRedirect(request.getContextPath()+"/admin/login/home.jsp");
					return;
				}else {
					// ����ͨ�û���ȥ��ҳҳ��
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
