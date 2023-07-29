package com.ht.vo;

/**
 * Record entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Record implements java.io.Serializable {

	// Fields

	private Long reid;
	private Long empid;
	private String year;
	private String mouse;
	private String day;
	private String times;

	// Constructors

	/** default constructor */
	public Record() {
	}

	/** full constructor */
	public Record(Long empid, String year, String mouse, String day,
			String times) {
		this.empid = empid;
		this.year = year;
		this.mouse = mouse;
		this.day = day;
		this.times = times;
	}

	// Property accessors

	public Long getReid() {
		return this.reid;
	}

	public void setReid(Long reid) {
		this.reid = reid;
	}

	public Long getEmpid() {
		return this.empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMouse() {
		return this.mouse;
	}

	public void setMouse(String mouse) {
		this.mouse = mouse;
	}

	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTimes() {
		return this.times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

}