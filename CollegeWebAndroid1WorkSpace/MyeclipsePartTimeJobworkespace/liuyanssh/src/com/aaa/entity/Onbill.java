package com.aaa.entity;

import java.util.Date;

/**
 * Onbill entity. @author MyEclipse Persistence Tools
 */

public class Onbill implements java.io.Serializable {

	// Fields

	private Integer onId;
	private String onPrice;
	private String onSeason;
	private Date onDate;

	// Constructors

	/** default constructor */
	public Onbill() {
	}

	/** full constructor */
	public Onbill(String onPrice, String onSeason, Date onDate) {
		this.onPrice = onPrice;
		this.onSeason = onSeason;
		this.onDate = onDate;
	}

	// Property accessors

	public Integer getOnId() {
		return this.onId;
	}

	public void setOnId(Integer onId) {
		this.onId = onId;
	}

	public String getOnPrice() {
		return this.onPrice;
	}

	public void setOnPrice(String onPrice) {
		this.onPrice = onPrice;
	}

	public String getOnSeason() {
		return this.onSeason;
	}

	public void setOnSeason(String onSeason) {
		this.onSeason = onSeason;
	}

	public Date getOnDate() {
		return this.onDate;
	}

	public void setOnDate(Date onDate) {
		this.onDate = onDate;
	}

}