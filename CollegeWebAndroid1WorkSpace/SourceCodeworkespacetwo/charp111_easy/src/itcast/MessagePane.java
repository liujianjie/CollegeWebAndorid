package itcast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessagePane
 */
@WebServlet("/MessagePane")
public class MessagePane extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				List<String> list;
				request.setCharacterEncoding("UTF-8");
				String name=request.getParameter("peopleName");
				       String title=request.getParameter("Title");
				       String pic= request.getParameter("pic");
				       String message= request.getParameter("message");
				       String date= new Date().toLocaleString();
				       if (name.equals(""))
				       { name="";}
				       if(title.equals("")){ title="无标题";}
				       if(message.equals(""))
				       { message="无信息";}
				       String s="<tr>"+"<td>"+"昵称："+name+"<br>"+"<img src="+pic+">"+"</td>"+"<td>"+
				       		"标题："+"<b>"+title+"</b>"+"<br>"+"发表于: "+date+"<br>"+"内容："+message+"</td>"+"</tr>";
				      ServletContext application=this.getServletContext();//application 
				      list=(ArrayList)application.getAttribute("Mess");
				      if(list==null){
				    	  list=new ArrayList<String>();
				      }
				      list.add(s);
				      application.setAttribute("Mess", list);
				      
				      request.setAttribute("success", "您的评论已经提交成功");
				      request.getRequestDispatcher("appli/submit.jsp").forward(request, response);
				      // response.sendRedirect(request.getContextPath()+"/appli/submit.jsp");
			}

		}