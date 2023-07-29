package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Delivery entity. @author MyEclipse Persistence Tools
 */

public class Delivery implements java.io.Serializable {

	// Fields

	private Integer deliveryId;
	private String deliveryName;
	private String deliveryPhone;
	private Set outOrders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Delivery() {
	}

	/** minimal constructor */
	public Delivery(String deliveryName, String deliveryPhone) {
		this.deliveryName = deliveryName;
		this.deliveryPhone = deliveryPhone;
	}

	/** full constructor */
	public Delivery(String deliveryName, String deliveryPhone, Set outOrders) {
		this.deliveryName = deliveryName;
		this.deliveryPhone = deliveryPhone;
		this.outOrders = outOrders;
	}

	// Property accessors

	public Integer getDeliveryId() {
		return this.deliveryId;
	}

	public void setDeliveryId(Integer deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getDeliveryName() {
		return this.deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryPhone() {
		return this.deliveryPhone;
	}

	public void setDeliveryPhone(String deliveryPhone) {
		this.deliveryPhone = deliveryPhone;
	}

	public Set getOutOrders() {
		return this.outOrders;
	}

	public void setOutOrders(Set outOrders) {
		this.outOrders = outOrders;
	}

}