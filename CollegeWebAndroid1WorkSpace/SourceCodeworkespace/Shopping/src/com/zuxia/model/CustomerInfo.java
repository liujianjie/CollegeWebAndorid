package com.zuxia.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户信息类
 */
public class CustomerInfo implements Serializable {
	
	private int id; //客户编号
	private String email; //电子邮箱（客户账户名）
	private String pwd; //密码
	private Date registerTime; //注册时间
	private CustomerDetailInfo detailInfo; //客户详细信息
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public CustomerDetailInfo getDetailInfo() {
		return detailInfo;
	}
	public void setDetailInfo(CustomerDetailInfo detailInfo) {
		this.detailInfo = detailInfo;
	}
}
