package com.dc.controller.Role;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.Role.UserDAO;
import com.dc.dao.Role.UserDAOImpl;
import com.dc.entity.PageEntity;

public class FindRole extends HttpServlet {

	/***
	 * 查询所有角色带分页
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
		String rolelevel=request.getParameter("rolelevel");  
		String nowpage=request.getParameter("nowpage");
	    int pageN=0;
	    if(com.dc.util.StringUtil.checkNotNull(nowpage)){
	    	pageN=Integer.parseInt(nowpage);
	    }else{
	    	pageN=1;
	    }
		PageEntity page=new PageEntity();
		page.setNowpage(pageN);
		Map map=new HashMap();
		map.put("rolename", rolename);
		map.put("rolelevel", rolelevel);
		UserDAO user=new UserDAOImpl();
		List list=user.findRole(map,page);
		request.setAttribute("page", page);
		request.setAttribute("usermap", map);
		request.setAttribute("userlist",list);
		request.getRequestDispatcher("/module/Role/FindRole.jsp").forward(request, response);
	}

}
