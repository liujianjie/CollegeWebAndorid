package com.ht.vo5;

/**
 * Computer entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Computer implements java.io.Serializable {

	// Fields

	private Long cid;
	private Long cstuid;
	private String cname;
	private String cremark;

	// Constructors

	/** default constructor */
	public Computer() {
	}

	/** full constructor */
	public Computer(Long cstuid, String cname, String cremark) {
		this.cstuid = cstuid;
		this.cname = cname;
		this.cremark = cremark;
	}

	// Property accessors

	public Long getCid() {
		return this.cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getCstuid() {
		return this.cstuid;
	}

	public void setCstuid(Long cstuid) {
		this.cstuid = cstuid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCremark() {
		return this.cremark;
	}

	public void setCremark(String cremark) {
		this.cremark = cremark;
	}

}