package com.goods.bookservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goods.bean.Book;
import com.goods.dao.BookDao;

/**
 * Servlet implementation class BookSearchByIdServlet
 * ������ƷId��ѯָ��ͼ����Ϣservlet��Ϊ�����޸���
 */
@WebServlet("/BookSearchByIdServlet")
public class BookSearchByIdServlet extends HttpServlet {
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
		// ��ȡҳ�洫�ݵ�id����
		Integer id = Integer.parseInt(request.getParameter("id"));
		// ����id�ҵ�ָ��ͼ��
		Book book = bdao.findOneBook(id);
		// ��request����ͼ������
		request.setAttribute("book", book);
		// ��ת���޸�ͼ�����
		request.getRequestDispatcher("/admin/goods/edit.jsp").forward(request, response);
	}

}
