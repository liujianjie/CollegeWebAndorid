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
import javax.servlet.http.HttpSession;

import com.dc.dao.BgLogin.UserDAOImpl;
import com.dc.dao.Empinfo.EmpDAO;
import com.dc.dao.Empinfo.EmpDAOImpl;


public class ChangeEmp extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String empid=request.getParameter("empid");
		EmpDAO dao=new EmpDAOImpl();
		List<HashMap> list=dao.selectOneEmpById(empid);
		//System.out.println(empid+"empid");
		//System.out.println(list+"list");
		Map oneemp=new HashMap();
		if(list!=null&&list.size()>0){
			oneemp=list.get(0);
		}
		//查询部门的所有内容
		HttpSession sess=request.getSession();
		List<HashMap> dutyinfo=dao.selectAllDuty();
		List<HashMap> departinfo=dao.selectAllDepart();
		//System.out.println(departinfo+"depart");
		request.setAttribute("dutyinfo", dutyinfo);
		request.setAttribute("departinfo", departinfo);
		
		
		request.setAttribute("oneemp", oneemp);
		//System.out.println(oneemp+"oneemp");
		request.setAttribute("empid", empid);
		request.getRequestDispatcher("/module/Empinfo/ChangeOrAddEmp.jsp").forward(request, response);
	}

}
