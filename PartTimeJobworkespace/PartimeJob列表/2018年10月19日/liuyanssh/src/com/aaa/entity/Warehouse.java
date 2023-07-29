package com.aaa.entity;

/**
 * Warehouse entity. @author MyEclipse Persistence Tools
 */

public class Warehouse implements java.io.Serializable {

	// Fields

	private Integer wsId;
	private Purchase purchase;

	// Constructors

	/** default constructor */
	public Warehouse() {
	}

	/** full constructor */
	public Warehouse(Purchase purchase) {
		this.purchase = purchase;
	}

	// Property accessors

	public Integer getWsId() {
		return this.wsId;
	}

	public void setWsId(Integer wsId) {
		this.wsId = wsId;
	}

	public Purchase getPurchase() {
		return this.purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

}