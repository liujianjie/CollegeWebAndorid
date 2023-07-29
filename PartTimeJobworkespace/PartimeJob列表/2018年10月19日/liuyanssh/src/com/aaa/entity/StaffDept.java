package com.aaa.entity;

/**
 * StaffDept entity. @author MyEclipse Persistence Tools
 */

public class StaffDept implements java.io.Serializable {

	// Fields

	private StaffDeptId id;
	private StaffDetail staffDetail;
	private Dept dept;

	// Constructors

	/** default constructor */
	public StaffDept() {
	}

	/** full constructor */
	public StaffDept(StaffDeptId id, StaffDetail staffDetail, Dept dept) {
		this.id = id;
		this.staffDetail = staffDetail;
		this.dept = dept;
	}

	// Property accessors

	public StaffDeptId getId() {
		return this.id;
	}

	public void setId(StaffDeptId id) {
		this.id = id;
	}

	public StaffDetail getStaffDetail() {
		return this.staffDetail;
	}

	public void setStaffDetail(StaffDetail staffDetail) {
		this.staffDetail = staffDetail;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

}