package com.ht.vo;

/**
 * Family entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Family implements java.io.Serializable {

	// Fields

	private Long fid;
	private Long eid;
	private String fname;
	private String fjob;
	private String frelation;
	private String ftel;

	// Constructors

	/** default constructor */
	public Family() {
	}

	/** full constructor */
	public Family(Long eid, String fname, String fjob, String frelation,
			String ftel) {
		this.eid = eid;
		this.fname = fname;
		this.fjob = fjob;
		this.frelation = frelation;
		this.ftel = ftel;
	}

	// Property accessors

	public Long getFid() {
		return this.fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFjob() {
		return this.fjob;
	}

	public void setFjob(String fjob) {
		this.fjob = fjob;
	}

	public String getFrelation() {
		return this.frelation;
	}

	public void setFrelation(String frelation) {
		this.frelation = frelation;
	}

	public String getFtel() {
		return this.ftel;
	}

	public void setFtel(String ftel) {
		this.ftel = ftel;
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

}