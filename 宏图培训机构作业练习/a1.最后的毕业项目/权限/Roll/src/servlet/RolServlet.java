package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import serviceimpl.RollService;

public class RolServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��¼
		RollService ros=new RollService();
		//���û�����
		String method=request.getParameter("method");
		if(method.equals("login")){
			//�����û�ID��ѯ�û�Ȩ��
			String loginid=request.getParameter("loginid");
			List list = ros.queryrollbyuid(Integer.parseInt(loginid));
			request.getSession().setAttribute("rolllist", list);
			response.sendRedirect("index.jsp");
		}else if(method.equals("queryuserroll")){
			String strid= request.getParameter("uid");
			List list = ros.queryrollbyuid(Integer.parseInt(strid));
			request.setAttribute("listss", list);
			request.setAttribute("rolluid", Integer.parseInt(strid));
			request.getRequestDispatcher("rolls.jsp").forward(request, response);
		}else if(method.equals("manageroll")){
			//ά��Ȩ��
			String[] rolls = request.getParameterValues("inp");
			String rolluidstr=request.getParameter("rolluid");
			//�����ԭ�е�Ȩ�� �������û�IDɾ�����о����ݣ�
			ros.delrollbyuid(Integer.parseInt(rolluidstr));
			//�����µ�Ȩ������
			for (int i = 0; i < rolls.length; i++) {
				ros.saverollbyuid(Integer.parseInt(rolluidstr), Integer.parseInt(rolls[i]));
			}
		}
		
		
	}

}
