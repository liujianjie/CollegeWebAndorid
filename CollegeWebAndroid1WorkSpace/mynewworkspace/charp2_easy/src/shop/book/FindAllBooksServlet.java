package shop.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import goods.entity.Book;

/**
 * Servlet implementation class FindAllBooksServlet
 */
@WebServlet("/FindAllBooksServlet")
public class FindAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDao bookdao=new BookDao();
		List<Book> list = new ArrayList<Book>();
		list=bookdao.findAll();
	
		String cata=request.getParameter("catalog");
		int catalog=0;
		if(cata!=null) catalog=Integer.parseInt(cata);
		if(list!=null)
		{
			request.getSession().setAttribute("books", list);			
			//request.getRequestDispatcher("/computer.jsp").forward(request, response);	
			String flag=request.getParameter("flag");
			if(flag!=null &&flag.equals("1"))//根据标志确定是前台还是后台需要获取商品全部信息
				response.sendRedirect(request.getContextPath()+"/admin/goods/goods.jsp");
			else
			{
				switch(catalog)
				{
				 	case 1:response.sendRedirect(request.getContextPath()+"/computer.jsp");break;
					case 2:response.sendRedirect(request.getContextPath()+"/literature.jsp");break;
					case 3:response.sendRedirect(request.getContextPath()+"/history.jsp");break;
					case 4:response.sendRedirect(request.getContextPath()+"/biography.jsp");break;
					case 5:response.sendRedirect(request.getContextPath()+"/youth.jsp");break;
					case 6:response.sendRedirect(request.getContextPath()+"/socialScience.jsp");break;
					case 7:response.sendRedirect(request.getContextPath()+"/psychological.jsp");break;
					case 8:response.sendRedirect(request.getContextPath()+"/economic.jsp");break;
					case 9:response.sendRedirect(request.getContextPath()+"/management.jsp");break;
				}
			    
			}
			
		}
		
	}

}
