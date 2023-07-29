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
	 * �˴�Ϊ��֤�������ʱ�ж����ӵ�Ψһ��
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
				out.print("{\"state\":\"true\",\"message\":\"���������ѱ�ʹ��\"}");
			}else if(StringUtil.checkNotNull(roomnumber)){
				out.print("{\"state\":\"true\",\"message\":\"��������������\"}");
			}else{
				out.print("{\"state\":\"false\",\"message\":\"����������Ϊ��\"}");
			}
	}

}
