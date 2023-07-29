package msg.cn;

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

import msg.bean.Message;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Message> list;
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("peopleName");
		String title = request.getParameter("Title");
		String pic = request.getParameter("pic");
		String message = request.getParameter("message");

		Message m = new Message();
		m.setDate();
		m.setTitle(title);
		m.setMessage(message);
		m.setName(name);
		m.setPic(pic);
		
		
		ServletContext application=this.getServletContext(); //application
		list=(ArrayList)application.getAttribute("Mess");
		if(list==null) {
			list = new ArrayList<Message>();
		}
		list.add(m);
			application.setAttribute("Mess", list);
			request.setAttribute("success", "评论成功");
			request.getRequestDispatcher("appli/submit.jsp").forward(request, response);
			//response.sendRedirect(request.getContextPath()+"/appli/submit.jsp");

//			String date=new Date().toLocaleString();
////		if(name.equals("")) {name="";}
////		if(title.equals("")) {title="无标题";}
////		if(message.equals("")) {message="无信息";}
//		if("".equals(name)) {name="";}
//		if("无标题".equals(title)) {title="无标题";}
//		if("无信息".equals(message)) {message="无信息";}
//		
//		String s="<tr>"+"<td>"+"昵称："+name+"<br>"+
//					"<img src="+pic+">"+"</td>"+
//					"<td>"+"标题："+"<b>"+title+"</b>"+
//					"<br>"+"发表于："+date+
//					"<br>"+"内容："+message+"</td>"+"</tr>";
	}

}
