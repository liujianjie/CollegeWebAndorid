package com.zuxia.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zuxia.dao.BulletinDao;
import com.zuxia.model.BulletinInfo;
import com.zuxia.model.UserInfo;
import com.zuxia.util.PageModel;
import com.zuxia.util.StringUtil;

public class BulletinManage extends HttpServlet {
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
			} else if ("viewBulletin".equals(op)) {
				returnURL = viewBulletin(request, response);
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
		BulletinDao dao = new BulletinDao();
		PageModel<BulletinInfo> pm = dao.getAllBulletinInfo(pageSize, pageNo,keyWords);
		request.setAttribute("allBulletin", pm);
		return "../admin/bulletinManage.jsp";
	}
	
	//查看某个公告
	private String viewBulletin(HttpServletRequest request,
			HttpServletResponse response) {
		BulletinDao dao = new BulletinDao();
		String id = request.getParameter("id");
		BulletinInfo item = dao.getBulletinInfo(Integer.parseInt(id));
		request.setAttribute("bulletin", item);
		return "../include/viewBulletin.jsp";
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
		BulletinDao dao = new BulletinDao();
		PageModel<BulletinInfo> pm = dao.getAllBulletinInfo(pageSize, pageNo);
		if (pm != null && pm.getData().isEmpty() && pageNo != 1) {
			pm = dao.getAllBulletinInfo(pageSize, 1);
		}
		request.setAttribute("allBulletin", pm);
		return "../admin/bulletinManage.jsp";
	}

	//前往编辑页面
	private String toEdit(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		if(!StringUtil.isNullOrEmpty(id)){
			BulletinInfo item = new BulletinDao().getBulletinInfo(Integer.parseInt(id));
			if(item!=null){
				request.setAttribute("bulletin", item);
				return "../admin/updateBulletin.jsp";
			}
		}
		request.setAttribute("msg", "未找到此公告信息！");
		return "../admin/error.jsp";
	}
	
	//前往添加页面
	private String toAdd(HttpServletRequest request,
			HttpServletResponse response) {
		return "../admin/addBulletin.jsp";
	}

	//添加
	private String add(HttpServletRequest request,
			HttpServletResponse response) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		try{
			content = content.replaceAll("\r\n", "</p><p>");
			content = "<p>" + content + "</p>";
			
			BulletinInfo item = new BulletinInfo();
			item.setTitle(title);
			item.setContent(content);
			item.setCreateTime(new Date());
			UserInfo user = (UserInfo)request.getSession().getAttribute("user");
			item.setUser(user);
			boolean flag = new BulletinDao().addBulletin(item);
			if(flag){
				return queryAll(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("msg", "对不起，添加公告失败！");
		return "../admin/failed.jsp";
	}
	
	//修改
	private String update(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		try{
			content = content.replaceAll("\r\n", "</p><p>");
			content = "<p>" + content + "</p>";
			
			BulletinInfo item = new BulletinInfo();
			item.setId(Integer.parseInt(id));
			item.setTitle(title);
			item.setContent(content);
			item.setCreateTime(new Date());
			UserInfo user = (UserInfo)request.getSession().getAttribute("user");
			item.setUser(user);
			boolean flag = new BulletinDao().updateBulletin(item);
			if(flag){
				return queryAll(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("msg", "对不起，修改公告信息失败！");
		return "../admin/failed.jsp";
	}

	//删除
	private String remove(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		if(!StringUtil.isNullOrEmpty(id)){
			boolean  flag = new BulletinDao().removeBulletin(Integer.parseInt(id));
			if(flag){
				return queryAll(request, response);
			}
		}
		request.setAttribute("msg", "对不起，删除公告信息失败！");
		return "../admin/failed.jsp";
	}

	//删除多条
	private String removeMore(HttpServletRequest request,
			HttpServletResponse response) {
		String ids = request.getParameter("removeIds");
		if(!StringUtil.isNullOrEmpty(ids)){
			boolean  flag = new BulletinDao().removeBulletin(ids);
			if(flag){
				return queryAll(request, response);
			}
		}
		request.setAttribute("msg", "对不起，删除公告信息失败！");
		return "../admin/failed.jsp";
	}
}
