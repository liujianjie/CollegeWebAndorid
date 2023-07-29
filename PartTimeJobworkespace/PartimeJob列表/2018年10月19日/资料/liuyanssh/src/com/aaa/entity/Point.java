package com.aaa.entity;

/**
 * Point entity. @author MyEclipse Persistence Tools
 */

public class Point implements java.io.Serializable {

	// Fields

	private Integer pointId;
	private Integer pointNum;

	// Constructors

	/** default constructor */
	public Point() {
	}

	/** full constructor */
	public Point(Integer pointNum) {
		this.pointNum = pointNum;
	}

	// Property accessors

	public Integer getPointId() {
		return this.pointId;
	}

	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}

	public Integer getPointNum() {
		return this.pointNum;
	}

	public void setPointNum(Integer pointNum) {
		this.pointNum = pointNum;
	}

}