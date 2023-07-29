package com.ht.vo;

import java.util.Date;

/**
 * Rizhi entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Rizhi implements java.io.Serializable {

	// Fields

	private Long rid;
	private Date rdate;
	private Long eid;
	private String rdesc;
	private String rques;

	// Constructors

	/** default constructor */
	public Rizhi() {
	}

	/** full constructor */
	public Rizhi(Date rdate, Long eid, String rdesc, String rques) {
		this.rdate = rdate;
		this.eid = eid;
		this.rdesc = rdesc;
		this.rques = rques;
	}

	// Property accessors

	public Long getRid() {
		return this.rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Date getRdate() {
		return this.rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public Long getEid() {
		return this.eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getRdesc() {
		return this.rdesc;
	}

	public void setRdesc(String rdesc) {
		this.rdesc = rdesc;
	}

	public String getRques() {
		return this.rques;
	}

	public void setRques(String rques) {
		this.rques = rques;
	}

}