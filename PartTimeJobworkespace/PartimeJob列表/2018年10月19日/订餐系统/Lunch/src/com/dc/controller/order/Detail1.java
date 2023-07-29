package com.dc.controller.order;

import net.sf.json.JSONObject;

import com.dc.dao.order.OrderDAO;
import com.dc.dao.order.OrderDAOImpl;
import com.dc.dao.card.*;
import com.dc.util.BaseAction;
public class Detail1 extends BaseAction{
	private String empname;
	private String orderid;
	/**
	 * 安排员工配送
	 */
	public void qryg(){
		OrderDAO order=new OrderDAOImpl();
		order.updateByName(empname, orderid);
		this.getOut().print("{\"state\":\"true\",\"message\":\"选择成功\"}");
	}
	/**
	 * 接单
	 */
	public void jiedan(){
		OrderDAO order=new OrderDAOImpl();
		order.updatestate(orderid);
		this.getOut().print("{\"state\":\"true\",\"message\":\"接单成功\"}");
	}
	/**
	 * 取消订单
	 */
	public void qxdd(){
		OrderDAO order=new OrderDAOImpl();
		order.qxdd(orderid);
		this.getOut().print("{\"state\":\"true\",\"message\":\"取消成功\"}");
	}
	/**
	 * 确认收货
	 */
	public void qrsh(){
		CardDAO card=new CardDAOImpl();
		card.finishOrder(orderid);
		this.getOut().print("{\"state\":\"true\",\"message\":\"订单完成\"}");
		
	}
	/**
	 * 打包
	 */
	public void pack(){
		OrderDAO order=new OrderDAOImpl();
		order.pack(orderid);
		this.getOut().print("{\"state\":\"true\",\"message\":\"打包完成\"}");
	}
	/**
	 * @return the empname
	 */
	public String getEmpname() {
		return empname;
	}

	/**
	 * @param empname the empname to set
	 */
	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
}
