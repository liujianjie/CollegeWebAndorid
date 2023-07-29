package com.zuxia.model;

import java.io.Serializable;

/**
 * 订单商品信息（订单详细信息）类
 */
public class OrderGoodsInfo implements Serializable {

	private OrderInfo orderInfo; // 所属订单
	private GoodsInfo goodsInfo; // 商品信息
	private int quantity; // 商品订购数量

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/*
	 * 获取商品小计
	 */
	public double getSumPrice() {
		return this.quantity * this.goodsInfo.getDiscountPrice();
	}
}
