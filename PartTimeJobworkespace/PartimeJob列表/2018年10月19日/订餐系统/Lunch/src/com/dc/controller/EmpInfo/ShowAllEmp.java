package com.dc.controller.EmpInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.BgLogin.UserDAO;
import com.dc.dao.BgLogin.UserDAOImpl;
import com.dc.entity.PageEntity;
import com.dc.util.StringUtil;


public class ShowAllEmp extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String empname=request.getParameter("empname");
		String empuser=request.getParameter("empuser");
		String nowpage=request.getParameter("nowpage");
		Map map=new HashMap();
		//System.out.println(empname+"/"+empuser);
		map.put("empname", empname);
		map.put("empuser", empuser);
		UserDAO dao=new UserDAOImpl();
		PageEntity page=new PageEntity();
		int pageN=0;
		if(StringUtil.checkNotNull(nowpage)){
			pageN=Integer.parseInt(nowpage);
		}else{
			pageN=1;
		}
		page.setNowpage(pageN);
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		//查询员工的所有信息
		List<HashMap> checklist=dao.selectEmpBycheck(map, page);
		PrintWriter out= response.getWriter();
		request.setAttribute("emplist", checklist);
		request.setAttribute("map", map);
		request.setAttribute("page", page);

		//System.out.println(checklist+"emplist");
		request.getRequestDispatcher("/module/Empinfo/ShowEmp.jsp").forward(request, response);
	}

}
