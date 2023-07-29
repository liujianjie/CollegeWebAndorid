package com.dc.controller.Role;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.Role.RolefunDAO;
import com.dc.dao.Role.RolefunDAOImpl;

public class UpdateRolefun extends HttpServlet {
	/**
	 * 功能授权的servlet
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
     String[] functionid=request.getParameterValues("functionid");
     RolefunDAO user=new RolefunDAOImpl();
     int state=user.updateAllFunction(roleid, functionid);
     PrintWriter out=response.getWriter();
     if(state<0){
    	 out.print("{\"state\":false,\"message\":\"保存失败！\"}");
     }else{
    	 out.print("{\"state\":true,\"message\":\"保存成功！\"}");
      }
	}

}
