package com.ht.vo;

import java.util.Date;

/**
 * Holday entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Holday implements java.io.Serializable {

	// Fields

	private Long hid;
	private Long eid;
	private String holdesc;
	private Date hstart;
	private Date hend;
	private Long hday;
	private Long holman;
	private Long hstatu;
	private String hkind;

	// Constructors

	/** default constructor */
	public Holday() {
	}

	/** full constructor */
	public Holday(Long eid, String holdesc, Date hstart, Date hend, Long hday,
			Long holman, Long hstatu, String hkind) {
		this.eid = eid;
		this.holdesc = holdesc;
		this.hstart = hstart;
		this.hend = hend;
		this.hday = hday;
		this.holman = holman;
		this.hstatu = hstatu;
		this.hkind = hkind;
	}

	// Property accessors

	public Long getHid() {
		return this.hid;
	}

	public void setHid(Long hid) {
		this.hid = hid;
	}

	public Long getEid() {
		return this.eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getHoldesc() {
		return this.holdesc;
	}

	public void setHoldesc(String holdesc) {
		this.holdesc = holdesc;
	}

	public Date getHstart() {
		return this.hstart;
	}

	public void setHstart(Date hstart) {
		this.hstart = hstart;
	}

	public Date getHend() {
		return this.hend;
	}

	public void setHend(Date hend) {
		this.hend = hend;
	}

	public Long getHday() {
		return this.hday;
	}

	public void setHday(Long hday) {
		this.hday = hday;
	}

	public Long getHolman() {
		return this.holman;
	}

	public void setHolman(Long holman) {
		this.holman = holman;
	}

	public Long getHstatu() {
		return this.hstatu;
	}

	public void setHstatu(Long hstatu) {
		this.hstatu = hstatu;
	}

	public String getHkind() {
		return this.hkind;
	}

	public void setHkind(String hkind) {
		this.hkind = hkind;
	}

}