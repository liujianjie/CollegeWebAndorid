package com.goods.book;

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



/**
 * Servlet implementation class PurchaseServlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����û��������Ʒ
		String id =request.getParameter("id");
		Book book =BookDB.getBook(id);
		System.out.println(book.getName()+"<br/>");
	    //�������߻���û���session����
		HttpSession session =  request.getSession();
		//��Session �����л���û��Ĺ��ﳵ
		List<Book> cart =  (List) session.getAttribute("cart");
		if (cart == null){
			//�״ι���Ϊ�û�����һ�����ﳵ��List����ģ�⹺�ﳵ��
			cart = new ArrayList<Book>();
			//�����ﳵ����Session����
			session.setAttribute("cart", cart);
			
		}
		//����Ʒ���빺�ﳵ
		cart.add(book);
		//����Cookie���Session�ı�ʶ��
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*30);
		cookie.setPath("/charp111_easy");
		response.addCookie(cookie);
		//�ض��򵽹��ﳵҳ��
		String url="/charp111_easy/computer.jsp";
		response.sendRedirect(url);
	}

}

