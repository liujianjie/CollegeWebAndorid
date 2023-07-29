package com.goods.bookservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goods.dao.BookDao;

/**
 * Servlet implementation class BookDeleServlet
 * ɾ��ͼ��servlet
 */
@WebServlet("/BookDeleServlet")
public class BookDeleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ʵ��������goods��Ķ���
		BookDao bdao = new BookDao();
		// ��ȡ��ҳ�洫�����Ĳ���id
		Integer id = Integer.parseInt(request.getParameter("id"));
		// ɾ��goods������ҳ��ͨ��id��Ӧ���ݿ���е�Ψһͼ��
		bdao.deleteById(id);
		// ɾ����ͼ����Ҫ���²�ѯ����ͼ�飬����BookSearchAllServlet��
		request.getRequestDispatcher("/BookSearchAllServlet?flag=1").forward(request, response);
	}

}
