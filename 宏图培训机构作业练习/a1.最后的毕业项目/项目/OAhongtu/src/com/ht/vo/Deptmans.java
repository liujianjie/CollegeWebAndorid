package com.ht.vo;

/**
 * Deptmans entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Deptmans implements java.io.Serializable {

	// Fields

	private Long dmid;
	private String dmname;

	// Constructors

	/** default constructor */
	public Deptmans() {
	}

	/** full constructor */
	public Deptmans(String dmname) {
		this.dmname = dmname;
	}

	// Property accessors

	public Long getDmid() {
		return this.dmid;
	}

	public void setDmid(Long dmid) {
		this.dmid = dmid;
	}

	public String getDmname() {
		return this.dmname;
	}

	public void setDmname(String dmname) {
		this.dmname = dmname;
	}

}