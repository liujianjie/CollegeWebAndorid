package com.dc.controller.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.Role.RolefunDAO;
import com.dc.dao.Role.RolefunDAOImpl;
import com.dc.dao.goods.GoodsDao;
import com.dc.dao.goods.GoodsDaoImpl;

public class UpdateCai extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * ɾ����Ʒ����
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
	     String mealid=request.getParameter("mealid");
	     String[] caterialid=request.getParameterValues("caterialid");
	     GoodsDao good=new GoodsDaoImpl();
	     int state=good.updateAllCai(mealid, caterialid);
	     PrintWriter out=response.getWriter();
	     if(state<0){
	    	 out.print("{\"state\":false,\"message\":\"����ʧ�ܣ�\"}");
	     }else{
	    	 out.print("{\"state\":true,\"message\":\"����ɹ���\"}");
	      }
	}

}
