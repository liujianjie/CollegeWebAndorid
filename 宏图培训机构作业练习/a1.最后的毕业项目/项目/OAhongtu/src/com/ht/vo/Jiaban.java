package com.ht.vo;

import java.util.Date;

/**
 * Jiaban entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Jiaban implements java.io.Serializable {

	// Fields

	private Long jid;
	private Long eid;
	private Date jstart;
	private Date jend;
	private Long jday;
	private Long jman;
	private String jdesc;
	private Long jstatu;

	// Constructors

	/** default constructor */
	public Jiaban() {
	}

	/** full constructor */
	public Jiaban(Long eid, Date jstart, Date jend, Long jday, Long jman,
			String jdesc, Long jstatu) {
		this.eid = eid;
		this.jstart = jstart;
		this.jend = jend;
		this.jday = jday;
		this.jman = jman;
		this.jdesc = jdesc;
		this.jstatu = jstatu;
	}

	// Property accessors

	public Long getJid() {
		return this.jid;
	}

	public void setJid(Long jid) {
		this.jid = jid;
	}

	public Long getEid() {
		return this.eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public Date getJstart() {
		return this.jstart;
	}

	public void setJstart(Date jstart) {
		this.jstart = jstart;
	}

	public Date getJend() {
		return this.jend;
	}

	public void setJend(Date jend) {
		this.jend = jend;
	}

	public Long getJday() {
		return this.jday;
	}

	public void setJday(Long jday) {
		this.jday = jday;
	}

	public Long getJman() {
		return this.jman;
	}

	public void setJman(Long jman) {
		this.jman = jman;
	}

	public String getJdesc() {
		return this.jdesc;
	}

	public void setJdesc(String jdesc) {
		this.jdesc = jdesc;
	}

	public Long getJstatu() {
		return this.jstatu;
	}

	public void setJstatu(Long jstatu) {
		this.jstatu = jstatu;
	}

}