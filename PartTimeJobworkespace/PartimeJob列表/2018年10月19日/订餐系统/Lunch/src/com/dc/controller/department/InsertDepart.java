package com.dc.controller.department;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dc.dao.department.DepartDAO;
import com.dc.dao.department.DepartDAOImpl;
import com.dc.util.StringUtil;

public class InsertDepart extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String departid=request.getParameter("departid");
		String departname=request.getParameter("departname");
		String departdesc=request.getParameter("departdesc");
		DepartDAO depart=new DepartDAOImpl();
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
        Map map=(Map) session.getAttribute("userinfo");
        String accountid=map.get("emp_account_id").toString();
        String empuser=map.get("emp_user").toString();
		
		if(StringUtil.checkNotNull(departid)){
			depart.updateDepart(departid, departname, departdesc,accountid,empuser);
			out.print("{\"state\":\"true\",\"message\":\"修改成功\"}");
		}else{
			depart.insertDepart(departname, departdesc,accountid,empuser);
			out.print("{\"state\":\"true\",\"message\":\"添加成功\"}");
		}
	}

}
