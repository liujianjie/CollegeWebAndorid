package com.ht.vo2;

import java.util.Date;

/**
 * Dutys entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Dutys implements java.io.Serializable {

	// Fields

	private Long dsid;
	private Date dstime;
	private String dsplace;
	private Long dsempid;
	private String dspro;

	// Constructors

	/** default constructor */
	public Dutys() {
	}

	/** full constructor */
	public Dutys(Date dstime, String dsplace, Long dsempid, String dspro) {
		this.dstime = dstime;
		this.dsplace = dsplace;
		this.dsempid = dsempid;
		this.dspro = dspro;
	}

	// Property accessors

	public Long getDsid() {
		return this.dsid;
	}

	public void setDsid(Long dsid) {
		this.dsid = dsid;
	}

	public Date getDstime() {
		return this.dstime;
	}

	public void setDstime(Date dstime) {
		this.dstime = dstime;
	}

	public String getDsplace() {
		return this.dsplace;
	}

	public void setDsplace(String dsplace) {
		this.dsplace = dsplace;
	}

	public Long getDsempid() {
		return this.dsempid;
	}

	public void setDsempid(Long dsempid) {
		this.dsempid = dsempid;
	}

	public String getDspro() {
		return this.dspro;
	}

	public void setDspro(String dspro) {
		this.dspro = dspro;
	}

}