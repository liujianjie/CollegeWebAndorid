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
 * 修改图书servlet
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
		// 设置编码格式,以防中文乱码
		request.setCharacterEncoding("utf-8");
		// 实例化操作goods表的对象
		BookDao bdao = new BookDao();
		// 获取页面需要修改的图书id
		int id = Integer.parseInt(request.getParameter("id"));
		// 获取页面修改后的图书名称
		String name = request.getParameter("name");
		// 获取页面修改后的图书价格
		String prices = request.getParameter("price");
		Double price = Double.parseDouble(prices);
		
		// 实例化一个book对象来存储临时信息
		Book book = new Book();
		// 用book存储页面传递过来的信息
		book.setId(id);
		book.setName(name);
		book.setPrice(price);
		// 用bookdao执行修改图书操作
		bdao.updateBook(book);
		// 修改完图书信息后需要重新查找所有图书信息
		request.getRequestDispatcher("/BookSearchAllServlet?flag=1").forward(request, response);
	}

}
