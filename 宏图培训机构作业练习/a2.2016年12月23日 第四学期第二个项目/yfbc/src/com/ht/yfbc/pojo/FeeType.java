package com.ht.yfbc.pojo;
/**
 * id:主键id<br>
 * typename:类型名称<br>
 * Day 2017-12-30
 * @author 刘宗龙
 *
 */
public class FeeType {
	private String id;
	private String typename;
	public FeeType() {
	}
	public FeeType(String id, String typename) {
		this.id = id;
		this.typename = typename;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	@Override
	public String toString() {
		return "FeeType [id=" + id + ", typename=" + typename + "]";
	}
	
}
