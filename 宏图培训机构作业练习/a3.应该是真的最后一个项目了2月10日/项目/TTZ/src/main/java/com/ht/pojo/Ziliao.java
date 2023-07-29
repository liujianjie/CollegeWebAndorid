package com.ht.pojo;

/**
 * Ziliao entity. @author MyEclipse Persistence Tools
 */

public class Ziliao implements java.io.Serializable {

	// Fields

	private String zid;
	private String userid;
	private String sfz;
	private String gzz;
	private String srz;
	private String jzz;
	private String xyz;

	// Constructors

	/** default constructor */
	public Ziliao() {
	}

	/** minimal constructor */
	public Ziliao(String zid) {
		this.zid = zid;
	}

	/** full constructor */
	public Ziliao(String zid, String userid, String sfz, String gzz, String srz, String jzz, String xyz) {
		this.zid = zid;
		this.userid = userid;
		this.sfz = sfz;
		this.gzz = gzz;
		this.srz = srz;
		this.jzz = jzz;
		this.xyz = xyz;
	}

	// Property accessors

	public String getZid() {
		return this.zid;
	}

	public void setZid(String zid) {
		this.zid = zid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSfz() {
		return this.sfz;
	}

	public void setSfz(String sfz) {
		this.sfz = sfz;
	}

	public String getGzz() {
		return this.gzz;
	}

	public void setGzz(String gzz) {
		this.gzz = gzz;
	}

	public String getSrz() {
		return this.srz;
	}

	public void setSrz(String srz) {
		this.srz = srz;
	}

	public String getJzz() {
		return this.jzz;
	}

	public void setJzz(String jzz) {
		this.jzz = jzz;
	}

	public String getXyz() {
		return this.xyz;
	}

	public void setXyz(String xyz) {
		this.xyz = xyz;
	}

}