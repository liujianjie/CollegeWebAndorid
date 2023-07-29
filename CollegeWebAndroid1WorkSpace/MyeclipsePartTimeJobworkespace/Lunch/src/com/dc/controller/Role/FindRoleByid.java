package com.dc.controller.Role;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.Role.UserDAO;
import com.dc.dao.Role.UserDAOImpl;

public class FindRoleByid extends HttpServlet {

	/***
	 * 根据角色id进行查询
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      String roleid=request.getParameter("roleid");
      UserDAO user=new UserDAOImpl();
      Map map=user.findRoleByid(roleid);
      List list=user.selectAllState();
      List list2=user.selectAllRolelevel();
      request.setAttribute("state", list);
      request.setAttribute("rolelevel", list2);
      request.setAttribute("rolemap",map);
      request.getRequestDispatcher("/module/Role/AddRole.jsp").forward(request, response);
	}

}
