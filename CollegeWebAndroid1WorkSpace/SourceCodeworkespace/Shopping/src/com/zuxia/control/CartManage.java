package com.zuxia.control;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zuxia.dao.GoodsInfoDao;
import com.zuxia.model.Cart;
import com.zuxia.model.GoodsInfo;
import com.zuxia.util.StringUtil;

public class CartManage extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		String returnURL = "";

		if ("show".equals(op)) {
			returnURL = show(request,response);
		} else if ("add".equals(op)) {
			returnURL = add(request,response);
		} else if ("change".equals(op)) {
			returnURL = changeQuantity(request,response);
		} else if ("clear".equals(op)) {
			returnURL = clear(request,response);
		} else if ("remove".equals(op)) {
			returnURL = remove(request,response);
		} else {
			request.setAttribute("msg", "访问该资源未携带参数！");
			returnURL = "../error.jsp";
		}

		request.getRequestDispatcher(returnURL).forward(request, response);
	}
	
	private String show(HttpServletRequest request, HttpServletResponse response){
		return "../cart.jsp";
	}
	
	/**
	 * 清空购物车
	 */
	private String clear(HttpServletRequest request, HttpServletResponse response){
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		cart.clearCart();
		return "../cart.jsp";
	}
	
	/**
	 * 更改订购数量
	 */
	private String changeQuantity(HttpServletRequest request, HttpServletResponse response){
		int quantity=0;
		int id = -1;
		try{
			quantity = Integer.parseInt(request.getParameter("quantity"));
			id = Integer.parseInt(request.getParameter("id"));
			
			Cart cart = (Cart)request.getSession().getAttribute("cart");
			cart.updateQuantity(id, quantity);
			return "../cart.jsp";
		}catch (Exception e) {
		}
		request.setAttribute("msg", "更改购物车中商品的订购数量失败！<br/>可能的原因：订购数量传入的参数错误！");
		return "../failed.jsp";
	}
	
	/**
	 * 从购物车中删除商品
	 */
	private String remove(HttpServletRequest request, HttpServletResponse response){
		int id = -1;
		try{
			id = Integer.parseInt(request.getParameter("id"));
			
			Cart cart = (Cart)request.getSession().getAttribute("cart");
			cart.removeGoods(id);
			return "../cart.jsp";
		}catch (Exception e) {
		}
		request.setAttribute("msg", "从购物车中删除商品失败！<br/>可能的原因：未找到该商品！");
		return "../failed.jsp";
	}
	
	/**
	 * 向购物车中添加商品
	 */
	private String add(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null){
			cart = new Cart();
		}
		int id = -1; //商品编号
		int num = -1; //订购数量
		try{
			id = Integer.parseInt(request.getParameter("id"));
			num = Integer.parseInt(request.getParameter("num"));
		}catch(Exception ex){
			request.setAttribute("msg", "向购物车中添加商品失败！<br/>可能的原因：未找到该商品或订购数量参数不正确！");
			return "../failed.jsp";
		}
		GoodsInfo goods = new GoodsInfoDao().getGoodsInfo(id);
		if(goods != null){
			//将商品加入购物车
			cart.addGoods(goods,num);
			//将购物车存入session中
			session.setAttribute("cart",cart);
			//显示购物车
			return "../cart.jsp";
		}else{
			request.setAttribute("msg", "向购物车中添加商品失败！<br/>可能的原因：未找到该商品！");
			return "../failed.jsp";
		}
	}
}
