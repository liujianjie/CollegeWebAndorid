package com.dc.controller.order;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.order.OrderDAO;
import com.dc.dao.order.OrderDAOImpl;
import com.dc.entity.PageEntity;
import com.dc.util.StringUtil;

public class SelectOrder extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String customername=request.getParameter("customername");
		String state=request.getParameter("state");
		Map map=new HashMap();
		map.put("customername", customername);
		map.put("state", state);
		String nowpage=request.getParameter("nowpage");
		
		int npage=0;
		if(StringUtil.checkNotNull(nowpage)){
			npage=Integer.parseInt(nowpage);
		}else{
			npage=1;
		}
		PageEntity page=new PageEntity();
		page.setNowpage(npage);
		OrderDAO order=new OrderDAOImpl();
		List list =order.findorder(map, page);
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		
		if(state==null||state.equals("")){
			state="6";
		}
		request.setAttribute("state1", state);	
		request.setAttribute("info", map);
		request.getRequestDispatcher("/module/Order/SelectOrder.jsp").forward(request, response);
	}

}
