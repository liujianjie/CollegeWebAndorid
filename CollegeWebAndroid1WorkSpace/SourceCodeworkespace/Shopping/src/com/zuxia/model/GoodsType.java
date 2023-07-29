package com.zuxia.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 商品类型类
 */
public class GoodsType implements Serializable{
	
	private	int typeId;	//类型编号
	private String typeName;	//类型名称
	private ArrayList<GoodsInfo> items; //该类型的商品
	
	public GoodsType() {
	}
	
	public GoodsType(int typeId,String typeName) {
		this.typeId = typeId;
		this.typeName = typeName;
	}
	
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public ArrayList<GoodsInfo> getItems() {
		return items;
	}

	public void setItems(ArrayList<GoodsInfo> items) {
		this.items = items;
	}
}
