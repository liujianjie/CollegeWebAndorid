package com.aaa.entity;

/**
 * BuyCarMenu entity. @author MyEclipse Persistence Tools
 */

public class BuyCarMenu implements java.io.Serializable {

	// Fields

	private BuyCarMenuId id;
	private OutOrder outOrder;
	private Menu menu;

	// Constructors

	/** default constructor */
	public BuyCarMenu() {
	}

	/** full constructor */
	public BuyCarMenu(BuyCarMenuId id, OutOrder outOrder, Menu menu) {
		this.id = id;
		this.outOrder = outOrder;
		this.menu = menu;
	}

	// Property accessors

	public BuyCarMenuId getId() {
		return this.id;
	}

	public void setId(BuyCarMenuId id) {
		this.id = id;
	}

	public OutOrder getOutOrder() {
		return this.outOrder;
	}

	public void setOutOrder(OutOrder outOrder) {
		this.outOrder = outOrder;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}