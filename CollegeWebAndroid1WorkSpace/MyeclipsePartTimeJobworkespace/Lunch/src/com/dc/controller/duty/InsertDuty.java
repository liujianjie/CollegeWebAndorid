package com.dc.controller.duty;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dc.dao.duty.DutyDAO;
import com.dc.dao.duty.DutyDAOImpl;
import com.dc.util.StringUtil;

public class InsertDuty extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String departname=request.getParameter("departname");
		String dutyid=request.getParameter("dutyid").toString();
		String dutyname=request.getParameter("dutyname");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
        Map map=(Map) session.getAttribute("userinfo");
        String accountid=map.get("emp_account_id").toString();
        String empuser=map.get("emp_user").toString();
		DutyDAO duty=new DutyDAOImpl();
		if(StringUtil.checkNotNull(dutyid)){
			duty.updateDuty(departname, dutyid, dutyname,accountid,empuser);
			out.print("{\"state\":\"true\",\"message\":\"修改成功\"}");
		}else{
			duty.insertDuty(departname, dutyname,accountid,empuser);
			out.print("{\"state\":\"true\",\"message\":\"添加成功\"}");
		}
		
		
	}

}
