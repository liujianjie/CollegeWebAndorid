package com.goods.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Book;
//import com.bean.BookDB;

/**
 * Servlet implementation class ListBookServlet
 * 展示所有商品列表，未实现
 */
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
//		  //得到所有图书
//		  Collection<Book> books = BookDB.getAll();
//		  //回显页面
//		  PrintWriter out = response.getWriter();
//		  out.print("以下是本网站售卖的所有图书："+"<br/><br/>");
//		  //遍历集合，把图书回显到页面
//		  for(Book b:books) {
//		   //得到图书名称
//		   String name = b.getName();
//		   int id = b.getId();
//		   //购买图书的连接
//		   String url="<a href='/charp1_easy/PurcharseServlet?id="+id+"'>点击购买</a>";
//		   out.print("图书名称："+name+"		"+url+"<br/><br/>");
//		  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
