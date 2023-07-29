package com.dc.controller.department;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.department.DepartDAO;
import com.dc.dao.department.DepartDAOImpl;
import com.dc.entity.PageEntity;
import com.dc.util.StringUtil;

public class SelectDepart extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String nowpage=request.getParameter("nowpage");
		String departname=request.getParameter("departname");
		System.out.println(departname);
		int npage=0;
		if(StringUtil.checkNotNull(nowpage)){
			npage=Integer.parseInt(nowpage);
		}else{
			npage=1;
		}
		PageEntity page=new PageEntity();
		page.setNowpage(npage);
		DepartDAO depart=new DepartDAOImpl();
		List list=depart.findDepart(page,departname);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		request.setAttribute("departname", departname);
		request.getRequestDispatcher("/module/Depart/SelectDepart.jsp").forward(request, response);
		
	}

}
