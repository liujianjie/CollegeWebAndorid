package com.book.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Book;
import com.dao.BookDao;

/**
 * Servlet implementation class GoodSearchByIdServlet
 * 根据商品Id查询指定图书信息servlet，为了做修改用
 */
@WebServlet("/GoodSearchByIdServlet")
public class GoodSearchByIdServlet extends HttpServlet {
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
		BookDao bookdao = new BookDao();
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		Book book = bookdao.find(id);
		
		request.setAttribute("book", book);
		
		request.getRequestDispatcher("/admin/goods/edit.jsp").forward(request, response);
	}

}
