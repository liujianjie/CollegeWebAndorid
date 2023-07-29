package com.ht.vo;

/**
 * Userroot entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Userroot implements java.io.Serializable {

	// Fields

	private Long urid;
	private Long userid;
	private String mid;

	// Constructors

	/** default constructor */
	public Userroot() {
	}

	/** full constructor */
	public Userroot(Long userid, String mid) {
		this.userid = userid;
		this.mid = mid;
	}

	// Property accessors

	public Long getUrid() {
		return this.urid;
	}

	public void setUrid(Long urid) {
		this.urid = urid;
	}

	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}



}