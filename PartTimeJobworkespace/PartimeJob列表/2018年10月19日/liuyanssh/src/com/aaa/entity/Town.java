package com.aaa.entity;

/**
 * Town entity. @author MyEclipse Persistence Tools
 */

public class Town implements java.io.Serializable {

	// Fields

	private Integer townId;
	private String townName;

	// Constructors

	/** default constructor */
	public Town() {
	}

	/** full constructor */
	public Town(String townName) {
		this.townName = townName;
	}

	// Property accessors

	public Integer getTownId() {
		return this.townId;
	}

	public void setTownId(Integer townId) {
		this.townId = townId;
	}

	public String getTownName() {
		return this.townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

}