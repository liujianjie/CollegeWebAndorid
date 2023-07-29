package com.ht.vo2;

import java.util.Date;

import com.ht.vo2.Course;

/**
 * Courseplan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Courseplan implements java.io.Serializable {

	// Fields

	private Long cpid;
	private Long empid;
	private Long couid;
	private String cpcontents;
	private Date ctime;
	private Long classid;

	// Constructors

	/** default constructor */
	public Courseplan() {
	}

	/** full constructor */
	public Courseplan(Long empid, Long couid, String cpcontents,
			Date ctime,Long classid) {
		this.empid = empid;
		this.couid = couid;
		this.cpcontents = cpcontents;
		this.ctime = ctime;
		this.classid=classid;
	}

	// Property accessors

	public Long getCpid() {
		return this.cpid;
	}

	public void setCpid(Long cpid) {
		this.cpid = cpid;
	}

	public Long getEmpid() {
		return this.empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public Long getCouid() {
		return this.couid;
	}

	public void setCouid(Long couid) {
		this.couid = couid;
	}

	public String getCpcontents() {
		return this.cpcontents;
	}

	public void setCpcontents(String cpcontents) {
		this.cpcontents = cpcontents;
	}


	public Date getCtime() {
		return this.ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public Long getClassid() {
		return classid;
	}

	public void setClassid(Long classid) {
		this.classid = classid;
	}
	
}