package com.ht.vo2;

import java.util.HashSet;
import java.util.Set;

/**
 * Course entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private Long couid;
	private String couname;	
	
	
	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(String couname) {
		this.couname = couname;
	}

	// Property accessors

	public Long getCouid() {
		return this.couid;
	}

	public void setCouid(Long couid) {
		this.couid = couid;
	}

	public String getCouname() {
		return this.couname;
	}

	public void setCouname(String couname) {
		this.couname = couname;
	}
	
}