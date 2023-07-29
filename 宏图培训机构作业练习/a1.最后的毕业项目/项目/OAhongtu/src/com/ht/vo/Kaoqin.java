package com.ht.vo;

import java.util.Date;

/**
 * Kaoqin entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Kaoqin implements java.io.Serializable {

	// Fields

	private Long kid;
	private String ename;
	private Date kdate;
	private String kresion;
	private Long ksid;
	private Long kstatu;
	
	// Constructors

	/** default constructor */
	public Kaoqin() {
		
	}

	

	public Long getKid() {
		return this.kid;
	}

	public void setKid(Long kid) {
		this.kid = kid;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Date getKdate() {
		return this.kdate;
	}

	public void setKdate(Date kdate) {
		this.kdate = kdate;
	}

	public String getKresion() {
		return this.kresion;
	}

	public void setKresion(String kresion) {
		this.kresion = kresion;
	}

	public Long getKsid() {
		return this.ksid;
	}

	public void setKsid(Long ksid) {
		this.ksid = ksid;
	}

	public Long getKstatu() {
		return kstatu;
	}

	public void setKstatu(Long kstatu) {
		this.kstatu = kstatu;
	}

}