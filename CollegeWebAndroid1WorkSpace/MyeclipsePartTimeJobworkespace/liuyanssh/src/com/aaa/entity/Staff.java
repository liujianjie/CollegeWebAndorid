package com.aaa.entity;

/**
 * Staff entity. @author MyEclipse Persistence Tools
 */

public class Staff implements java.io.Serializable {

	// Fields

	private Integer staffId;
//	private StaffDetail staffDetail;
	private Staff staff;
	private String staffUserName;
	private String staffUserPwd;

	// Constructors

	/** default constructor */
	public Staff() {
	}

	/** full constructor */
	public Staff(Staff staff, String staffUserName, String staffUserPwd) {
		this.staff = staff;
		this.staffUserName = staffUserName;
		this.staffUserPwd = staffUserPwd;
	}

	// Property accessors
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

//	public StaffDetail getStaffDetail() {
//		return this.staffDetail;
//	}
//
//	public void setStaffDetail(StaffDetail staffDetail) {
//		this.staffDetail = staffDetail;
//	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getStaffUserName() {
		return this.staffUserName;
	}

	public void setStaffUserName(String staffUserName) {
		this.staffUserName = staffUserName;
	}

	public String getStaffUserPwd() {
		return this.staffUserPwd;
	}

	public void setStaffUserPwd(String staffUserPwd) {
		this.staffUserPwd = staffUserPwd;
	}

}