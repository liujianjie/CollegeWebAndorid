package servlet_houtai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.JRuserBean;

public class JieShou extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out
//				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the GET method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
		this.doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		
		if(method.equals("jieshou")){//�ͻ��������˷���Ϣ
			ServletContext sc=this.getServletContext();//applctionʵ����
			
			//��ȡ�Լ�������
			HttpSession session=request.getSession();
			JRuserBean jr=(JRuserBean)session.getAttribute("jruser");
			String uname=jr.getUname();
			
			String amessage=(String) sc.getAttribute("message");//��ȡԭ��������
			
			sc.setAttribute("message", amessage+uname+"˵:"+request.getParameter("message")+"\r\n");
			
			response.sendRedirect("qiantai_chart/khdchart.jsp");
		}else if(method.equals("send")){//�������ͻ��˷���Ϣ
			ServletContext sc=this.getServletContext();
			
			String uname="�̼�";
			
			String amessage=(String) sc.getAttribute("message");
			
			sc.setAttribute("message", amessage+uname+"˵:"+request.getParameter("message")+"\r\n");
			
			response.sendRedirect("qiantai_chart/fwdchart.jsp");
	
		}else if(method.equals("test")){
			PrintWriter out = response.getWriter();
			
			ServletContext sc=this.getServletContext();
			
			//String uname=(String) request.getSession().getAttribute("aa");
			String uname="��";

			String amessage=(String) sc.getAttribute("message");
			
			sc.setAttribute("message", amessage+uname+"˵:"+request.getParameter("message")+"\r\n");
			
			response.sendRedirect("1.jsp");

		}else if(method.equals("khdbaocun")){
			
			String neirong=request.getParameter("neirong");
			
			String outStr = new String(neirong.getBytes("iso-8859-1"),"UTF-8");
			//System.out.println(outStr);
			request.setAttribute("neirong", outStr);
			
			request.getRequestDispatcher("qiantai_chart/khdchart.jsp").forward(request, response);

		}else if(method.equals("fwdbaocun")){
			String neirong=request.getParameter("neirong");
			
			String outStr = new String(neirong.getBytes("iso-8859-1"),"UTF-8");
			//System.out.println(outStr);
			request.setAttribute("neirong", outStr);
			
			request.getRequestDispatcher("qiantai_chart/fwdchart.jsp").forward(request, response);

		}
		
	}

}
