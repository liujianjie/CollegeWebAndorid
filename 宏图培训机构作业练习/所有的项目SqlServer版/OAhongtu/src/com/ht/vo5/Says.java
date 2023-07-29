package com.ht.vo5;

import java.util.Date;

/**
 * Says entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Says implements java.io.Serializable {

	// Fields

	private Long sayid;
	private Long sayface;
	private Long sayempid;
	private String sayscon;
	private String sayspro;
	private String sayback;
	private String saydate;

	// Constructors

	/** default constructor */
	public Says() {
	}

	/** minimal constructor */
	public Says(Long sayface, Long sayempid, String sayscon, String sayspro) {
		this.sayface = sayface;
		this.sayempid = sayempid;
		this.sayscon = sayscon;
		this.sayspro = sayspro;
	}

	/** full constructor */
	public Says(Long sayface, Long sayempid, String sayscon, String sayspro,
			String sayback, String saydate) {
		this.sayface = sayface;
		this.sayempid = sayempid;
		this.sayscon = sayscon;
		this.sayspro = sayspro;
		this.sayback = sayback;
		this.saydate = saydate;
	}

	// Property accessors

	public Long getSayid() {
		return this.sayid;
	}

	public void setSayid(Long sayid) {
		this.sayid = sayid;
	}

	public Long getSayface() {
		return this.sayface;
	}

	public void setSayface(Long sayface) {
		this.sayface = sayface;
	}

	public Long getSayempid() {
		return this.sayempid;
	}

	public void setSayempid(Long sayempid) {
		this.sayempid = sayempid;
	}

	public String getSayscon() {
		return this.sayscon;
	}

	public void setSayscon(String sayscon) {
		this.sayscon = sayscon;
	}

	public String getSayspro() {
		return this.sayspro;
	}

	public void setSayspro(String sayspro) {
		this.sayspro = sayspro;
	}

	public String getSayback() {
		return this.sayback;
	}

	public void setSayback(String sayback) {
		this.sayback = sayback;
	}

	public String getSaydate() {
		return this.saydate;
	}

	public void setSaydate(String saydate) {
		this.saydate = saydate;
	}

}