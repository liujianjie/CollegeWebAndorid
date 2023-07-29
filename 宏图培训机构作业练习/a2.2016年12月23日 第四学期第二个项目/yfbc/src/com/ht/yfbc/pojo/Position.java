package com.ht.yfbc.pojo;

import java.io.Serializable;
/**
 * <p>Position岗位表</p>
 *	<p>id:sys_guid(),32位的字符串</p>
 *	<p>pname：岗位名称</p>
 * 	<p>Day 2016-12-27</p>
 * @author 刘宗龙
 * 
 *	
 */
public class Position implements Serializable{
	private String id;
	private String pname;
	
	public Position() {
	}

	public Position(String id, String pname) {
		this.id = id;
		this.pname = pname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", pname=" + pname + "]";
	}
	
}
