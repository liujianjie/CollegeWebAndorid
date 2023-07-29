package com.ht.vo;

/**
 * Photos entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Photos implements java.io.Serializable {

	// Fields

	private Long pid;
	private String pname;
	private String psrc;

	// Constructors

	/** default constructor */
	public Photos() {
	}

	/** minimal constructor */
	public Photos(Long pid) {
		this.pid = pid;
	}

	/** full constructor */
	public Photos(Long pid, String pname, String psrc) {
		this.pid = pid;
		this.pname = pname;
		this.psrc = psrc;
	}

	// Property accessors

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPsrc() {
		return this.psrc;
	}

	public void setPsrc(String psrc) {
		this.psrc = psrc;
	}

}