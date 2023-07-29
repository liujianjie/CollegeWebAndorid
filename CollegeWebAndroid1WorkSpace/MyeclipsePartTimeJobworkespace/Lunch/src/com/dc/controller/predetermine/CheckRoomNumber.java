package com.dc.controller.predetermine;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.predetermine.PredetermineDao;
import com.dc.dao.predetermine.PredetermineDaoImpI;
import com.dc.util.StringUtil;

public class CheckRoomNumber extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	/**
	 * 此处为验证添加桌子时判断桌子的唯一性
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			String roomnumber=request.getParameter("roomnumber");
			PredetermineDao dao=new PredetermineDaoImpI();
			Map map=dao.checkRoom(roomnumber);
			PrintWriter out=response.getWriter();
			if(StringUtil.checkNotNull(map)){
				out.print("{\"state\":\"true\",\"message\":\"此桌号名已被使用\"}");
			}else if(StringUtil.checkNotNull(roomnumber)){
				out.print("{\"state\":\"true\",\"message\":\"此桌号名可以用\"}");
			}else{
				out.print("{\"state\":\"false\",\"message\":\"桌号名不能为空\"}");
			}
	}

}
