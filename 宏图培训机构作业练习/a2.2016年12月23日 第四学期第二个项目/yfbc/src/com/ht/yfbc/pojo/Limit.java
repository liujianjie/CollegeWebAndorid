package com.ht.yfbc.pojo;

import java.io.Serializable;
/**
 * <p>Limit权限表</p>
 *	<p>id:sys_guid(),32位的字符串</p>
 *	<p>lmtname：权限名称</p>
 * 	<p>Day 2016-12-27</p>
 * @author 刘宗龙
 * 
 *	
 */
public class Limit implements Serializable{
	private String id;
	private String lmtname;
	
	public Limit() {
	}
	public Limit(String id, String lmtname) {
		this.id = id;
		this.lmtname = lmtname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLmtname() {
		return lmtname;
	}
	public void setLmtname(String lmtname) {
		this.lmtname = lmtname;
	}
	@Override
	public String toString() {
		return "Limit [id=" + id + ", lmtname=" + lmtname + "]";
	}
	
	
}
