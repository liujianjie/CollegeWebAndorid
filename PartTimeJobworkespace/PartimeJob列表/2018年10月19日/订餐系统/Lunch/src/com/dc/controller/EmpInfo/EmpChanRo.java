package com.dc.controller.EmpInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.Empinfo.EmpDAO;
import com.dc.dao.Empinfo.EmpDAOImpl;

public class EmpChanRo extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String empaccountid=request.getParameter("empaccountid");
		String empname=request.getParameter("empname");
		request.setAttribute("empaccountid", empaccountid);
		request.setAttribute("empname", empname);
		EmpDAO dao=new EmpDAOImpl();
		//��ѯԱ�������н�ɫ
		List<HashMap> roleinfo=dao.selectAllRole();
		//System.out.println(roleinfo+"role");
		request.setAttribute("roleinfo", roleinfo);
		//��ѯԱһԱ����ɫ
		List<HashMap> emprole=dao.selectEmpRole(empaccountid);
		request.setAttribute("oneemprole", emprole);
		request.getRequestDispatcher("/module/Empinfo/ChangeEmprole.jsp").forward(request, response);
		
	}

}
