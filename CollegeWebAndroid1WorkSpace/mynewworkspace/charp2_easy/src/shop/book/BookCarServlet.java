package shop.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookCarDao;
import dao.BookDao;
import goods.entity.Book;
import goods.entity.BookCar;

/**
 * Servlet implementation class FindAllBooksServlet
 */
@WebServlet("/FindAllBookCarServlet")
public class BookCarServlet extends HttpServlet {
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
		BookCarDao bookdao=new BookCarDao();
		List<BookCar> list = new ArrayList<BookCar>();
		list=bookdao.findAll();
		if(list!=null)
		{
			request.getSession().setAttribute("cart", list);
			//request.getRequestDispatcher("/computer.jsp").forward(request, response);	
			response.sendRedirect(request.getContextPath()+"/cartshow.jsp");
		}
		
	}

}
