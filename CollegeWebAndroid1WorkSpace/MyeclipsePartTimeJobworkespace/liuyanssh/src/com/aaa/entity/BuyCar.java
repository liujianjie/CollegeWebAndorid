package com.aaa.entity;

/**
 * BuyCar entity. @author MyEclipse Persistence Tools
 */

public class BuyCar implements java.io.Serializable {

	// Fields

	private Integer buyCarId;
	private User user;

	// Constructors

	/** default constructor */
	public BuyCar() {
	}

	/** full constructor */
	public BuyCar(User user) {
		this.user = user;
	}

	// Property accessors

	public Integer getBuyCarId() {
		return this.buyCarId;
	}

	public void setBuyCarId(Integer buyCarId) {
		this.buyCarId = buyCarId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}