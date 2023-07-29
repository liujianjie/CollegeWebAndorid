package com.zuxia.control;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zuxia.dao.GoodsTypeDao;
import com.zuxia.model.GoodsType;
import com.zuxia.util.PageModel;
import com.zuxia.util.StringUtil;

public class GoodsTypeManage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		String returnURL = "";
		if (op == null || "".equals(op)) {
			returnURL = queryAll(request, response);
		} else {
			if ("query".equals(op)) {
				returnURL = query(request, response);
			} else if ("toAdd".equals(op)) {
				returnURL = toAdd(request, response);
			} else if ("add".equals(op)) {
				returnURL = add(request, response);
			} else if ("toEdit".equals(op)) {
				returnURL = toEdit(request, response);
			} else if ("update".equals(op)) {
				returnURL = update(request, response);
			} else if ("remove".equals(op)) {
				returnURL = remove(request, response);
			} else if ("removeMore".equals(op)) {
				returnURL = removeMore(request, response);
			} else {
				request.setAttribute("msg", "访问资源出错！访问该资源未携带必要的参数！");
				returnURL = "../admin/error.jsp";
			}
		}
		request.getRequestDispatcher(returnURL).forward(request, response);
	}
	
	//关键词搜索
	private String query(HttpServletRequest request,
			HttpServletResponse response) {
		int pageSize = 10;
		int pageNo = 1;
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch (NumberFormatException e) {
		}
		String keyWords = request.getParameter("keywords");
		GoodsTypeDao dao = new GoodsTypeDao();
		PageModel<GoodsType> pm = dao.getAllGoodsTypes(pageSize, pageNo,keyWords);
		request.setAttribute("allTypes", pm);
		return "../admin/goodsTypeManage.jsp";
	}

	//查询所有
	private String queryAll(HttpServletRequest request,
			HttpServletResponse response) {
		int pageSize = 10;
		int pageNo = 1;
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch (NumberFormatException e) {
		}
		GoodsTypeDao dao = new GoodsTypeDao();
		PageModel<GoodsType> pm = dao.getAllGoodsTypes(pageSize, pageNo);
		if (pm != null && pm.getData().isEmpty() && pageNo != 1) {
			pm = dao.getAllGoodsTypes(pageSize, 1);
		}
		request.setAttribute("allTypes", pm);
		return "../admin/goodsTypeManage.jsp";
	}

	//前往编辑页面
	private String toEdit(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		if(!StringUtil.isNullOrEmpty(id)){
			GoodsType type = new GoodsTypeDao().getGoodsType(Integer.parseInt(id));
			if(type!=null){
				request.setAttribute("type", type);
				return "../admin/updateGoodsType.jsp";
			}
		}
		request.setAttribute("msg", "对不起，未找到此商品类型信息！");
		return "../admin/error.jsp";
	}
	
	//前往添加页面
	private String toAdd(HttpServletRequest request,
			HttpServletResponse response) {
		return "../admin/addGoodsType.jsp";
	}

	//添加
	private String add(HttpServletRequest request,
			HttpServletResponse response) {
		String typeName = request.getParameter("typeName");
		
		try{
			GoodsType type = new GoodsType();
			type.setTypeName(typeName);
			boolean flag = new GoodsTypeDao().addType(type);
			if(flag){
				return queryAll(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("msg", "对不起，添加商品类型失败！");
		return "../admin/failed.jsp";
	}
	
	//修改
	private String update(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		String typeName = request.getParameter("typeName");
		
		try{
			GoodsType type = new GoodsType(Integer.parseInt(id),typeName);
			boolean flag = new GoodsTypeDao().updateGoodsType(type);
			if(flag){
				return queryAll(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("msg", "对不起，修改商品类型失败！");
		return "../admin/failed.jsp";
	}

	//删除
	private String remove(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		if(!StringUtil.isNullOrEmpty(id)){
			boolean  flag = new GoodsTypeDao().removeGoodsType(Integer.parseInt(id));
			if(flag){
				return queryAll(request, response);
			}
		}
		request.setAttribute("msg", "对不起，删除商品类型失败！可能该商品类型下还存在商品！");
		return "../admin/failed.jsp";
	}

	//删除多条
	private String removeMore(HttpServletRequest request,
			HttpServletResponse response) {
		String ids = request.getParameter("removeIds");
		if(!StringUtil.isNullOrEmpty(ids)){
			boolean  flag = new GoodsTypeDao().removeGoodsType(ids);
			if(flag){
				return queryAll(request, response);
			}
		}
		request.setAttribute("msg", "对不起，删除商品类型失败！可能该商品类型下还存在商品！");
		return "../admin/failed.jsp";
	}
}
