package com.zuxia.model;

/**
 * 热卖商品
 */
public class SalesGoods implements java.io.Serializable{
	
	private int quantity; //销售数量
	private int goodsId; //商品编号
	private String goodsName; //商品名称
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
}
