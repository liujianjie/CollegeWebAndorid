package com.dc.controller.purchase;

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

import com.dc.dao.purchase.PurchaseDao;
import com.dc.dao.purchase.PurchaseDaoImpl;
import com.dc.entity.PageEntity;
import com.dc.util.StringUtil;

public class Purchase extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PurchaseDao pur=new PurchaseDaoImpl();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String univalent=request.getParameter("univalent");
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
		map.put("univalent",univalent );
		List list=pur.findPruchare(map, page);
		
		request.setAttribute("list", list);
		request.setAttribute("xiangqing", map);

		request.setAttribute("page", page);
		PrintWriter out=response.getWriter();//异步输出//json
		JSONArray json=new JSONArray();//json
		json=JSONArray.fromObject(list);//json
		out.print(json.toString());//json
		request.getRequestDispatcher("/module/purchase/Purchase.jsp").forward(request, response);
	}
	}

	

