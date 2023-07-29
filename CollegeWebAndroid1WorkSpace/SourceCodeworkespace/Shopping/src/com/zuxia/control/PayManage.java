package com.zuxia.control;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zuxia.dao.OrderInfoDao;
import com.zuxia.model.Cart;
import com.zuxia.model.CustomerInfo;
import com.zuxia.model.OrderGoodsInfo;
import com.zuxia.model.OrderInfo;

public class PayManage extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		String returnURL = "";

		if ("confirm".equals(op)) {
			returnURL = confirm(request,response);
		} else if ("add".equals(op)) {
			returnURL = addOrder(request,response);
		} else {
			request.setAttribute("msg", "进入结算中心出错！缺少必要的参数！");
			returnURL = "../error.jsp";
		}

		request.getRequestDispatcher(returnURL).forward(request, response);
	}
	
	//确认
	private String confirm(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart == null || cart.getCart().isEmpty()){
			return "../cart.jsp";
		}
		//设置一个标识，表示客户当前的动作欲前往确认订单页面
		session.setAttribute("toGo", "confirmOrder");
		CustomerInfo customer = (CustomerInfo)session.getAttribute("customer");
		if(customer == null){
			//用户未登录
			return "../login_register.jsp";
		}else if(customer.getDetailInfo()==null){
			//客户未填写配送信息
			return "../peisong.jsp";
		}else{
			return "../confirm.jsp";
		}
	}
	
	//添加订单
	private String addOrder(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		//从session中移除标识
		session.removeAttribute("toGo");
		
		Cart cart = (Cart)session.getAttribute("cart");
		CustomerInfo customer = (CustomerInfo)session.getAttribute("customer");
		
		ArrayList<OrderGoodsInfo> goodsList = new ArrayList<OrderGoodsInfo>();
		Iterator<OrderGoodsInfo> values = cart.getCart().values().iterator();
		while(values.hasNext()){
			goodsList.add(values.next());
		}
		
		OrderInfo order = new OrderInfo();
		order.setStatus(0);
		order.setCustomerInfo(customer);
		order.setOrderDetails(goodsList);
		
		OrderInfoDao dao = new OrderInfoDao();
		boolean flag = dao.addOrder(order);
		if(flag){
			//清空购物车
			cart.clearCart();
			request.setAttribute("msg", customer.getEmail()+",恭喜您，添加订单成功！");
			return "../ok.jsp";
		}
		request.setAttribute("msg", "对不起，添加订单失败！");
		return "../failed.jsp";
	}	
}
