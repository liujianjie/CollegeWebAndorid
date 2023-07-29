package com.ht.vo;

import java.util.Date;

/**
 * Education entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Education implements java.io.Serializable {

	// Fields

	private Long edid;
	private Long eid;
	private Date edstart;
	private Date edend;
	private String edschool;
	private String edu;

	// Constructors

	/** default constructor */
	public Education() {
	}

	/** full constructor */
	public Education(Long eid, Date edstart, Date edend, String edschool,
			String edu) {
		this.eid = eid;
		this.edstart = edstart;
		this.edend = edend;
		this.edschool = edschool;
		this.edu = edu;
	}

	// Property accessors

	public Long getEdid() {
		return this.edid;
	}

	public void setEdid(Long edid) {
		this.edid = edid;
	}


	public Date getEdstart() {
		return this.edstart;
	}

	public void setEdstart(Date edstart) {
		this.edstart = edstart;
	}

	public Date getEdend() {
		return this.edend;
	}

	public void setEdend(Date edend) {
		this.edend = edend;
	}

	public String getEdschool() {
		return this.edschool;
	}

	public void setEdschool(String edschool) {
		this.edschool = edschool;
	}

	public String getEdu() {
		return this.edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

}