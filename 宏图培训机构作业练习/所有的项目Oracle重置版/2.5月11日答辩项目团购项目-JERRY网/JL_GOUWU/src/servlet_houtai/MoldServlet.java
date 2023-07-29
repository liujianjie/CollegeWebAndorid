package servlet_houtai;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service_mold.Imold;
import service_mold.MoldImp;

public class MoldServlet extends HttpServlet{
	Imold ss=new MoldImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method.equals("htlist")){
			List list=ss.selmold();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("houtai_caozuo/Moldlist.jsp").forward(request, response);
		}else if(method.equals("qtlist")){
			List list=ss.selmold();
			
			request.setAttribute("list", list);
	
			request.getRequestDispatcher("qiantai_main/left.jsp").forward(request, response);
			
		}
		
	}
	
}
