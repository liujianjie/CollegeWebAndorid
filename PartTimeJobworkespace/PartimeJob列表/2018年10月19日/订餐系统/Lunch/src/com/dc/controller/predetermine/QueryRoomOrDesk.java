package com.dc.controller.predetermine;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.predetermine.PredetermineDao;
import com.dc.dao.predetermine.PredetermineDaoImpI;
import com.dc.entity.PageEntity;
import com.dc.util.StringUtil;

public class QueryRoomOrDesk extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	/**
	 * 员工查看所有桌号信息
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			PredetermineDao dao=new PredetermineDaoImpI();
			String roomnumber=request.getParameter("roomnumber");
			String peocount=request.getParameter("peocount");
			String nowpage=request.getParameter("nowpage");
			String type=request.getParameter("type");
			String state=request.getParameter("state");
			Map map=new HashMap();
			map.put("roomnumber", roomnumber);
			map.put("peocount", peocount);
			map.put("type", type);
			map.put("state", state); 
			int pageN=0;
			if(StringUtil.checkNotNull(nowpage)){
				pageN=Integer.parseInt(nowpage);
			}else{
				pageN=1;
			}
			PageEntity page=new PageEntity();
			page.setNowpage(pageN);
			List list=dao.findEmptyRoom(map,page);
			request.setAttribute("query", map);
			request.setAttribute("roomList",list);
			request.setAttribute("page",page);
			request.getRequestDispatcher("/module/predetermine/queryRoomOrDesk.jsp").forward(request, response);
	}

}
