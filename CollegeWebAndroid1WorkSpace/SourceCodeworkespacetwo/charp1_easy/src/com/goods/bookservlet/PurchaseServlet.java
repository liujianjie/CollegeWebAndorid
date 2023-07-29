package com.goods.bookservlet;

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

import com.goods.bean.Book;
import com.goods.bean.BookNum;
import com.goods.dao.BookDao;

/**
 * 添加图书到购物车的servlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 实例化操作goods表的对象
		BookDao bdao = new BookDao();
		// 获取页面传递的id属性
		int id = Integer.parseInt(request.getParameter("id"));
		// 根据id找到数据库中指定图书信息
		Book book = bdao.findOneBook(id);

		// 获取session对像
		HttpSession session = request.getSession();
		//创建Cookie存放Session的标识号，设置保存session的时间
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*30);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		
		// 从session 对象中获得购物车信息，强制转换为List对象
		List<BookNum> cart = (List) session.getAttribute("cart");
		
		if (cart == null) {
			// 首次购买，为用户创建一个购物车（List集合模拟购物车）
			cart = new ArrayList<BookNum>();
			// 将购物车存入Session对象
			session.setAttribute("cart", cart);
		}
		boolean noexit = true;
		// 将商品放入购物车，遍历购物车所有图书，根据id来判断要加入的图书是否存在购物车中，是数量+1，否则添加这个图书到购物车中
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getId() == book.getId()) {
				int num = cart.get(i).getNum();// 先获取有多少个数量
				cart.get(i).setNum(num + 1);// 将数量加+1
				noexit = false;// 代表存在
				break;
			}
		}
		// 根据bool变量判断是否存在，不存在就添加
		if (noexit) {
			// BookCart对象来存储从数据库读取的book数据，再保存到购物车session中
			BookNum bookc = new BookNum();
			bookc.setId(book.getId());//id
			bookc.setName(book.getName());// 名称
			bookc.setNum(1);// 数量
			bookc.setPic(book.getPic());// 图片地址
			bookc.setPrice(book.getPrice());// 价格
			cart.add(bookc);// 添加
		}

		// 重定向到计算机页面
		response.sendRedirect(request.getContextPath() + "/computer.jsp");
	}
}
