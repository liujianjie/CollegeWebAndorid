package com.ht.vo;

import java.util.Date;

/**
 * Xuncha entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Xuncha implements java.io.Serializable {

	// Fields

	private Long xid;
	private String xname;
	private Date xdate;
	private String xtime;
	private String xclass;
	private Long xcount;
	private Long xnumber;
	private String xclean;
	private String xteach;
	private String isteach;
	private String xstudent;
	private String xdoteach;

	// Constructors

	/** default constructor */
	public Xuncha() {
	}

	/** full constructor */
	public Xuncha(String xname, Date xdate, String xtime, String xclass,
			Long xcount, Long xnumber, String xclean, String xteach,
			String isteach, String xstudent, String xdoteach) {
		this.xname = xname;
		this.xdate = xdate;
		this.xtime = xtime;
		this.xclass = xclass;
		this.xcount = xcount;
		this.xnumber = xnumber;
		this.xclean = xclean;
		this.xteach = xteach;
		this.isteach = isteach;
		this.xstudent = xstudent;
		this.xdoteach = xdoteach;
	}

	// Property accessors

	public Long getXid() {
		return this.xid;
	}

	public void setXid(Long xid) {
		this.xid = xid;
	}

	public String getXname() {
		return this.xname;
	}

	public void setXname(String xname) {
		this.xname = xname;
	}

	public Date getXdate() {
		return this.xdate;
	}

	public void setXdate(Date xdate) {
		this.xdate = xdate;
	}

	public String getXtime() {
		return this.xtime;
	}

	public void setXtime(String xtime) {
		this.xtime = xtime;
	}

	public String getXclass() {
		return this.xclass;
	}

	public void setXclass(String xclass) {
		this.xclass = xclass;
	}

	public Long getXcount() {
		return this.xcount;
	}

	public void setXcount(Long xcount) {
		this.xcount = xcount;
	}

	public Long getXnumber() {
		return this.xnumber;
	}

	public void setXnumber(Long xnumber) {
		this.xnumber = xnumber;
	}

	public String getXclean() {
		return this.xclean;
	}

	public void setXclean(String xclean) {
		this.xclean = xclean;
	}

	public String getXteach() {
		return this.xteach;
	}

	public void setXteach(String xteach) {
		this.xteach = xteach;
	}

	public String getIsteach() {
		return this.isteach;
	}

	public void setIsteach(String isteach) {
		this.isteach = isteach;
	}

	public String getXstudent() {
		return this.xstudent;
	}

	public void setXstudent(String xstudent) {
		this.xstudent = xstudent;
	}

	public String getXdoteach() {
		return this.xdoteach;
	}

	public void setXdoteach(String xdoteach) {
		this.xdoteach = xdoteach;
	}

}