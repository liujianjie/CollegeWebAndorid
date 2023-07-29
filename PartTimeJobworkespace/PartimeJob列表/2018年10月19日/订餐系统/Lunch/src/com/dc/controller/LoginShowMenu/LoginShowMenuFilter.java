package com.dc.controller.LoginShowMenu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dc.dao.LoginShowMenu.ShowLoginMenuDAO;
import com.dc.dao.LoginShowMenu.ShowLoginMenuDAOImpl;

public class LoginShowMenuFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) arg0;
		HttpServletResponse response=(HttpServletResponse) arg1;
		HttpSession sess=request.getSession();
		ShowLoginMenuDAO dao=new ShowLoginMenuDAOImpl();
		List<HashMap> roomlist=dao.selectallRoom();
		List<HashMap> menuList=dao.selectallMenu();
		if(roomlist!=null&&roomlist.size()>0){
			sess.setAttribute("roomlist", roomlist);
			sess.setAttribute("menuList", menuList);
			arg2.doFilter(arg0, arg1);
		}else{
			response.sendRedirect("/Lunch/module/Login/Login.jsp");
		}
		
	}
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
