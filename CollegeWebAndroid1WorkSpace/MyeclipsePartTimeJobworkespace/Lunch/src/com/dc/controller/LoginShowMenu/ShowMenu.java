package com.dc.controller.LoginShowMenu;

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
import net.sf.json.JSONObject;

import com.dc.dao.LoginShowMenu.ShowLoginMenuDAO;
import com.dc.dao.LoginShowMenu.ShowLoginMenuDAOImpl;
import com.dc.dao.pinlun.QTPinlunDAO;
import com.dc.dao.pinlun.QTPinlunDAOImpl;
import com.dc.util.StringUtil;

public class ShowMenu extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String mealid=request.getParameter("mealid");
			String roomid=request.getParameter("roomid");
			String Addorderid=request.getParameter("Addorderid");
			request.setAttribute("Addorderid", Addorderid);
			request.setAttribute("orderid", Addorderid);
			//System.out.println(mealid+"mealid");
			ShowLoginMenuDAO dao=new ShowLoginMenuDAOImpl();
			//根据某一菜单id查询
			List<HashMap> menuList=dao.selectallMenu(mealid);
			if(StringUtil.checkNotNull(mealid)){
				Map oneMenuMap=menuList.get(0);
				System.out.println(oneMenuMap);
				request.setAttribute("oneMenuMap", oneMenuMap);

				QTPinlunDAO qt=new QTPinlunDAOImpl();
				List list=qt.SelPinlun(mealid);
				//System.out.println(list);
				request.setAttribute("qtt", list);

				//System.out.println(oneMenuMap+"oneMenuMap");
				if(StringUtil.checkNotNull(roomid)){
					request.getRequestDispatcher("/module/BgMenu/BgoneMenu.jsp").forward(request, response);
				}else{	
					request.getRequestDispatcher("/module/Login/oneMenu.jsp").forward(request, response);
				}
			}else{
				response.sendRedirect("/Lunch/module/BgMenu/BgMenu.jsp");
			}
	}

}
