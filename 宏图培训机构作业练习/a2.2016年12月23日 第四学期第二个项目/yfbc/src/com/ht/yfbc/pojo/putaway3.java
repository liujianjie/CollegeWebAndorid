package com.ht.yfbc.pojo;

/**
 * 移库对商品数据的查询 主要针对 收货表
 * 
 * */
public class putaway3 extends Putaway{
	private Receiving rece;

	public putaway3() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public putaway3(String ptid, String inid, String reid, String sheid, String whid, Integer ptbln) {
		super(ptid, inid, reid, sheid, whid, ptbln);
		// TODO 自动生成的构造函数存根
	}

	public putaway3(Receiving rece) {
		super();
		this.rece = rece;
	}

	public Receiving getRece() {
		return rece;
	}

	public void setRece(Receiving rece) {
		this.rece = rece;
	}
}
