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

public class InsertRoom extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	/**
	 * ����������Ϣͬʱ���и����ж�
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			String roomnumber=request.getParameter("roomnumber");
			String peocount=request.getParameter("peocount");
			String roomtype=request.getParameter("roomtype");
			PredetermineDao dao=new PredetermineDaoImpI();
			Map map=dao.checkRoom(roomnumber);  //�ύ������ťʱ�ٴν����ж��ܷ����(�����������ظ�)
			PrintWriter out=response.getWriter();
			if(StringUtil.checkNotNull(roomnumber)&&!StringUtil.checkNotNull(map)
					&&StringUtil.checkNotNull(peocount)&&StringUtil.checkNotNull(roomtype)){
				dao.insertRoom(roomnumber, peocount, roomtype);
				out.print("{\"state\":\"true\",\"message\":\"�����ɹ�\"}");
			}else if(StringUtil.checkNotNull(map)){
				out.print("{\"state\":\"false\",\"message\":\"�������Ѿ�����\"}");
			}else{
				out.print("{\"state\":\"false\",\"message\":\"�������ݲ���Ϊ��\"}");
			}
			
	}

}
