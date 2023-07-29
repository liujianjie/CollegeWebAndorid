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
		//����post��ʽ��Ч������Ϣ�������������������Ĭ��utf-8���������������˵�request��
		//��Ϊ�Ƕ�������Ϣ������Ҫ���룬
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		//��ȡ��¼���û���������
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String introduce = request.getParameter("introduce");
		
		out.print("<h2>������Ϣ�ǣ�</h2>");
		out.println("�û�����" + name + "<br>");
		out.println("�Ա�" + sex + "<br>");
		out.println("�绰��" + telephone + "<br>");
		out.println("���䣺" + email + "<br>");
		out.println("���˽��ܣ�" + introduce + "<br>");
	}

}
