package com.dc.controller.goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dc.dao.goods.CaterialDao;
import com.dc.dao.goods.CaterialDaoImpl;
import com.dc.util.StringUtil;

public class InsertCaterial extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * 新增材料action
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			CaterialDao caterial=new CaterialDaoImpl();
			String empid=request.getParameter("empid");
			String caterialid=request.getParameter("caterialid");
			String caterialname=request.getParameter("caterialname");
			String demand=request.getParameter("demand");
			String unit=request.getParameter("unit");
			
			PrintWriter out=response.getWriter();
			if(StringUtil.checkNotNull(caterialid)){
				caterial.updateCaterial(caterialid, demand);
				out.print("{\"state\":\"true\",\"message\":\"修改成功\"}");
			}else{
				if(StringUtil.checkNotNull(caterialname)&&StringUtil.checkNotNull(demand)&&StringUtil.checkNotNull(unit)){
					caterial.insertCaterial(empid,caterialname,unit,demand);
					out.print("{\"state\":\"true\",\"message\":\"新增成功\"}");
				}else{
					out.print("{\"state\":\"false\",\"message\":\"有一项内容为空\"}");
				}
			}
			
	}

}
