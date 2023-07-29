package com.aaa.entity;

import java.util.Date;

/**
 * RoomOrder entity. @author MyEclipse Persistence Tools
 */

public class RoomOrder implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Room room;
	private User user;
	private Menu menu;
	private Integer orderNum;
	private Date createDate;
	private Integer orderRoom;
	private Integer orderType;

	// Constructors

	/** default constructor */
	public RoomOrder() {
	}

	/** full constructor */
	public RoomOrder(Room room, User user, Menu menu, Integer orderNum, Date createDate, Integer orderRoom,
			Integer orderType) {
		this.room = room;
		this.user = user;
		this.menu = menu;
		this.orderNum = orderNum;
		this.createDate = createDate;
		this.orderRoom = orderRoom;
		this.orderType = orderType;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getOrderRoom() {
		return this.orderRoom;
	}

	public void setOrderRoom(Integer orderRoom) {
		this.orderRoom = orderRoom;
	}

	public Integer getOrderType() {
		return this.orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

}