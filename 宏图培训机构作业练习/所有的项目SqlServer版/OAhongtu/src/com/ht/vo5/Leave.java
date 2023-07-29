package com.ht.vo5;

import java.util.Date;

/**
 * Leave entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Leave implements java.io.Serializable {

	// Fields

	private Long lid;
	private String lname;
	private Date lstarttime;
	private Date lendtime;
	private Long ltime;
	private Long lshr;
	private Long lstuid;
	private Date ldate;
	private Long lstate;

	// Constructors

	/** default constructor */
	public Leave() {
	}

	/** minimal constructor */
	public Leave(String lname) {
		this.lname = lname;
	}

	/** full constructor */
	public Leave(String lname, Date lstarttime, Date lendtime, Long ltime,
			Long lshr, Long lstuid, Date ldate, Long lstate) {
		this.lname = lname;
		this.lstarttime = lstarttime;
		this.lendtime = lendtime;
		this.ltime = ltime;
		this.lshr = lshr;
		this.lstuid = lstuid;
		this.ldate = ldate;
		this.lstate = lstate;
	}

	// Property accessors

	public Long getLid() {
		return this.lid;
	}

	public void setLid(Long lid) {
		this.lid = lid;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Date getLstarttime() {
		return this.lstarttime;
	}

	public void setLstarttime(Date lstarttime) {
		this.lstarttime = lstarttime;
	}

	public Date getLendtime() {
		return this.lendtime;
	}

	public void setLendtime(Date lendtime) {
		this.lendtime = lendtime;
	}

	public Long getLtime() {
		return this.ltime;
	}

	public void setLtime(Long ltime) {
		this.ltime = ltime;
	}

	public Long getLshr() {
		return this.lshr;
	}

	public void setLshr(Long lshr) {
		this.lshr = lshr;
	}

	public Long getLstuid() {
		return this.lstuid;
	}

	public void setLstuid(Long lstuid) {
		this.lstuid = lstuid;
	}

	public Date getLdate() {
		return this.ldate;
	}

	public void setLdate(Date ldate) {
		this.ldate = ldate;
	}

	public Long getLstate() {
		return this.lstate;
	}

	public void setLstate(Long lstate) {
		this.lstate = lstate;
	}

}