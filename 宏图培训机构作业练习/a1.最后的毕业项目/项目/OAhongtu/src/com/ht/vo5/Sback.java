package com.ht.vo5;

import java.util.Date;

/**
 * Sback entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Sback implements java.io.Serializable {

	// Fields

	private Long sbackid;
	private Long stdid;
	private String sbacktitle;
	private String sbackcon;
	private Date sdate;
	private Long sempid;
	private Long statu;

	// Constructors

	/** default constructor */
	public Sback() {
	}

	/** minimal constructor */
	public Sback(Long stdid, String sbacktitle, String sbackcon, Date sdate,
			Long sempid) {
		this.stdid = stdid;
		this.sbacktitle = sbacktitle;
		this.sbackcon = sbackcon;
		this.sdate = sdate;
		this.sempid = sempid;
	}

	/** full constructor */
	public Sback(Long stdid, String sbacktitle, String sbackcon, Date sdate,
			Long sempid, Long statu) {
		this.stdid = stdid;
		this.sbacktitle = sbacktitle;
		this.sbackcon = sbackcon;
		this.sdate = sdate;
		this.sempid = sempid;
		this.statu = statu;
	}

	// Property accessors

	public Long getSbackid() {
		return this.sbackid;
	}

	public void setSbackid(Long sbackid) {
		this.sbackid = sbackid;
	}

	public Long getStdid() {
		return this.stdid;
	}

	public void setStdid(Long stdid) {
		this.stdid = stdid;
	}

	public String getSbacktitle() {
		return this.sbacktitle;
	}

	public void setSbacktitle(String sbacktitle) {
		this.sbacktitle = sbacktitle;
	}

	public String getSbackcon() {
		return this.sbackcon;
	}

	public void setSbackcon(String sbackcon) {
		this.sbackcon = sbackcon;
	}

	public Date getSdate() {
		return this.sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Long getSempid() {
		return this.sempid;
	}

	public void setSempid(Long sempid) {
		this.sempid = sempid;
	}

	public Long getStatu() {
		return this.statu;
	}

	public void setStatu(Long statu) {
		this.statu = statu;
	}

}