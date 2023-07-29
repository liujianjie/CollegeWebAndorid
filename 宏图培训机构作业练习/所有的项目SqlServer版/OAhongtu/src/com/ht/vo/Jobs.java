package com.ht.vo;

import java.util.Date;

/**
 * Jobs entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Jobs implements java.io.Serializable {

	// Fields

	private Long jid;
	private Long eid;
	private Date jstart;
	private Date jend;
	private String jcompany;
	private String jedu;
	private String jpeople;
	private String jtel;

	// Constructors

	/** default constructor */
	public Jobs() {
	}

	/** full constructor */
	public Jobs(Long eid, Date jstart, Date jend, String jcompany, String jedu,
			String jpeople, String jtel) {
		this.eid = eid;
		this.jstart = jstart;
		this.jend = jend;
		this.jcompany = jcompany;
		this.jedu = jedu;
		this.jpeople = jpeople;
		this.jtel = jtel;
	}

	// Property accessors

	public Long getJid() {
		return this.jid;
	}

	public void setJid(Long jid) {
		this.jid = jid;
	}


	public Long getEid() {
		return eid;
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

	public String getJcompany() {
		return this.jcompany;
	}

	public void setJcompany(String jcompany) {
		this.jcompany = jcompany;
	}

	public String getJedu() {
		return this.jedu;
	}

	public void setJedu(String jedu) {
		this.jedu = jedu;
	}

	public String getJpeople() {
		return this.jpeople;
	}

	public void setJpeople(String jpeople) {
		this.jpeople = jpeople;
	}

	public String getJtel() {
		return this.jtel;
	}

	public void setJtel(String jtel) {
		this.jtel = jtel;
	}

}