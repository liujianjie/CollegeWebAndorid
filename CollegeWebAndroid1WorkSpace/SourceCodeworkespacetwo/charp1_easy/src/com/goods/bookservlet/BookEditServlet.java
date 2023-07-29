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
 * Servlet implementation class BookEditServlet
 * �޸�ͼ��servlet
 */
@WebServlet("/BookEditServlet")
public class BookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ñ����ʽ,�Է���������
		request.setCharacterEncoding("utf-8");
		// ʵ��������goods��Ķ���
		BookDao bdao = new BookDao();
		// ��ȡҳ����Ҫ�޸ĵ�ͼ��id
		int id = Integer.parseInt(request.getParameter("id"));
		// ��ȡҳ���޸ĺ��ͼ������
		String name = request.getParameter("name");
		// ��ȡҳ���޸ĺ��ͼ��۸�
		String prices = request.getParameter("price");
		Double price = Double.parseDouble(prices);
		
		// ʵ����һ��book�������洢��ʱ��Ϣ
		Book book = new Book();
		// ��book�洢ҳ�洫�ݹ�������Ϣ
		book.setId(id);
		book.setName(name);
		book.setPrice(price);
		// ��bookdaoִ���޸�ͼ�����
		bdao.updateBook(book);
		// �޸���ͼ����Ϣ����Ҫ���²�������ͼ����Ϣ
		request.getRequestDispatcher("/BookSearchAllServlet?flag=1").forward(request, response);
	}

}
