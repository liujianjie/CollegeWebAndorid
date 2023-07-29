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
		//获得用户购买的商品
		String id =request.getParameter("id");
		Book book =BookDB.getBook(id);
		System.out.println(book.getName()+"<br/>");
	    //创建或者获得用户的session对像
		HttpSession session =  request.getSession();
		//从Session 对象中获得用户的购物车
		List<Book> cart =  (List) session.getAttribute("cart");
		if (cart == null){
			//首次购买，为用户创建一个购物车（List集合模拟购物车）
			cart = new ArrayList<Book>();
			//将购物车存入Session对象
			session.setAttribute("cart", cart);
			
		}
		//将商品放入购物车
		cart.add(book);
		//创建Cookie存放Session的标识号
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*30);
		cookie.setPath("/charp111_easy");
		response.addCookie(cookie);
		//重定向到购物车页面
		String url="/charp111_easy/computer.jsp";
		response.sendRedirect(url);
	}

}

