package com.goods.bookservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goods.bean.Book;
import com.goods.dao.BookDao;

/**
 * Servlet implementation class BookSearchAllServlet
 * ����ͼ��servlet������ݷ����ȡָ��ͼ����߶�ȡ����ͼ��
 */
@WebServlet("/BookSearchAllServlet")
public class BookSearchAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ʵ��������goods��Ķ���
		BookDao bdao = new BookDao();
		// ʵ����һ��list���洢���bookͼ�����
		List<Book> booklist = new ArrayList<Book>();
		// ͨ��bookdao��ȡ�������ݿ�ͼ����Ϣ��list����
		booklist = bdao.findAllBook();
		// ��ȡҳ�洫�ݵ�catalog��������
		String cata = request.getParameter("catalog");
		int catalog = 0;
		// ������ݹ����ķ������Բ�Ϊ�գ���ôת��Ϊintֵ
		if (cata != null){
			catalog = Integer.parseInt(cata);
		}
		// ��session������ҵ�����ͼ����Ϣ
		request.getSession().setAttribute("books", booklist);
		// ��ȡҳ�洫�ݵ�flag���ԣ�flag���ж��ǲ�ѯ����ͼ�飬����ȫ��ͼ��
		String flag = request.getParameter("flag");
		// ��Ϊ�գ���Ϊ1
		if (flag != null && flag.equals("1"))
			// ȥ��̨���й���ͼ�����
			response.sendRedirect(request.getContextPath() + "/admin/goods/goods.jsp");
		else {
			// ���ݷ�����ת����ͬͼ��ҳ��
			switch (catalog) {
			case 1:
				// ��ת�����ͼ�����
				response.sendRedirect(request.getContextPath() + "/computer.jsp");
				break;
			case 2:
				// ��ת����ͼ�����
				response.sendRedirect(request.getContextPath() + "/art.jsp");
				break;
			case 3:
				// ��ת����ͼ�����
				response.sendRedirect(request.getContextPath() + "/english.jsp");
				break;
			}

		}

	}


}
