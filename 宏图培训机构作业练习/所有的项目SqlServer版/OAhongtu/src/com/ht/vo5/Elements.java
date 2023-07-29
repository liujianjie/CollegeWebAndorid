package com.ht.vo5;

import java.util.HashSet;
import java.util.Set;

/**
 * Elements entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Elements implements java.io.Serializable {

	// Fields

	private Long eid;
	private String ename;

	private Set hourse=new HashSet();

	public Set getHourse() {
		return hourse;
	}

	public void setHourse(Set hourse) {
		this.hourse = hourse;
	}

	/** default constructor */
	public Elements() {
	}

	/** full constructor */
	public Elements(String ename) {
		this.ename = ename;
	}

	// Property accessors

	public Long getEid() {
		return this.eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

}