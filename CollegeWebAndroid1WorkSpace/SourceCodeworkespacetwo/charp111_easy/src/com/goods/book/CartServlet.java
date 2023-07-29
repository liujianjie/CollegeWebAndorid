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
		//变量cart引用用户的购物车
		List<Book> cart =null;
		//获得用户的session
		HttpSession session =request.getSession();
		//获得用户购物车
		cart = (List) session.getAttribute("cart");
		//如果session为null,purFlag置为false
	    if (cart == null){
			out.write("对不起!您还没有购买任何商品!<br/>");
		}
	    else{
			//否则显示用户购买图书的信息
			out.write("您购买的图书有:<br/>");
	
			for (Book book : cart){
				out.write(book.getName()+"<br />");
				
			}
		}
	}
}
	

	

