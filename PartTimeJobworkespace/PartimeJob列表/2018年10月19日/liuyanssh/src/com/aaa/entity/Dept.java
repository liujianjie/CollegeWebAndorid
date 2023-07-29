package com.aaa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Dept entity. @author MyEclipse Persistence Tools
 */

public class Dept implements java.io.Serializable {

	// Fields

	private Integer deptId;
	private Department department;
	private String deptName;
	private Integer departmentId;
	private Set levelDepts = new HashSet(0);
	private Set staffDepts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Dept() {
	}

	/** minimal constructor */
	public Dept(Department department, String deptName) {
//		this.department = department;
		this.deptName = deptName;
	}
	
	public Dept(Integer deptId,String deptName, Integer departmentId) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.departmentId = departmentId;
	}

	/** full constructor */
	public Dept(Department department, String deptName, Set levelDepts, Set staffDepts) {
		this.department = department;
		this.deptName = deptName;
		this.levelDepts = levelDepts;
		this.staffDepts = staffDepts;
	}
	
	// Property accessors

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set getLevelDepts() {
		return this.levelDepts;
	}

	public void setLevelDepts(Set levelDepts) {
		this.levelDepts = levelDepts;
	}

	public Set getStaffDepts() {
		return this.staffDepts;
	}

	public void setStaffDepts(Set staffDepts) {
		this.staffDepts = staffDepts;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

}