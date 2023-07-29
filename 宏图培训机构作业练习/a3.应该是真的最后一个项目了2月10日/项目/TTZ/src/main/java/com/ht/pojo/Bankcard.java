package com.ht.pojo;


/**
 * Bankcard entity. @author MyEclipse Persistence Tools
 */

public class Bankcard implements java.io.Serializable {

	// Fields

	private String bkid;
	private String bkcard;
	private String bktype;
	private String pcard;
	private Integer bkmoney;

	// Constructors

	/** default constructor */
	public Bankcard() {
	}

	/** minimal constructor */
	public Bankcard(String bkid) {
		this.bkid = bkid;
	}

	/** full constructor */
	public Bankcard(String bkid, String bkcard, String bktype, String pcard, Integer bkmoney) {
		this.bkid = bkid;
		this.bkcard = bkcard;
		this.bktype = bktype;
		this.pcard = pcard;
		this.bkmoney = bkmoney;
	}

	// Property accessors

	public String getBkid() {
		return this.bkid;
	}

	public void setBkid(String bkid) {
		this.bkid = bkid;
	}

	public String getBkcard() {
		return this.bkcard;
	}

	public void setBkcard(String bkcard) {
		this.bkcard = bkcard;
	}

	public String getBktype() {
		return this.bktype;
	}

	public void setBktype(String bktype) {
		this.bktype = bktype;
	}

	public String getPcard() {
		return this.pcard;
	}

	public void setPcard(String pcard) {
		this.pcard = pcard;
	}

	public Integer getBkmoney() {
		return this.bkmoney;
	}

	public void setBkmoney(Integer bkmoney) {
		this.bkmoney = bkmoney;
	}

}