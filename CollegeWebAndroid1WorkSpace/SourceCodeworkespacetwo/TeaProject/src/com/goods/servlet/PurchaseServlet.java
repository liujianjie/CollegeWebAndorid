package com.goods.servlet;

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

import com.bean.Book;
import com.bean.BookCart;
import com.dao.BookDao;

/**
 * 添加购物车的servlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得用户购买的商品
		int id =Integer.parseInt(request.getParameter("id"));
		int i=0;
		BookDao  bookdao=new BookDao();
		Book book=bookdao.find(id);
		
	    //创建或者获得用户的session对像
		HttpSession session =  request.getSession();
		//创建Cookie存放Session的标识号
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*30);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		
		//从Session 对象中获得用户的购物车
		List<BookCart> cart =  (List) session.getAttribute("cart");
	
		if (cart == null){
			//首次购买，为用户创建一个购物车（List集合模拟购物车）
			cart = new ArrayList<BookCart>();
			
			//将购物车存入Session对象
			session.setAttribute("cart", cart);	
		
		}
		
		//将商品放入购物车(判断该id对应的book是否已经在购物车中，已经存在，则仅修改数量)
		
		for( i=0;i<cart.size();i++)
		{
			if(cart.get(i).getId()==book.getId()) 
				{ int n=cart.get(i).getCount() ;
				   cart.get(i).setCount(n+1);
				   break;
				}	
		
		}
		//购物车中不存在此ID的书，则加入购物车
		if(i==cart.size())
		{
			BookCart  a=new BookCart();
			a.setId(book.getId());
			a.setName(book.getName());
			a.setCount(1);
			a.setPic(book.getPic());
			a.setPrice(book.getPrice());
		   cart.add(a);		
		}
	
		//重定向到计算机页面
			
		response.sendRedirect(request.getContextPath()+"/computer.jsp");
	
		}
}
