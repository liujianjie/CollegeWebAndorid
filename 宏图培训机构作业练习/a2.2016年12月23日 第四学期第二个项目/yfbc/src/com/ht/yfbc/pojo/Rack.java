package com.ht.yfbc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 货架对象
 * day 2016-12-29
 * @author 魏海明
 *
 */
public class Rack implements Serializable{
	private String rid;
	private String rname;
	private String whid;
	private String rtype;
	private String unit;
	private Integer rsize;
	private Integer rsurplus;
	private String statu;
	private Date rdate;
	
	public Rack() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Rack(String rid,String rname, String whid, String rtype, String unit, Integer rsize,Integer rsurplus, String statu, Date rdate) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.whid = whid;
		this.rtype = rtype;
		this.unit = unit;
		this.rsize = rsize;
		this.rsurplus = rsurplus;
		this.statu = statu;
		this.rdate = rdate;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getWhid() {
		return whid;
	}
	public void setWhid(String whid) {
		this.whid = whid;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getRsize() {
		return rsize;
	}
	public void setRsize(Integer rsize) {
		this.rsize = rsize;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}


	public String getRname() {
		return rname;
	}


	public void setRname(String rname) {
		this.rname = rname;
	}


	public Integer getRsurplus() {
		return rsurplus;
	}


	public void setRsurplus(Integer rsurplus) {
		this.rsurplus = rsurplus;
	}
	
	
	
	
}
