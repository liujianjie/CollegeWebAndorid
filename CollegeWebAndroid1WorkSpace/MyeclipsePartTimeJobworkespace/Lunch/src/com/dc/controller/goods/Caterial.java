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
import javax.xml.registry.infomodel.User;

import net.sf.json.JSONArray;

import com.dc.dao.goods.CaterialDao;
import com.dc.dao.goods.CaterialDaoImpl;
import com.dc.entity.PageEntity;
import com.dc.util.StringUtil;

public class Caterial extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * ���ϲ�ѯaction
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		CaterialDao caterial=new CaterialDaoImpl();
		String  caterialname=request.getParameter("caterialname");
		String nowpage=request.getParameter("nowpage");
		
		
		int pageN=0;
		//�����ǰҳ��ֵΪ��,���ǵ�һ�ν���,Ĭ�ϲ�ѯ��һҳ
		if(StringUtil.checkNotNull(nowpage)){
			pageN=Integer.parseInt(nowpage);
		}else{
			pageN=1;
		}
		PageEntity page=new PageEntity();
		page.setNowpage(pageN);
		Map map=new HashMap();
		map.put("caterialname",caterialname );
		List list=caterial.findCaterial(map,page);
		
		request.setAttribute("liao", list);
		request.setAttribute("cailiao", map);
		request.setAttribute("page", page);
		PrintWriter out=response.getWriter();//�첽���//json
		JSONArray json=new JSONArray();//json
		json=JSONArray.fromObject(list);//json
		out.print(json.toString());//json
		
		
		List list2=caterial.selectUnit();
		request.setAttribute("type", list2);
		request.getRequestDispatcher("/module/warehouse/Caterial.jsp").forward(request, response);
	}

}
