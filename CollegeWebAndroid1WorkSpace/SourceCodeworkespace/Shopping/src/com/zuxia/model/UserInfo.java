package com.zuxia.model;

import java.io.Serializable;

/**
 * 用户信息类
 */
public class UserInfo implements Serializable {

	private int id; //用户编号
	private String userName; //用户名称
	private String userPwd; //用户密码
	
	public UserInfo() {
	}
	public UserInfo(String userName,String userPwd) {
		this.userName = userName;
		this.userPwd = userPwd;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
}
