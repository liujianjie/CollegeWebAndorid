package com.dc.controller.duty;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.duty.DutyDAO;
import com.dc.dao.duty.DutyDAOImpl;
import com.dc.util.StringUtil;

public class UpdateDuty extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String dutyid=request.getParameter("dutyid");
		DutyDAO duty=new DutyDAOImpl();
		if(StringUtil.checkNotNull(dutyid)){			
			Map map=duty.findById(dutyid);
			request.setAttribute("map",map);
		}
		List list=duty.findDepartName();
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/module/Duty/UpdateDuty.jsp").forward(request, response);
	}

}
