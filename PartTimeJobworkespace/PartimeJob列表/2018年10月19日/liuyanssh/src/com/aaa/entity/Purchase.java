package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Purchase entity. @author MyEclipse Persistence Tools
 */

public class Purchase implements java.io.Serializable {

	// Fields

	private Integer purchaseId;
	private PurchaseDetail purchaseDetail;
	private Supplier supplier;
	private Set warehouses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Purchase() {
	}

	/** minimal constructor */
	public Purchase(PurchaseDetail purchaseDetail, Supplier supplier) {
		this.purchaseDetail = purchaseDetail;
		this.supplier = supplier;
	}

	/** full constructor */
	public Purchase(PurchaseDetail purchaseDetail, Supplier supplier, Set warehouses) {
		this.purchaseDetail = purchaseDetail;
		this.supplier = supplier;
		this.warehouses = warehouses;
	}

	// Property accessors

	public Integer getPurchaseId() {
		return this.purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public PurchaseDetail getPurchaseDetail() {
		return this.purchaseDetail;
	}

	public void setPurchaseDetail(PurchaseDetail purchaseDetail) {
		this.purchaseDetail = purchaseDetail;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Set getWarehouses() {
		return this.warehouses;
	}

	public void setWarehouses(Set warehouses) {
		this.warehouses = warehouses;
	}

}