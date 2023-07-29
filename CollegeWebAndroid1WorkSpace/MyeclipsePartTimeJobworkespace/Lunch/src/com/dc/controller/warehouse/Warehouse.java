package com.dc.controller.warehouse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.dc.dao.warehouse.WarehouseDao;
import com.dc.dao.warehouse.WarehouseDaoImpl;
import com.dc.entity.PageEntity;
import com.dc.util.StringUtil;

public class Warehouse extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		WarehouseDao ware=(WarehouseDao) new WarehouseDaoImpl();
		String caterialname=request.getParameter("caterialname");
		String nowpage=request.getParameter("nowpage");
		
		
		int pageN=0;
		//如果当前页的值为空,则是第一次进来,默认查询第一页
		if(StringUtil.checkNotNull(nowpage)){
			pageN=Integer.parseInt(nowpage);
		}else{
			pageN=1;
		}
		PageEntity page=new PageEntity();
		page.setNowpage(pageN);
		Map map=new HashMap();
		map.put("caterialname",caterialname);
		List list=ware.findWarehouse(map, page);
		request.setAttribute("ren", list);
		request.setAttribute("cailiao", map);
		request.setAttribute("page", page);
		PrintWriter out=response.getWriter();//异步输出//json
		JSONArray json=new JSONArray();//json
		json=JSONArray.fromObject(list);//json
		out.print(json.toString());//json
		request.getRequestDispatcher("/module/checkout/Checkout.jsp").forward(request, response);
	}

}
