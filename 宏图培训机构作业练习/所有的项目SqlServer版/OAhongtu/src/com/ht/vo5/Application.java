package com.ht.vo5;

import java.util.Date;

/**
 * Application entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Application implements java.io.Serializable {

	// Fields

	private Long aid;
	private String aname;
	private Long atime;
	private Long astuid;
	private Date astarttime;
	private Date aendtime;
	private Long ashr;
	private Long astate;

	// Constructors

	/** default constructor */
	public Application() {
	}

	/** full constructor */
	public Application(String aname, Long atime, Long astuid, Date astarttime,
			Date aendtime, Long ashr, Long astate) {
		this.aname = aname;
		this.atime = atime;
		this.astuid = astuid;
		this.astarttime = astarttime;
		this.aendtime = aendtime;
		this.ashr = ashr;
		this.astate = astate;
	}

	// Property accessors

	public Long getAid() {
		return this.aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Long getAtime() {
		return this.atime;
	}

	public void setAtime(Long atime) {
		this.atime = atime;
	}

	public Long getAstuid() {
		return this.astuid;
	}

	public void setAstuid(Long astuid) {
		this.astuid = astuid;
	}

	public Date getAstarttime() {
		return this.astarttime;
	}

	public void setAstarttime(Date astarttime) {
		this.astarttime = astarttime;
	}

	public Date getAendtime() {
		return this.aendtime;
	}

	public void setAendtime(Date aendtime) {
		this.aendtime = aendtime;
	}

	public Long getAshr() {
		return this.ashr;
	}

	public void setAshr(Long ashr) {
		this.ashr = ashr;
	}

	public Long getAstate() {
		return this.astate;
	}

	public void setAstate(Long astate) {
		this.astate = astate;
	}

}