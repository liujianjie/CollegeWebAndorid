package com.dc.controller.Role;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.Role.UserDAO;
import com.dc.dao.Role.UserDAOImpl;

public class UpdateState extends HttpServlet {

	/***
	 * �޸�״̬
	*/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           request.setCharacterEncoding("utf-8");
           response.setCharacterEncoding("utf-8");
           String roleid=request.getParameter("roleid");
   		  String state=request.getParameter("state");
   		  UserDAO user=new UserDAOImpl();
   		boolean result=user.upOrDown(state, roleid);
   		PrintWriter out=response.getWriter();
   		if(result){
   			out.print("{\"result\":"+result+",\"message\":\"״̬���ĳɹ���\"}");
   		}else{
   			out.print("{\"result\":"+result+",\"message\":\"״̬����ʧ�ܣ�\"}");
	    }
	}
}