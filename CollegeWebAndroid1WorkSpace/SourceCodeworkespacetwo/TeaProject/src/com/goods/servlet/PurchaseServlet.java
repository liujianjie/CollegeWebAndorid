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
 * ��ӹ��ﳵ��servlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����û��������Ʒ
		int id =Integer.parseInt(request.getParameter("id"));
		int i=0;
		BookDao  bookdao=new BookDao();
		Book book=bookdao.find(id);
		
	    //�������߻���û���session����
		HttpSession session =  request.getSession();
		//����Cookie���Session�ı�ʶ��
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*30);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		
		//��Session �����л���û��Ĺ��ﳵ
		List<BookCart> cart =  (List) session.getAttribute("cart");
	
		if (cart == null){
			//�״ι���Ϊ�û�����һ�����ﳵ��List����ģ�⹺�ﳵ��
			cart = new ArrayList<BookCart>();
			
			//�����ﳵ����Session����
			session.setAttribute("cart", cart);	
		
		}
		
		//����Ʒ���빺�ﳵ(�жϸ�id��Ӧ��book�Ƿ��Ѿ��ڹ��ﳵ�У��Ѿ����ڣ�����޸�����)
		
		for( i=0;i<cart.size();i++)
		{
			if(cart.get(i).getId()==book.getId()) 
				{ int n=cart.get(i).getCount() ;
				   cart.get(i).setCount(n+1);
				   break;
				}	
		
		}
		//���ﳵ�в����ڴ�ID���飬����빺�ﳵ
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
	
		//�ض��򵽼����ҳ��
			
		response.sendRedirect(request.getContextPath()+"/computer.jsp");
	
		}
}
