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
 * Servlet implementation class BookSearchByIdServlet
 * 根据商品Id查询指定图书信息servlet，为了做修改用
 */
@WebServlet("/BookSearchByIdServlet")
public class BookSearchByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 实例化操作goods表的对象
		BookDao bdao = new BookDao();
		// 获取页面传递的id属性
		Integer id = Integer.parseInt(request.getParameter("id"));
		// 根据id找到指定图书
		Book book = bdao.findOneBook(id);
		// 用request保存图书属性
		request.setAttribute("book", book);
		// 跳转到修改图书界面
		request.getRequestDispatcher("/admin/goods/edit.jsp").forward(request, response);
	}

}
