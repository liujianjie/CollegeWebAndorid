package com.ht.vo2;

/**
 * Saveyear entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Saveyear implements java.io.Serializable {

	// Fields

	private Long yearid;
	private Long yearname;

	// Constructors

	/** default constructor */
	public Saveyear() {
	}

	/** full constructor */
	public Saveyear(Long yearname) {
		this.yearname = yearname;
	}

	// Property accessors

	public Long getYearid() {
		return this.yearid;
	}

	public void setYearid(Long yearid) {
		this.yearid = yearid;
	}

	public Long getYearname() {
		return this.yearname;
	}

	public void setYearname(Long yearname) {
		this.yearname = yearname;
	}

}