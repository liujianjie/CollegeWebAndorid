package com.jlgouwu.pojo;

public class Comment {
	private int c_id;
	private int jruser_id;
	private int g_id;
	private String c_comment;
	private String c_time;
	
	//用户信息
	private String jr_img;
	private String uname;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getJruser_id() {
		return jruser_id;
	}
	public void setJruser_id(int jruser_id) {
		this.jruser_id = jruser_id;
	}
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public String getC_comment() {
		return c_comment;
	}
	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}
	public String getC_time() {
		return c_time;
	}
	public void setC_time(String c_time) {
		this.c_time = c_time;
	}
	public String getJr_img() {
		return jr_img;
	}
	public void setJr_img(String jr_img) {
		this.jr_img = jr_img;
	}
}
