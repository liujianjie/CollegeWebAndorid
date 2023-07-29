package com.ht.vo5;

import java.util.Date;

/**
 * Projectf entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Projectf implements java.io.Serializable {

	// Fields

	private Long pid;
	private Long pname;
	private Long pteacher;
	private Long pteachers;
	private Date pdate;
	private Long pclassid;

	// Constructors

	/** default constructor */
	public Projectf() {
	}

	/** minimal constructor */
	public Projectf(Long pteacher, Long pteachers, Date pdate) {
		this.pteacher = pteacher;
		this.pteachers = pteachers;
		this.pdate = pdate;
	}

	/** full constructor */
	public Projectf(Long pname, Long pteacher, Long pteachers, Date pdate,
			Long pclassid) {
		this.pname = pname;
		this.pteacher = pteacher;
		this.pteachers = pteachers;
		this.pdate = pdate;
		this.pclassid = pclassid;
	}

	// Property accessors

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getPname() {
		return this.pname;
	}

	public void setPname(Long pname) {
		this.pname = pname;
	}

	public Long getPteacher() {
		return this.pteacher;
	}

	public void setPteacher(Long pteacher) {
		this.pteacher = pteacher;
	}

	public Long getPteachers() {
		return this.pteachers;
	}

	public void setPteachers(Long pteachers) {
		this.pteachers = pteachers;
	}

	public Date getPdate() {
		return this.pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public Long getPclassid() {
		return this.pclassid;
	}

	public void setPclassid(Long pclassid) {
		this.pclassid = pclassid;
	}

}