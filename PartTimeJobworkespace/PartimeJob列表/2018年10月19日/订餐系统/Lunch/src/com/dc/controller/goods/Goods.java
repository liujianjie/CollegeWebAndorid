package com.dc.controller.goods;

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

import com.dc.dao.goods.GoodsDao;
import com.dc.dao.goods.GoodsDaoImpl;
import com.dc.entity.PageEntity;
import com.dc.util.StringUtil;

public class Goods extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doPost(request, response);
	}

	/**
	 * 查询菜品名称
	 * 菜品分页
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String mealname=request.getParameter("mealname");
		String mealprice=request.getParameter("mealprice");
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
		map.put("mealname", mealname);
		map.put("mealprice", mealprice);
		GoodsDao goods=new GoodsDaoImpl();
		List list=goods.AllGoods(map, page);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		request.setAttribute("shangpin", map);
		PrintWriter out=response.getWriter();//异步输出//json
		JSONArray json=new JSONArray();//json
		json=JSONArray.fromObject(list);//json
		out.print(json.toString());//json
		List list2=goods.selectType();
		
		request.setAttribute("type", list2);

		request.getRequestDispatcher("/module/warehouse/Goods.jsp").forward(request, response);
	}

}
