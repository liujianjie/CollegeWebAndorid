package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String userPwd;
	private String userAddress;
	private String userPhone;
	private Set comments = new HashSet(0);
	private Set roomOrders = new HashSet(0);
	private Set buyCars = new HashSet(0);
	private Set outOrders = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName, String userPwd, String userAddress, String userPhone) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
	}

	/** full constructor */
	public User(String userName, String userPwd, String userAddress, String userPhone, Set comments, Set roomOrders,
			Set buyCars, Set outOrders) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
		this.comments = comments;
		this.roomOrders = roomOrders;
		this.buyCars = buyCars;
		this.outOrders = outOrders;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Set getRoomOrders() {
		return this.roomOrders;
	}

	public void setRoomOrders(Set roomOrders) {
		this.roomOrders = roomOrders;
	}

	public Set getBuyCars() {
		return this.buyCars;
	}

	public void setBuyCars(Set buyCars) {
		this.buyCars = buyCars;
	}

	public Set getOutOrders() {
		return this.outOrders;
	}

	public void setOutOrders(Set outOrders) {
		this.outOrders = outOrders;
	}

}