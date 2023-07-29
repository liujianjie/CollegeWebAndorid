package com.aaa.entity;

/**
 * StaffDeptId entity. @author MyEclipse Persistence Tools
 */

public class StaffDeptId implements java.io.Serializable {

	// Fields

	private StaffDetail staffDetail;
	private Dept dept;

	// Constructors

	/** default constructor */
	public StaffDeptId() {
	}

	/** full constructor */
	public StaffDeptId(StaffDetail staffDetail, Dept dept) {
		this.staffDetail = staffDetail;
		this.dept = dept;
	}

	// Property accessors

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StaffDeptId))
			return false;
		StaffDeptId castOther = (StaffDeptId) other;

		return ((this.getStaffDetail() == castOther.getStaffDetail()) || (this.getStaffDetail() != null
				&& castOther.getStaffDetail() != null && this.getStaffDetail().equals(castOther.getStaffDetail())))
				&& ((this.getDept() == castOther.getDept()) || (this.getDept() != null && castOther.getDept() != null
						&& this.getDept().equals(castOther.getDept())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getStaffDetail() == null ? 0 : this.getStaffDetail().hashCode());
		result = 37 * result + (getDept() == null ? 0 : this.getDept().hashCode());
		return result;
	}

}