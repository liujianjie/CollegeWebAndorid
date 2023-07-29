package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private Integer departmentId;
	private String departmentName;
	private Set depts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(String departmentName) {
		this.departmentName = departmentName;
	}

	/** full constructor */
	public Department(String departmentName, Set depts) {
		this.departmentName = departmentName;
		this.depts = depts;
	}

	// Property accessors

	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set getDepts() {
		return this.depts;
	}

	public void setDepts(Set depts) {
		this.depts = depts;
	}

}