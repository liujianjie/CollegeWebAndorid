package com.dc.controller.Role;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.Role.RolefunDAO;
import com.dc.dao.Role.RolefunDAOImpl;

public class FunctionsRoleSel extends HttpServlet {

	/**
	 * 查询该角色的功能权限
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        this.doPost(request, response);
	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           request.setCharacterEncoding("utf-8");
           response.setCharacterEncoding("utf-8");
           String roleid=request.getParameter("roleid");
           String rolename=request.getParameter("rolename");
           RolefunDAO user=new RolefunDAOImpl();
           List list=user.Findfunparent(roleid);
           request.setAttribute("list", list);
           request.setAttribute("roleid",roleid);
           request.setAttribute("rolename",rolename);
           request.getRequestDispatcher("/module/Role/Rolefun.jsp").forward(request, response);
	}

}
