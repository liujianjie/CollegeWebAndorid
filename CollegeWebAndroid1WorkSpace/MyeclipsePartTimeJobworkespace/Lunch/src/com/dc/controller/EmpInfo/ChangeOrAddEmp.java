package com.dc.controller.EmpInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dc.dao.Empinfo.EmpDAO;
import com.dc.dao.Empinfo.EmpDAOImpl;
import com.dc.util.StringUtil;



public class ChangeOrAddEmp extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String empname=request.getParameter("empname");
		String phone=request.getParameter("phone");
		String username=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		String accountid=request.getParameter("accountid");
		String empid=request.getParameter("empid");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String district=request.getParameter("district");
		String day=request.getParameter("day");
		String month=request.getParameter("month");
		String year=request.getParameter("year");
		String age=request.getParameter("age");
		String sex=request.getParameter("sex");
		String dutyname=request.getParameter("dutyname");
		String departid=request.getParameter("departid");
		//String roleid=request.getParameter("rolename");
		String address=request.getParameter("address");
		//System.out.println("修改内容"+empid+"/"+empname+"/"+phone+"/"+pwd+"/"+accountid+sex+age+year+month+day+district+city+province);
		//System.out.println(roleid+departid);
		HttpSession sess=request.getSession();
		Map map=(Map) sess.getAttribute("userinfo");
		String ssuserid=null;
		String ssusername=null;
		if(StringUtil.checkNotNull(sess.getAttribute("userinfo"))){
		ssuserid=map.get("emp_id").toString();
		ssusername=map.get("emp_user").toString();
		}
		EmpDAO dao=new EmpDAOImpl();
		if(StringUtil.checkNotNull(accountid)){
			int i=dao.updateThisEmp(departid,ssuserid,ssusername,accountid,empid,empname,phone,pwd,username,province,city,district,day,month,year,age,sex,address,dutyname);
			if(i==1){
				out.print("修改成功");
			}
			else{
				out.print("修改失败");
			}
		}else{
			int i=dao.insertOneEmp(departid,ssuserid,ssusername,empname,phone,username,pwd,province,city,district,day,month,year,age,sex,address,dutyname);
			if(i==1){
				out.print("新增成功");
			}
			else{
				out.print("新增失败");
			}
		}
	}

}
