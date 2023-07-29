package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SjwdServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("进来了");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter write=resp.getWriter();
		String name=req.getParameter("name");
		name=new String(name.getBytes("iso-8859-1"),"utf-8");
		System.out.println(name);
		//保存在list中 list又保存在session中 一一对比有没有重复
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("list");
		boolean bln=false;
		//第一个
		if(obj==null){
			List list=new ArrayList();
			list.add(name);
			//用session保存list啊
			session.setAttribute("list", list);
		}else{//第二个
			System.out.println("进来 吧");
			List list=(List)obj;
			//就要对比有没有了
			for(int i=0;i<list.size();i++){
				//System.out.println(list.get(i));
				if(name.equals(list.get(i)))
				{
					bln=true;
				}
				
			}
			//如果没有相同的话就保存
			if(!bln){	
				list.add(name);
				session.setAttribute("list", list);
			}
		}
		System.out.println(bln);
		String str="";
		if(bln){//有了
			str="有";
		}else{
			str="没有";
		}
		write.print(str);
		write.flush();
		write.close();
	}
	
}
