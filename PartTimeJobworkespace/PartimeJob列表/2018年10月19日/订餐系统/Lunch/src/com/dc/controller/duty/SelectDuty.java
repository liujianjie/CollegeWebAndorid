package com.dc.controller.duty;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.duty.DutyDAO;
import com.dc.dao.duty.DutyDAOImpl;
import com.dc.entity.PageEntity;
import com.dc.util.StringUtil;

public class SelectDuty extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String dutyname=request.getParameter("dutyname");
		String departname=request.getParameter("departname");
		Map map=new HashMap();
		map.put("dutyname", dutyname);
		map.put("departname", departname);
		String nowpage=request.getParameter("nowpage");
		int npage=0;
		if(StringUtil.checkNotNull(nowpage)){
			npage=Integer.parseInt(nowpage);
		}else{
			npage=1;
		}
		PageEntity page=new PageEntity();
		page.setNowpage(npage);
		DutyDAO duty=new DutyDAOImpl();
		List list=duty.findDuty(map, page);
		request.setAttribute("list", list);
		request.setAttribute("map", map);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/module/Duty/SelectDuty.jsp").forward(request, response);
		
		
	}

}
