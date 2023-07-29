package com.ht.vo;

import java.util.Date;

/**
 * Dept entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Dept implements java.io.Serializable {

	// Fields

	private Long did;
	private String dname;
	private Long status;
	private Date createtime;
	private Long deptman;
	private Long king;

	// Constructors

	/** default constructor */
	public Dept() {
	}

	/** full constructor */
	public Dept(String dname, Long status, Date createtime, Long deptman,
			Long king) {
		this.dname = dname;
		this.status = status;
		this.createtime = createtime;
		this.deptman = deptman;
		this.king = king;
	}

	// Property accessors

	public Long getDid() {
		return this.did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Long getDeptman() {
		return this.deptman;
	}

	public void setDeptman(Long deptman) {
		this.deptman = deptman;
	}

	public Long getKing() {
		return this.king;
	}

	public void setKing(Long king) {
		this.king = king;
	}

}