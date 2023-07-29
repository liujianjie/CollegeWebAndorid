package com.aaa.entity;

/**
 * Staff entity. @author MyEclipse Persistence Tools
 */

public class Staff implements java.io.Serializable {

	// Fields

	private Integer staffId;
	private StaffDetail staffDetail;
	private String staffUserName;
	private String staffUserPwd;

	// Constructors

	/** default constructor */
	public Staff() {
	}

	/** full constructor */
	public Staff(StaffDetail staffDetail, String staffUserName, String staffUserPwd) {
		this.staffDetail = staffDetail;
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

	public StaffDetail getStaffDetail() {
		return this.staffDetail;
	}

	public void setStaffDetail(StaffDetail staffDetail) {
		this.staffDetail = staffDetail;
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