package com.dc.controller.Role;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dc.dao.Role.UserDAO;
import com.dc.dao.Role.UserDAOImpl;

public class InsertRole extends HttpServlet {

	/***
	 * 新增和修改角色
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
        String rolename=request.getParameter("rolename");
        String rolestate=request.getParameter("state");
        String rolelevel=request.getParameter("rolelevel");
        String roleid=request.getParameter("roleid");
        HttpSession session=request.getSession();
        Map map=(Map) session.getAttribute("userinfo");
        String userid=map.get("emp_id").toString();
        String username=map.get("emp_user").toString();
        PrintWriter out=response.getWriter();
        UserDAO user=new UserDAOImpl();
        if(com.dc.util.StringUtil.checkNotNull(roleid)){
        	boolean state=user.updateRole(rolename, rolelevel, rolestate, roleid,userid ,username);
        	if(state){
        		out.print("{\"state\":"+state+",\"message\":\"修改成功\"}");
        	}else{
        		out.print("{\"state\":"+state+",\"message\":\"修改失败\"}");
        	}
        }else{
        	boolean state=user.insertRole(rolename, rolelevel, rolestate, userid, username);
        	if(state){
        		out.print("{\"state\":"+state+",\"message\":\"新增成功\"}");
        	}else{
        		out.print("{\"state\":"+state+",\"message\":\"新增失败\"}");
        	}
        }
	}

}
