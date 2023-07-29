package com.ht.pojo;

/**
 * Ttzbank entity. @author MyEclipse Persistence Tools
 */

public class Ttzbank implements java.io.Serializable {

	// Fields

	private String tbid;
	private String userid;
	private String username;
	private String bankcard;
	private String banktype;
	private String idcard;
	
	
	//mapper”≥…‰
	private String bkmoney;//”‡∂Ó

	// Constructors

	/** default constructor */
	public Ttzbank() {
	}

	/** minimal constructor */
	public Ttzbank(String tbid) {
		this.tbid = tbid;
	}

	
	// Property accessors

	public String getBkmoney() {
		return bkmoney;
	}

	public void setBkmoney(String bkmoney) {
		this.bkmoney = bkmoney;
	}

	public Ttzbank(String tbid, String userid, String username, String bankcard, String banktype, String idcard) {
		super();
		this.tbid = tbid;
		this.userid = userid;
		this.username = username;
		this.bankcard = bankcard;
		this.banktype = banktype;
		this.idcard = idcard;
	}
	
	

	public String getBanktype() {
		return banktype;
	}

	public void setBanktype(String banktype) {
		this.banktype = banktype;
	}

	public String getTbid() {
		return this.tbid;
	}

	public void setTbid(String tbid) {
		this.tbid = tbid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBankcard() {
		return this.bankcard;
	}

	public void setBankcard(String bankcard) {
		this.bankcard = bankcard;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

}