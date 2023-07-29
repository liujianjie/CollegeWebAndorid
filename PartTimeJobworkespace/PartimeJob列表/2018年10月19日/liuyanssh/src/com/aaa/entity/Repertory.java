package com.aaa.entity;

/**
 * Repertory entity. @author MyEclipse Persistence Tools
 */

public class Repertory implements java.io.Serializable {

	// Fields

	private Integer rpId;
	private String rpName;
	private Integer rpNum;

	// Constructors

	/** default constructor */
	public Repertory() {
	}

	/** full constructor */
	public Repertory(String rpName, Integer rpNum) {
		this.rpName = rpName;
		this.rpNum = rpNum;
	}

	// Property accessors

	public Integer getRpId() {
		return this.rpId;
	}

	public void setRpId(Integer rpId) {
		this.rpId = rpId;
	}

	public String getRpName() {
		return this.rpName;
	}

	public void setRpName(String rpName) {
		this.rpName = rpName;
	}

	public Integer getRpNum() {
		return this.rpNum;
	}

	public void setRpNum(Integer rpNum) {
		this.rpNum = rpNum;
	}

}