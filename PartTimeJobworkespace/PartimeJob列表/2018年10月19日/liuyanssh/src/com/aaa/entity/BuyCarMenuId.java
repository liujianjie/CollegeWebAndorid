package com.aaa.entity;

/**
 * BuyCarMenuId entity. @author MyEclipse Persistence Tools
 */

public class BuyCarMenuId implements java.io.Serializable {

	// Fields

	private Menu menu;
	private OutOrder outOrder;

	// Constructors

	/** default constructor */
	public BuyCarMenuId() {
	}

	/** full constructor */
	public BuyCarMenuId(Menu menu, OutOrder outOrder) {
		this.menu = menu;
		this.outOrder = outOrder;
	}

	// Property accessors

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public OutOrder getOutOrder() {
		return this.outOrder;
	}

	public void setOutOrder(OutOrder outOrder) {
		this.outOrder = outOrder;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BuyCarMenuId))
			return false;
		BuyCarMenuId castOther = (BuyCarMenuId) other;

		return ((this.getMenu() == castOther.getMenu()) || (this.getMenu() != null && castOther.getMenu() != null
				&& this.getMenu().equals(castOther.getMenu())))
				&& ((this.getOutOrder() == castOther.getOutOrder()) || (this.getOutOrder() != null
						&& castOther.getOutOrder() != null && this.getOutOrder().equals(castOther.getOutOrder())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMenu() == null ? 0 : this.getMenu().hashCode());
		result = 37 * result + (getOutOrder() == null ? 0 : this.getOutOrder().hashCode());
		return result;
	}

}