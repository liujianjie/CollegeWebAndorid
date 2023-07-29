package com.goods.bookservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.goods.bean.Book;
import com.goods.bean.BookNum;
import com.goods.dao.BookDao;

/**
 * ���ͼ�鵽���ﳵ��servlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ʵ��������goods��Ķ���
		BookDao bdao = new BookDao();
		// ��ȡҳ�洫�ݵ�id����
		int id = Integer.parseInt(request.getParameter("id"));
		// ����id�ҵ����ݿ���ָ��ͼ����Ϣ
		Book book = bdao.findOneBook(id);

		// ��ȡsession����
		HttpSession session = request.getSession();
		//����Cookie���Session�ı�ʶ�ţ����ñ���session��ʱ��
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*30);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		
		// ��session �����л�ù��ﳵ��Ϣ��ǿ��ת��ΪList����
		List<BookNum> cart = (List) session.getAttribute("cart");
		
		if (cart == null) {
			// �״ι���Ϊ�û�����һ�����ﳵ��List����ģ�⹺�ﳵ��
			cart = new ArrayList<BookNum>();
			// �����ﳵ����Session����
			session.setAttribute("cart", cart);
		}
		boolean noexit = true;
		// ����Ʒ���빺�ﳵ���������ﳵ����ͼ�飬����id���ж�Ҫ�����ͼ���Ƿ���ڹ��ﳵ�У�������+1������������ͼ�鵽���ﳵ��
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getId() == book.getId()) {
				int num = cart.get(i).getNum();// �Ȼ�ȡ�ж��ٸ�����
				cart.get(i).setNum(num + 1);// ��������+1
				noexit = false;// �������
				break;
			}
		}
		// ����bool�����ж��Ƿ���ڣ������ھ����
		if (noexit) {
			// BookCart�������洢�����ݿ��ȡ��book���ݣ��ٱ��浽���ﳵsession��
			BookNum bookc = new BookNum();
			bookc.setId(book.getId());//id
			bookc.setName(book.getName());// ����
			bookc.setNum(1);// ����
			bookc.setPic(book.getPic());// ͼƬ��ַ
			bookc.setPrice(book.getPrice());// �۸�
			cart.add(bookc);// ���
		}

		// �ض��򵽼����ҳ��
		response.sendRedirect(request.getContextPath() + "/computer.jsp");
	}
}
