package com.zuxia.model;

import java.io.Serializable;

/**
 * 客户详细信息类
 */
public class CustomerDetailInfo implements Serializable {
	
	private CustomerInfo customerInfo; //客户信息
	private String name; //收货人姓名
	private String telphone;	//固定电话
	private String movePhone;	//移动电话
	private String address;	//收货地址
	
	
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public String getName() {
		return name==null?"":name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelphone() {
		return telphone==null?"":telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getMovePhone() {
		return movePhone==null?"":movePhone;
	}
	public void setMovePhone(String movePhone) {
		this.movePhone = movePhone;
	}
	public String getAddress() {
		return address==null?"":address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
