package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Supplier entity. @author MyEclipse Persistence Tools
 */

public class Supplier implements java.io.Serializable {

	// Fields

	private Integer supplierId;
	private String supplierName;
	private String supplierAddress;
	private String supplierPhone;
	private Set purchases = new HashSet(0);

	// Constructors

	/** default constructor */
	public Supplier() {
	}

	/** minimal constructor */
	public Supplier(String supplierName, String supplierAddress, String supplierPhone) {
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.supplierPhone = supplierPhone;
	}

	/** full constructor */
	public Supplier(String supplierName, String supplierAddress, String supplierPhone, Set purchases) {
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.supplierPhone = supplierPhone;
		this.purchases = purchases;
	}

	// Property accessors

	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddress() {
		return this.supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierPhone() {
		return this.supplierPhone;
	}

	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}

	public Set getPurchases() {
		return this.purchases;
	}

	public void setPurchases(Set purchases) {
		this.purchases = purchases;
	}

}