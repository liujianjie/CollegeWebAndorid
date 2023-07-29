package com.ht.pojo;

/**
 * 后台用户的岗位表
 * */
public class Post {
	private String p_id;
	private String p_name;
	private String p_jianjie;
	private String p_list;//权限
	
	public Post(){}
	
	public Post(String p_id, String p_name, String p_jianjie, String p_list) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_jianjie = p_jianjie;
		this.p_list = p_list;
	}


	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_jianjie() {
		return p_jianjie;
	}
	public void setP_jianjie(String p_jianjie) {
		this.p_jianjie = p_jianjie;
	}


	public String getP_list() {
		return p_list;
	}


	public void setP_list(String p_list) {
		this.p_list = p_list;
	}
	
}
