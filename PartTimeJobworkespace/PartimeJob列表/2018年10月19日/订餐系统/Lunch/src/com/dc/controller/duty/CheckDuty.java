package com.dc.controller.duty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.duty.DutyDAO;
import com.dc.dao.duty.DutyDAOImpl;

public class CheckDuty extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String dutyname=request.getParameter("dutyname");
		String dutyid=request.getParameter("dutyid").toString();
		DutyDAO duty=new DutyDAOImpl();
		boolean state=duty.checkDuty(dutyname, dutyid);
		PrintWriter out=response.getWriter();
		if(state){
			out.print("{\"state\":1}");
		}else{
			out.print("{\"state\":0}");
		}
		
	}

}
