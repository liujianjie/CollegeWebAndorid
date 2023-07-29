package com.aaa.entity;

/**
 * OrderMenu entity. @author MyEclipse Persistence Tools
 */

public class OrderMenu implements java.io.Serializable {

	// Fields

	private OrderMenuId id;
	private OutOrder outOrder;
	private Menu menu;

	// Constructors

	/** default constructor */
	public OrderMenu() {
	}

	/** full constructor */
	public OrderMenu(OrderMenuId id, OutOrder outOrder, Menu menu) {
		this.id = id;
		this.outOrder = outOrder;
		this.menu = menu;
	}

	// Property accessors

	public OrderMenuId getId() {
		return this.id;
	}

	public void setId(OrderMenuId id) {
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