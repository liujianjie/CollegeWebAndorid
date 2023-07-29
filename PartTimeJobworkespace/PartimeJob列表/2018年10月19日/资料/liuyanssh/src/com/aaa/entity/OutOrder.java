package com.aaa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * OutOrder entity. @author MyEclipse Persistence Tools
 */

public class OutOrder implements java.io.Serializable {

	// Fields

	private Integer outOrderId;
	private Delivery delivery;
	private User user;
	private Integer outOuderNum;
	private Date outCreateDate;
	private String outUserMessage;
	private Integer outOrderType;
	private Set orderMenus = new HashSet(0);
	private Set buyCarMenus = new HashSet(0);
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public OutOrder() {
	}

	/** minimal constructor */
	public OutOrder(Delivery delivery, User user, Integer outOuderNum, Date outCreateDate, Integer outOrderType) {
		this.delivery = delivery;
		this.user = user;
		this.outOuderNum = outOuderNum;
		this.outCreateDate = outCreateDate;
		this.outOrderType = outOrderType;
	}

	/** full constructor */
	public OutOrder(Delivery delivery, User user, Integer outOuderNum, Date outCreateDate, String outUserMessage,
			Integer outOrderType, Set orderMenus, Set buyCarMenus, Set comments) {
		this.delivery = delivery;
		this.user = user;
		this.outOuderNum = outOuderNum;
		this.outCreateDate = outCreateDate;
		this.outUserMessage = outUserMessage;
		this.outOrderType = outOrderType;
		this.orderMenus = orderMenus;
		this.buyCarMenus = buyCarMenus;
		this.comments = comments;
	}

	// Property accessors

	public Integer getOutOrderId() {
		return this.outOrderId;
	}

	public void setOutOrderId(Integer outOrderId) {
		this.outOrderId = outOrderId;
	}

	public Delivery getDelivery() {
		return this.delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getOutOuderNum() {
		return this.outOuderNum;
	}

	public void setOutOuderNum(Integer outOuderNum) {
		this.outOuderNum = outOuderNum;
	}

	public Date getOutCreateDate() {
		return this.outCreateDate;
	}

	public void setOutCreateDate(Date outCreateDate) {
		this.outCreateDate = outCreateDate;
	}

	public String getOutUserMessage() {
		return this.outUserMessage;
	}

	public void setOutUserMessage(String outUserMessage) {
		this.outUserMessage = outUserMessage;
	}

	public Integer getOutOrderType() {
		return this.outOrderType;
	}

	public void setOutOrderType(Integer outOrderType) {
		this.outOrderType = outOrderType;
	}

	public Set getOrderMenus() {
		return this.orderMenus;
	}

	public void setOrderMenus(Set orderMenus) {
		this.orderMenus = orderMenus;
	}

	public Set getBuyCarMenus() {
		return this.buyCarMenus;
	}

	public void setBuyCarMenus(Set buyCarMenus) {
		this.buyCarMenus = buyCarMenus;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

}