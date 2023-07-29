package com.ht.vo3;

/**
 * Applystudent entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Applystudent implements java.io.Serializable {

	// Fields

	private Long intenid;
	private String intenname;
	private String intensch;
	private String intensex;
	private String intenbir;
	private String intenfat;
	private String intenfatel;
	private String intenaddr;
	private String intenstatus;
	private String intplace;
	private String intemail;

	// Constructors

	/** default constructor */
	public Applystudent() {
	}

	/** minimal constructor */
	public Applystudent(Long intenid) {
		this.intenid = intenid;
	}

	/** full constructor */
	public Applystudent(Long intenid, String intenname, String intensch,
			String intensex, String intenbir, String intenfat,
			String intenfatel, String intenaddr, String intenstatus,
			String intplace, String intemail) {
		this.intenid = intenid;
		this.intenname = intenname;
		this.intensch = intensch;
		this.intensex = intensex;
		this.intenbir = intenbir;
		this.intenfat = intenfat;
		this.intenfatel = intenfatel;
		this.intenaddr = intenaddr;
		this.intenstatus = intenstatus;
		this.intplace = intplace;
		this.intemail = intemail;
	}

	// Property accessors

	public Long getIntenid() {
		return this.intenid;
	}

	public void setIntenid(Long intenid) {
		this.intenid = intenid;
	}

	public String getIntenname() {
		return this.intenname;
	}

	public void setIntenname(String intenname) {
		this.intenname = intenname;
	}

	public String getIntensch() {
		return this.intensch;
	}

	public void setIntensch(String intensch) {
		this.intensch = intensch;
	}

	public String getIntensex() {
		return this.intensex;
	}

	public void setIntensex(String intensex) {
		this.intensex = intensex;
	}

	public String getIntenbir() {
		return this.intenbir;
	}

	public void setIntenbir(String intenbir) {
		this.intenbir = intenbir;
	}

	public String getIntenfat() {
		return this.intenfat;
	}

	public void setIntenfat(String intenfat) {
		this.intenfat = intenfat;
	}

	public String getIntenfatel() {
		return this.intenfatel;
	}

	public void setIntenfatel(String intenfatel) {
		this.intenfatel = intenfatel;
	}

	public String getIntenaddr() {
		return this.intenaddr;
	}

	public void setIntenaddr(String intenaddr) {
		this.intenaddr = intenaddr;
	}

	public String getIntenstatus() {
		return this.intenstatus;
	}

	public void setIntenstatus(String intenstatus) {
		this.intenstatus = intenstatus;
	}

	public String getIntplace() {
		return this.intplace;
	}

	public void setIntplace(String intplace) {
		this.intplace = intplace;
	}

	public String getIntemail() {
		return this.intemail;
	}

	public void setIntemail(String intemail) {
		this.intemail = intemail;
	}

}