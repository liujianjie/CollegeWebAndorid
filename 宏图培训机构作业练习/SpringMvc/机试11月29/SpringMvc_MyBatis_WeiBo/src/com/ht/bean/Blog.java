package com.ht.bean;

import java.io.Serializable;
import java.util.Date;

public class Blog implements Serializable{
	private Integer b_id;
	private String b_content;
	private Date b_publishtime;
	private Integer b_userid;
	private Users users;
	
	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Integer getB_id() {
		return b_id;
	}
	public void setB_id(Integer b_id) {
		this.b_id = b_id;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public Date getB_publishtime() {
		return b_publishtime;
	}
	public void setB_publishtime(Date b_publishtime) {
		this.b_publishtime = b_publishtime;
	}
	public Integer getB_userid() {
		return b_userid;
	}
	public void setB_userid(Integer b_userid) {
		this.b_userid = b_userid;
	}
	
}
