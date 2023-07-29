package com.ht.pojo;

/**
 * People entity. @author MyEclipse Persistence Tools
 */

public class People implements java.io.Serializable {

	// Fields

	private String pid;
	private String pname;
	private String psex;
	private String ptel;
	private String pcard;
	private String paddress;

	// Constructors

	/** default constructor */
	public People() {
	}

	/** minimal constructor */
	public People(String pid) {
		this.pid = pid;
	}

	/** full constructor */
	public People(String pid, String pname, String psex, String ptel, String pcard, String paddress) {
		this.pid = pid;
		this.pname = pname;
		this.psex = psex;
		this.ptel = ptel;
		this.pcard = pcard;
		this.paddress = paddress;
	}

	// Property accessors

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPsex() {
		return this.psex;
	}

	public void setPsex(String psex) {
		this.psex = psex;
	}

	public String getPtel() {
		return this.ptel;
	}

	public void setPtel(String ptel) {
		this.ptel = ptel;
	}

	public String getPcard() {
		return this.pcard;
	}

	public void setPcard(String pcard) {
		this.pcard = pcard;
	}

	public String getPaddress() {
		return this.paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

}