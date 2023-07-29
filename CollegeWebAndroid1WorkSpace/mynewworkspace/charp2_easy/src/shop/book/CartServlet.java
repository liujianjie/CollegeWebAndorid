package shop.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goods.entity.Book;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//�õ����ﳵ
		List<Book> cart = null;
		//�õ��û��Լ���session
		HttpSession session = request.getSession(false);
		//�Լ�����һ��flag���жϹ��ﳵ���Ƿ���ͼ��
		boolean cartFlag = true;
		if(session==null) {
			cartFlag=false;
		}else {
			cart = (List<Book>) session.getAttribute("cart");
			if(cart==null) {
				cartFlag=false;
			}
		}//���ﳵ������Ʒ��
		if(!cartFlag) {
			out.print("���������ﳵ��Ȼ�ǿյģ�����");
		}else {
			for(Book b:cart) {
				out.print("�����ͼ�飺"+b.getName()+"<br />");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
