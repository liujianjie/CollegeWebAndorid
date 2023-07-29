package com.ht.vo;

import java.util.Date;

/**
 * Sroom entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Sroom implements java.io.Serializable {

	// Fields

	private Long srid;
	private Date srdate;
	private Long rooms;
	private Long empid;
	private String srclean;
	private String srdesc;

	// Constructors

	/** default constructor */
	public Sroom() {
	}

	/** full constructor */
	public Sroom(Date srdate, Long rooms, Long empid, String srclean,
			String srdesc) {
		this.srdate = srdate;
		this.rooms = rooms;
		this.empid = empid;
		this.srclean = srclean;
		this.srdesc = srdesc;
	}

	// Property accessors

	public Long getSrid() {
		return this.srid;
	}

	public void setSrid(Long srid) {
		this.srid = srid;
	}

	public Date getSrdate() {
		return this.srdate;
	}

	public void setSrdate(Date srdate) {
		this.srdate = srdate;
	}

	public Long getRooms() {
		return this.rooms;
	}

	public void setRooms(Long rooms) {
		this.rooms = rooms;
	}

	public Long getEmpid() {
		return this.empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getSrclean() {
		return this.srclean;
	}

	public void setSrclean(String srclean) {
		this.srclean = srclean;
	}

	public String getSrdesc() {
		return this.srdesc;
	}

	public void setSrdesc(String srdesc) {
		this.srdesc = srdesc;
	}

}