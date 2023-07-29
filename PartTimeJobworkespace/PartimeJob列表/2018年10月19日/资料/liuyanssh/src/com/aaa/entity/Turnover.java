package com.aaa.entity;

/**
 * Turnover entity. @author MyEclipse Persistence Tools
 */

public class Turnover implements java.io.Serializable {

	// Fields

	private Integer turnoverId;
	private String onTotal;
	private String offTotal;
	private String overTotal;

	// Constructors

	/** default constructor */
	public Turnover() {
	}

	/** full constructor */
	public Turnover(String onTotal, String offTotal, String overTotal) {
		this.onTotal = onTotal;
		this.offTotal = offTotal;
		this.overTotal = overTotal;
	}

	// Property accessors

	public Integer getTurnoverId() {
		return this.turnoverId;
	}

	public void setTurnoverId(Integer turnoverId) {
		this.turnoverId = turnoverId;
	}

	public String getOnTotal() {
		return this.onTotal;
	}

	public void setOnTotal(String onTotal) {
		this.onTotal = onTotal;
	}

	public String getOffTotal() {
		return this.offTotal;
	}

	public void setOffTotal(String offTotal) {
		this.offTotal = offTotal;
	}

	public String getOverTotal() {
		return this.overTotal;
	}

	public void setOverTotal(String overTotal) {
		this.overTotal = overTotal;
	}

}