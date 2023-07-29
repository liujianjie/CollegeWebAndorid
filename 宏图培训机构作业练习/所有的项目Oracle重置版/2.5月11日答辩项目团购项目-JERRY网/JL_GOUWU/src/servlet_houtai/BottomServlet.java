package servlet_houtai;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BottomBean;
import bean.MoldBean;
import service_bottom.BottomImp;
import service_bottom.Ibottom;

public class BottomServlet extends HttpServlet{
	Ibottom ss=new BottomImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
			
		if(method.equals("list")){
			List list=ss.selbottom();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("houtai_caozuo/Bottomlist.jsp").forward(request, response);
		}else if(method.equals("del")){
			String ID=request.getParameter("id");
			
			boolean bln=ss.delbottom(Integer.parseInt(ID));
			
			if(bln){
				request.getRequestDispatcher("/bottom?method=list").forward(request, response);
			}
		}else if(method.equals("toadd")){
			List list=ss.selMold();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("houtai_caozuo/Bottomadd.jsp").forward(request, response);
			
		}else if(method.equals("add")){
			String name=request.getParameter("uname");
			String select=request.getParameter("select");
			BottomBean bot=new BottomBean();
			bot.setBottom(name);
			bot.setMold_id(Integer.parseInt(select));
			ss.addbottom(bot);
			request.getRequestDispatcher("/bottom?method=list").forward(request, response);			
		}else if(method.equals("goalert")){
			String ID=request.getParameter("id");
			
			BottomBean bot=ss.selhang(Integer.parseInt(ID));

			request.setAttribute("bot", bot);
			
			List list=ss.selMold();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("houtai_caozuo/alertBottom.jsp").forward(request, response);
		}else if(method.equals("alert")){
			String ID=request.getParameter("id");
			String name=request.getParameter("uname");
			String Select=request.getParameter("select");
			int id=Integer.parseInt(ID);
			int select=Integer.parseInt(Select);

			BottomBean bot=new BottomBean();
			bot.setBottom_id(id);
			bot.setBottom(name);
			bot.setMold_id(select);
			
			boolean bln=ss.alerthang(bot);
			
			request.getRequestDispatcher("/bottom?method=list").forward(request, response);
		}
	}
}
