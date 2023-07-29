package com.ht.yfbc.pojo;

import java.io.Serializable;

/**
 * 货物分类表
 * day 2016-12-29
 * @author 魏海明
 *
 */
public class Goodtype implements Serializable{
	private String tid;
	private String tname;
	
	public Goodtype() {
		// TODO Auto-generated constructor stub
	}

	public Goodtype(String tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
	
	
}
