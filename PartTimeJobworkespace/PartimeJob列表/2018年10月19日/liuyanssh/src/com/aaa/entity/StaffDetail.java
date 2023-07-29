package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * StaffDetail entity. @author MyEclipse Persistence Tools
 */

public class StaffDetail implements java.io.Serializable {

	// Fields

	private Integer staffDetailId;
	private String staffName;
	private Integer staffAge;
	private String staffPhone;
	private String staffAddress;
	private String staffPay;
	private Set staffs = new HashSet(0);
	private Set staffDepts = new HashSet(0);

	// Constructors

	/** default constructor */
	public StaffDetail() {
	}

	/** minimal constructor */
	public StaffDetail(String staffName, Integer staffAge, String staffPhone, String staffPay) {
		this.staffName = staffName;
		this.staffAge = staffAge;
		this.staffPhone = staffPhone;
		this.staffPay = staffPay;
	}

	/** full constructor */
	public StaffDetail(String staffName, Integer staffAge, String staffPhone, String staffAddress, String staffPay,
			Set staffs, Set staffDepts) {
		this.staffName = staffName;
		this.staffAge = staffAge;
		this.staffPhone = staffPhone;
		this.staffAddress = staffAddress;
		this.staffPay = staffPay;
		this.staffs = staffs;
		this.staffDepts = staffDepts;
	}

	// Property accessors

	public Integer getStaffDetailId() {
		return this.staffDetailId;
	}

	public void setStaffDetailId(Integer staffDetailId) {
		this.staffDetailId = staffDetailId;
	}

	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Integer getStaffAge() {
		return this.staffAge;
	}

	public void setStaffAge(Integer staffAge) {
		this.staffAge = staffAge;
	}

	public String getStaffPhone() {
		return this.staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}

	public String getStaffAddress() {
		return this.staffAddress;
	}

	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}

	public String getStaffPay() {
		return this.staffPay;
	}

	public void setStaffPay(String staffPay) {
		this.staffPay = staffPay;
	}

	public Set getStaffs() {
		return this.staffs;
	}

	public void setStaffs(Set staffs) {
		this.staffs = staffs;
	}

	public Set getStaffDepts() {
		return this.staffDepts;
	}

	public void setStaffDepts(Set staffDepts) {
		this.staffDepts = staffDepts;
	}

}