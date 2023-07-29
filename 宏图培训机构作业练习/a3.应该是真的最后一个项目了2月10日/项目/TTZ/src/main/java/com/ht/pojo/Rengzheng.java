package com.ht.pojo;

import java.util.Date;

/**
 * Rengzheng entity. @author MyEclipse Persistence Tools
 */

public class Rengzheng implements java.io.Serializable {

	// Fields

	private String rid;
	private String userid;
	private String rtype;
	private String rimage;
	private Date rdate;
	private String ryes;
	private Integer xyed;
	

	// Constructors

	/** default constructor */
	public Rengzheng() {
	}

	/** minimal constructor */
	public Rengzheng(String rid) {
		this.rid = rid;
	}

	/** full constructor */
	public Rengzheng(String rid, String userid, String rtype, String rimage, Date rdate,String ryes,Integer xyed) {
		this.rid = rid;
		this.userid = userid;
		this.rtype = rtype;
		this.rimage = rimage;
		this.rdate = rdate;
		this.ryes = ryes;
		this.xyed = xyed;
	}

	// Property accessors
	

	public String getRid() {
		return this.rid;
	}

	public Integer getXyed() {
		return xyed;
	}

	public void setXyed(Integer xyed) {
		this.xyed = xyed;
	}

	public String getRyes() {
		return ryes;
	}

	public void setRyes(String ryes) {
		this.ryes = ryes;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRtype() {
		return this.rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	public String getRimage() {
		return this.rimage;
	}

	public void setRimage(String rimage) {
		this.rimage = rimage;
	}

	public Date getRdate() {
		return this.rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

}