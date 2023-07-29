package com.dc.controller.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.goods.GoodsDao;
import com.dc.dao.goods.GoodsDaoImpl;
import com.dc.util.StringUtil;

public class InsertGoods extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * 新增商品action
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		GoodsDao goods=new GoodsDaoImpl();
		
		String mealid=request.getParameter("mealid");
		String mealtype=request.getParameter("mealtype");
		String mealname=request.getParameter("mealname");
		String mealprice=request.getParameter("mealprice");
		String mealdesc=request.getParameter("mealdesc");
		String mealimage=request.getParameter("mealimage");
		String mealbudget=request.getParameter("mealbudget");
		
		//goods.insertAllGoods(mealname, mealprice, mealcount);
		//response.getWriter().print("保存成功");
		PrintWriter out=response.getWriter();
		if(StringUtil.checkNotNull(mealid)){
			goods.updateAllGoods(mealid, mealtype,mealname,mealbudget,mealprice,mealdesc,mealimage);
			out.print("{\"state\":\"true\",\"message\":\"修改成功\"}");
		}else{
			if(StringUtil.checkNotNull(mealtype)&&StringUtil.checkNotNull(mealname)&&StringUtil.checkNotNull(mealprice)
					&&StringUtil.checkNotNull(mealdesc)&&StringUtil.checkNotNull(mealimage)&&StringUtil.checkNotNull(mealbudget)){
				goods.insertAllGoods(mealtype,mealname,mealbudget,mealprice,mealdesc,mealimage);
				out.print("{\"state\":\"true\",\"message\":\"新增成功\"}");
			}else{
				out.print("{\"state\":\"true\",\"message\":\"有一项内容为空\"}");
			}
		}
	}
	
}
