package com.ht.vo2;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Discuss entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Discuss implements java.io.Serializable {

	// Fields

	private Long disid;
	private String disname;
	private Date distime;
	private String empid;
	private String dispro;
	private String diskey;
	private Long discompere;
	private Long diswriter;
	private String displace;

	// Constructors
	
	/** default constructor */
	public Discuss() {
	}

	/** full constructor */
	public Discuss(String disname, Date distime, String empid, String dispro,
			String diskey,Long discompere,Long diswriter,String displace) {
		this.disname = disname;
		this.distime = distime;
		this.empid = empid;
		this.dispro = dispro;
		this.diskey = diskey;
		this.discompere = discompere;
		this.diswriter = diswriter;
		this.displace = displace;
	}

	// Property accessors

	public Long getDisid() {
		return this.disid;
	}

	public void setDisid(Long disid) {
		this.disid = disid;
	}

	public String getDisname() {
		return this.disname;
	}

	public void setDisname(String disname) {
		this.disname = disname;
	}

	public Date getDistime() {
		return this.distime;
	}

	public void setDistime(Date distime) {
		this.distime = distime;
	}

	public String getEmpid() {
		return this.empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getDispro() {
		return this.dispro;
	}

	public void setDispro(String dispro) {
		this.dispro = dispro;
	}

	public String getDiskey() {
		return this.diskey;
	}

	public void setDiskey(String diskey) {
		this.diskey = diskey;
	}

	public Long getDiscompere() {
		return discompere;
	}

	public void setDiscompere(Long discompere) {
		this.discompere = discompere;
	}

	public Long getDiswriter() {
		return diswriter;
	}

	public void setDiswriter(Long diswriter) {
		this.diswriter = diswriter;
	}

	public String getDisplace() {
		return displace;
	}

	public void setDisplace(String displace) {
		this.displace = displace;
	}


}