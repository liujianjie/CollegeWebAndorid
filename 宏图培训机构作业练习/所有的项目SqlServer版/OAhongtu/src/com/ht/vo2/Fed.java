package com.ht.vo2;

import java.util.Date;

/**
 * Fed entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Fed implements java.io.Serializable {

	// Fields

	private Long fedid;
	private Long fedtime;
	private Long empid;
	private Date fedendtime;
	private Long fedstate;
	private Long num;
	private Long fedmonth;
	private Long classid;
	// Constructors

	/** default constructor */
	public Fed() {
	}

	/** full constructor */
	public Fed(Long fedtime, Long empid, Date fedendtime, Long fedstate,Long num,Long fedmonth,Long classid) {
		this.fedtime = fedtime;
		this.empid = empid;
		this.fedendtime = fedendtime;
		this.fedstate = fedstate;
		this.num = num;
		this.fedmonth = fedmonth;
		this.classid=classid;
	}

	// Property accessors

	public Long getFedid() {
		return this.fedid;
	}

	public void setFedid(Long fedid) {
		this.fedid = fedid;
	}

	

	public Long getEmpid() {
		return this.empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public Date getFedendtime() {
		return this.fedendtime;
	}

	public void setFedendtime(Date fedendtime) {
		this.fedendtime = fedendtime;
	}

	public Long getFedstate() {
		return this.fedstate;
	}

	public void setFedstate(Long fedstate) {
		this.fedstate = fedstate;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getFedtime() {
		return fedtime;
	}

	public void setFedtime(Long fedtime) {
		this.fedtime = fedtime;
	}

	public Long getFedmonth() {
		return fedmonth;
	}

	public void setFedmonth(Long fedmonth) {
		this.fedmonth = fedmonth;
	}

	public Long getClassid() {
		return classid;
	}

	public void setClassid(Long classid) {
		this.classid = classid;
	}


}