package com.aaa.entity;

import java.util.Date;

/**
 * Offbill entity. @author MyEclipse Persistence Tools
 */

public class Offbill implements java.io.Serializable {

	// Fields

	private Integer offId;
	private String offPrice;
	private String offSeason;
	private Date offDate;

	// Constructors

	/** default constructor */
	public Offbill() {
	}

	/** full constructor */
	public Offbill(String offPrice, String offSeason, Date offDate) {
		this.offPrice = offPrice;
		this.offSeason = offSeason;
		this.offDate = offDate;
	}

	// Property accessors

	public Integer getOffId() {
		return this.offId;
	}

	public void setOffId(Integer offId) {
		this.offId = offId;
	}

	public String getOffPrice() {
		return this.offPrice;
	}

	public void setOffPrice(String offPrice) {
		this.offPrice = offPrice;
	}

	public String getOffSeason() {
		return this.offSeason;
	}

	public void setOffSeason(String offSeason) {
		this.offSeason = offSeason;
	}

	public Date getOffDate() {
		return this.offDate;
	}

	public void setOffDate(Date offDate) {
		this.offDate = offDate;
	}

}