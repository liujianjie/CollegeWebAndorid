package shop.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goods.entity.Book;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//得到购物车
		List<Book> cart = null;
		//得到用户自己的session
		HttpSession session = request.getSession(false);
		//自己定义一个flag，判断购物车里是否有图书
		boolean cartFlag = true;
		if(session==null) {
			cartFlag=false;
		}else {
			cart = (List<Book>) session.getAttribute("cart");
			if(cart==null) {
				cartFlag=false;
			}
		}//购物车就有商品了
		if(!cartFlag) {
			out.print("！！！购物车竟然是空的！！！");
		}else {
			for(Book b:cart) {
				out.print("购买的图书："+b.getName()+"<br />");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
