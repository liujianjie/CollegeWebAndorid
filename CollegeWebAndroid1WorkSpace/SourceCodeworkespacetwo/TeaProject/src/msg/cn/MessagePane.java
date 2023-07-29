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
			request.setAttribute("success", "���۳ɹ�");
			request.getRequestDispatcher("appli/submit.jsp").forward(request, response);
			//response.sendRedirect(request.getContextPath()+"/appli/submit.jsp");

//			String date=new Date().toLocaleString();
////		if(name.equals("")) {name="";}
////		if(title.equals("")) {title="�ޱ���";}
////		if(message.equals("")) {message="����Ϣ";}
//		if("".equals(name)) {name="";}
//		if("�ޱ���".equals(title)) {title="�ޱ���";}
//		if("����Ϣ".equals(message)) {message="����Ϣ";}
//		
//		String s="<tr>"+"<td>"+"�ǳƣ�"+name+"<br>"+
//					"<img src="+pic+">"+"</td>"+
//					"<td>"+"���⣺"+"<b>"+title+"</b>"+
//					"<br>"+"�����ڣ�"+date+
//					"<br>"+"���ݣ�"+message+"</td>"+"</tr>";
	}

}
