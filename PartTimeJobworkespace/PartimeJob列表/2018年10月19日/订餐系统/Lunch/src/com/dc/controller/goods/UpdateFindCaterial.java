package com.dc.controller.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.goods.GoodsDao;
import com.dc.dao.goods.GoodsDaoImpl;

public class UpdateFindCaterial extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * 添加菜品中的材料
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		GoodsDao goods=new GoodsDaoImpl();
		String mealid=request.getParameter("mealid");
		String[] caterialid=request.getParameterValues("caterialid");
		int state=goods.updateFindCaterial(mealid, caterialid);
		 PrintWriter out=response.getWriter();
	     if(state<0){
	    	 out.print("{\"state\":false,\"message\":\"保存失败！\"}");
	     }else{
	    	 out.print("{\"state\":true,\"message\":\"保存成功！\"}");
	      }
	}

}
