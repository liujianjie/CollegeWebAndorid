package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */

public class Menu implements java.io.Serializable {

	// Fields

	private Integer menuId;
	private Type type;
	private String menuName;
	private String menuPrice;
	private Set buyCarMenus = new HashSet(0);
	private Set roomOrders = new HashSet(0);
	private Set orderMenus = new HashSet(0);

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** minimal constructor */
	public Menu(Type type, String menuName, String menuPrice) {
		this.type = type;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}

	/** full constructor */
	public Menu(Type type, String menuName, String menuPrice, Set buyCarMenus, Set roomOrders, Set orderMenus) {
		this.type = type;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.buyCarMenus = buyCarMenus;
		this.roomOrders = roomOrders;
		this.orderMenus = orderMenus;
	}

	// Property accessors

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuPrice() {
		return this.menuPrice;
	}

	public void setMenuPrice(String menuPrice) {
		this.menuPrice = menuPrice;
	}

	public Set getBuyCarMenus() {
		return this.buyCarMenus;
	}

	public void setBuyCarMenus(Set buyCarMenus) {
		this.buyCarMenus = buyCarMenus;
	}

	public Set getRoomOrders() {
		return this.roomOrders;
	}

	public void setRoomOrders(Set roomOrders) {
		this.roomOrders = roomOrders;
	}

	public Set getOrderMenus() {
		return this.orderMenus;
	}

	public void setOrderMenus(Set orderMenus) {
		this.orderMenus = orderMenus;
	}

}