package com.goods.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//����cart�����û��Ĺ��ﳵ
		List<Book> cart =null;
		//����û���session
		HttpSession session =request.getSession();
		//����û����ﳵ
		cart = (List) session.getAttribute("cart");
		//���sessionΪnull,purFlag��Ϊfalse
	    if (cart == null){
			out.write("�Բ���!����û�й����κ���Ʒ!<br/>");
		}
	    else{
			//������ʾ�û�����ͼ�����Ϣ
			out.write("�������ͼ����:<br/>");
	
			for (Book book : cart){
				out.write(book.getName()+"<br />");
				
			}
		}
	}
}
	

	

