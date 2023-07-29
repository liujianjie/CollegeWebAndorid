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
		//登录
		RollService ros=new RollService();
		//查用户对象
		String method=request.getParameter("method");
		if(method.equals("login")){
			//根据用户ID查询用户权限
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
			//维护权限
			String[] rolls = request.getParameterValues("inp");
			String rolluidstr=request.getParameter("rolluid");
			//先清空原有的权限 （根据用户ID删除所有旧数据）
			ros.delrollbyuid(Integer.parseInt(rolluidstr));
			//保存新的权限数据
			for (int i = 0; i < rolls.length; i++) {
				ros.saverollbyuid(Integer.parseInt(rolluidstr), Integer.parseInt(rolls[i]));
			}
		}
		
		
	}

}
