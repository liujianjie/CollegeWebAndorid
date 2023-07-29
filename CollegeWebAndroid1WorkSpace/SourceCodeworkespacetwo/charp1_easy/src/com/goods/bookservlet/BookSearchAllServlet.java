package com.goods.bookservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goods.bean.Book;
import com.goods.dao.BookDao;

/**
 * Servlet implementation class BookSearchAllServlet
 * 查找图书servlet，想根据分类读取指定图书或者读取所有图书
 */
@WebServlet("/BookSearchAllServlet")
public class BookSearchAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 实例化操作goods表的对象
		BookDao bdao = new BookDao();
		// 实例化一个list，存储多个book图书对象
		List<Book> booklist = new ArrayList<Book>();
		// 通过bookdao读取所有数据库图书信息至list对象
		booklist = bdao.findAllBook();
		// 获取页面传递的catalog分类属性
		String cata = request.getParameter("catalog");
		int catalog = 0;
		// 如果传递过来的分类属性不为空，那么转换为int值
		if (cata != null){
			catalog = Integer.parseInt(cata);
		}
		// 用session保存查找的所有图书信息
		request.getSession().setAttribute("books", booklist);
		// 获取页面传递的flag属性，flag来判断是查询分类图书，还是全部图书
		String flag = request.getParameter("flag");
		// 不为空，且为1
		if (flag != null && flag.equals("1"))
			// 去后台所有管理图书界面
			response.sendRedirect(request.getContextPath() + "/admin/goods/goods.jsp");
		else {
			// 根据分类跳转到不同图书页面
			switch (catalog) {
			case 1:
				// 跳转计算机图书界面
				response.sendRedirect(request.getContextPath() + "/computer.jsp");
				break;
			case 2:
				// 跳转艺术图书界面
				response.sendRedirect(request.getContextPath() + "/art.jsp");
				break;
			case 3:
				// 跳转外语图书界面
				response.sendRedirect(request.getContextPath() + "/english.jsp");
				break;
			}

		}

	}


}
