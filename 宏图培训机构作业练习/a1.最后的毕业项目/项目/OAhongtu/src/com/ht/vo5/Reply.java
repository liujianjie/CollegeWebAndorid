package com.ht.vo5;

/**
 * Reply entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Reply implements java.io.Serializable {

	// Fields

	private Long rid;
	private Long sbackid;
	private Long reid;
	private String rcon;

	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** full constructor */
	public Reply(Long sbackid, Long reid, String rcon) {
		this.sbackid = sbackid;
		this.reid = reid;
		this.rcon = rcon;
	}

	// Property accessors

	public Long getRid() {
		return this.rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Long getSbackid() {
		return this.sbackid;
	}

	public void setSbackid(Long sbackid) {
		this.sbackid = sbackid;
	}

	public Long getReid() {
		return this.reid;
	}

	public void setReid(Long reid) {
		this.reid = reid;
	}

	public String getRcon() {
		return this.rcon;
	}

	public void setRcon(String rcon) {
		this.rcon = rcon;
	}

}