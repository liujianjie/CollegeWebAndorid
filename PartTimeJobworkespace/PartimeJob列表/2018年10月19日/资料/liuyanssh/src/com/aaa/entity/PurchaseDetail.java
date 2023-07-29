package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * PurchaseDetail entity. @author MyEclipse Persistence Tools
 */

public class PurchaseDetail implements java.io.Serializable {

	// Fields

	private Integer pdId;
	private String pdName;
	private Integer pdNum;
	private String pdPrice;
	private String pdTotal;
	private Integer pdState;
	private Set purchases = new HashSet(0);

	// Constructors

	/** default constructor */
	public PurchaseDetail() {
	}

	/** minimal constructor */
	public PurchaseDetail(String pdName, Integer pdNum, String pdPrice, String pdTotal, Integer pdState) {
		this.pdName = pdName;
		this.pdNum = pdNum;
		this.pdPrice = pdPrice;
		this.pdTotal = pdTotal;
		this.pdState = pdState;
	}

	/** full constructor */
	public PurchaseDetail(String pdName, Integer pdNum, String pdPrice, String pdTotal, Integer pdState,
			Set purchases) {
		this.pdName = pdName;
		this.pdNum = pdNum;
		this.pdPrice = pdPrice;
		this.pdTotal = pdTotal;
		this.pdState = pdState;
		this.purchases = purchases;
	}

	// Property accessors

	public Integer getPdId() {
		return this.pdId;
	}

	public void setPdId(Integer pdId) {
		this.pdId = pdId;
	}

	public String getPdName() {
		return this.pdName;
	}

	public void setPdName(String pdName) {
		this.pdName = pdName;
	}

	public Integer getPdNum() {
		return this.pdNum;
	}

	public void setPdNum(Integer pdNum) {
		this.pdNum = pdNum;
	}

	public String getPdPrice() {
		return this.pdPrice;
	}

	public void setPdPrice(String pdPrice) {
		this.pdPrice = pdPrice;
	}

	public String getPdTotal() {
		return this.pdTotal;
	}

	public void setPdTotal(String pdTotal) {
		this.pdTotal = pdTotal;
	}

	public Integer getPdState() {
		return this.pdState;
	}

	public void setPdState(Integer pdState) {
		this.pdState = pdState;
	}

	public Set getPurchases() {
		return this.purchases;
	}

	public void setPurchases(Set purchases) {
		this.purchases = purchases;
	}

}