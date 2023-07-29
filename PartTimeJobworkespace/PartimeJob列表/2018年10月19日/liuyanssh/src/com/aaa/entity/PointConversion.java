package com.aaa.entity;

/**
 * PointConversion entity. @author MyEclipse Persistence Tools
 */

public class PointConversion implements java.io.Serializable {

	// Fields

	private Integer pcId;
	private String pcName;
	private Integer pcNeedPoint;
	private Integer pcNum;

	// Constructors

	/** default constructor */
	public PointConversion() {
	}

	/** full constructor */
	public PointConversion(String pcName, Integer pcNeedPoint, Integer pcNum) {
		this.pcName = pcName;
		this.pcNeedPoint = pcNeedPoint;
		this.pcNum = pcNum;
	}

	// Property accessors

	public Integer getPcId() {
		return this.pcId;
	}

	public void setPcId(Integer pcId) {
		this.pcId = pcId;
	}

	public String getPcName() {
		return this.pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public Integer getPcNeedPoint() {
		return this.pcNeedPoint;
	}

	public void setPcNeedPoint(Integer pcNeedPoint) {
		this.pcNeedPoint = pcNeedPoint;
	}

	public Integer getPcNum() {
		return this.pcNum;
	}

	public void setPcNum(Integer pcNum) {
		this.pcNum = pcNum;
	}

}