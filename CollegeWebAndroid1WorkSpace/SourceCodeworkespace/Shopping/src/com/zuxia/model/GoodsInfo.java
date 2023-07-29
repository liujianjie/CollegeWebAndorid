package com.zuxia.model;

import java.io.Serializable;

/**
 * 商品信息类
 */
public class GoodsInfo implements Serializable {

	private int goodsId; // 商品编号
	private GoodsType goodsType = new GoodsType(); // 商品类别
	private String goodsName; // 商品名称
	private double price; // 商品价格
	private float discount; // 商品折扣
	private int isNew; // 是否新品(0新品,1不是新品)
	private int isRecommend; // 是否推荐（0推荐，1不推荐）
	private int status; // 商品状态（0上架，1下架）
	private String photo; // 商品图片
	private String remark; // 商品描述


	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getIsNew() {
		return isNew;
	}

	public void setIsNew(int isNew) {
		this.isNew = isNew;
	}

	public int getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(int isRecommend) {
		this.isRecommend = isRecommend;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取打折后的价格
	 */
	public double getDiscountPrice() {
		double price = this.price * this.discount / 10;
		price = Math.round(price * 100.0) / 100.0;
		return price;
	}

}
