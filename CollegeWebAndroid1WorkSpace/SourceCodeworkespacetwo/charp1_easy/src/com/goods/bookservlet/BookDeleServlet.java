package com.goods.bookservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goods.dao.BookDao;

/**
 * Servlet implementation class BookDeleServlet
 * 删除图书servlet
 */
@WebServlet("/BookDeleServlet")
public class BookDeleServlet extends HttpServlet {
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
		// 获取从页面传过来的参数id
		Integer id = Integer.parseInt(request.getParameter("id"));
		// 删除goods表中由页面通过id对应数据库表中的唯一图书
		bdao.deleteById(id);
		// 删除完图书需要重新查询所有图书，跳到BookSearchAllServlet中
		request.getRequestDispatcher("/BookSearchAllServlet?flag=1").forward(request, response);
	}

}
