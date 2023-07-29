package com.zuxia.control;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zuxia.dao.OrderInfoDao;
import com.zuxia.model.OrderInfo;
import com.zuxia.util.PageModel;
import com.zuxia.util.StringUtil;

public class OrderManage extends HttpServlet {
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
			} else if ("queryByStatus".equals(op)) {
				returnURL = queryByStatus(request, response);
			} else if ("toDetail".equals(op)) {
				returnURL = toShowDetail(request, response);
			} else if ("changeStatus".equals(op)) {
				returnURL = changeStatus(request, response);
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
	
	//关键词查询
	private String query(HttpServletRequest request, HttpServletResponse response){
		int pageSize = 10;
		int pageNo = 1;
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch (NumberFormatException e) {
		}
		String keyWords = request.getParameter("keywords");
		OrderInfoDao dao = new OrderInfoDao();
		PageModel<OrderInfo> pm = dao.getAllOrdersInfo(pageSize, pageNo,keyWords);
		request.setAttribute("allOrders", pm);
		return "../admin/orderManage.jsp";
	}
	
	//根据状态查询
	private String queryByStatus(HttpServletRequest request, HttpServletResponse response){
		int pageSize = 10;
		int pageNo = 1;
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch (NumberFormatException e) {
		}
		String status = request.getParameter("status");
		OrderInfoDao dao = new OrderInfoDao();
		PageModel<OrderInfo> pm = dao.getAllOrdersInfo(pageSize, pageNo,Integer.parseInt(status));
		request.setAttribute("allOrders", pm);
		return "../admin/orderManage.jsp";
	}
	
	//查询所有
	private String queryAll(HttpServletRequest request, HttpServletResponse response){
		int pageSize = 10;
		int pageNo = 1;
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch (NumberFormatException e) {
		}
		OrderInfoDao dao = new OrderInfoDao();
		PageModel<OrderInfo> pm = dao.getAllOrdersInfo(pageSize, pageNo);
		if (pm != null && pm.getData().isEmpty() && pageNo != 1) {
			pm = dao.getAllOrdersInfo(pageSize, 1);
		}
		request.setAttribute("allOrders", pm);
		return "../admin/orderManage.jsp";
	}
	
	//前往显示详情的页面
	private String toShowDetail(HttpServletRequest request, HttpServletResponse response){
		String orderId = request.getParameter("id");
		if(orderId!=null){
			OrderInfo order = new OrderInfoDao().getOrderInfo(Integer.parseInt(orderId));
			request.setAttribute("order", order);
		}
		return "../admin/showOrderDetail.jsp";
	}
	
	//改变状态
	private String changeStatus(HttpServletRequest request, HttpServletResponse response){
		try {
			int orderId = Integer.parseInt(request.getParameter("id"));
			int status = Integer.parseInt(request.getParameter("status"));
			
			if(0==status){ //若状态为未确认，则确认
				status = 1;
			}else{ //若状态为确认或参数错误，则改为未确认
				status = 0;
			}
			boolean flag = new OrderInfoDao().changeOrderStatus(orderId, status);
			if(flag){
				return queryAll(request, response);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", "对不起，更改订单状态失败！");
		return "../admin/failed.jsp";
	}
	
	//删除
	private String remove(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		if(!StringUtil.isNullOrEmpty(id)){
			boolean  flag = new OrderInfoDao().removeOrder(Integer.parseInt(id));
			if(flag){
				return queryAll(request, response);
			}
		}
		request.setAttribute("msg", "对不起，删除订单失败！");
		return "../admin/failed.jsp";
	}
	
	//删除多个
	private String removeMore(HttpServletRequest request, HttpServletResponse response){
		String ids = request.getParameter("removeIds");
		if(!StringUtil.isNullOrEmpty(ids)){
			boolean  flag = new OrderInfoDao().removeOrder(ids);
			if(flag){
				return queryAll(request, response);
			}
		}
		request.setAttribute("msg", "对不起，删除订单失败！");
		return "../admin/failed.jsp";
	}
}
