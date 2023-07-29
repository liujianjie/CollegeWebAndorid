package com.zuxia.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * 订单信息类
 */
public class OrderInfo implements Serializable {
	
	private int orderId;	//订单编号
	private CustomerInfo customerInfo = new CustomerInfo();	//客户信息
	private int status;	//订单状态（0未确认，1已确认）
	private Date orderTime;
	private ArrayList<OrderGoodsInfo> orderDetails;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public ArrayList<OrderGoodsInfo> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(ArrayList<OrderGoodsInfo> orderDetails) {
		this.orderDetails = orderDetails;
	}
}
