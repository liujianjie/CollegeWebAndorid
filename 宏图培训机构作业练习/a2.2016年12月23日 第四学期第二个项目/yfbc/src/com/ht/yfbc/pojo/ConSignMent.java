package com.ht.yfbc.pojo;

import java.util.Date;

/**
 * 发货表(consignment)
 * day 2016-12-27
 * @author 刘建杰
 * */
public class ConSignMent {
	private String conid;
	private	String dono;
	private Date pickdate;
	private	String	whid;
	private	String	pickid;
	private	String  skumodel;
	private Integer packageqty;
	private Integer pickqty;
	private	Integer	damagedpty;
	private	String damagedreason;
	private	Integer	totalweight;
	private Integer	totalvolume;
	
	public ConSignMent() {
		// TODO 自动生成的构造函数存根
	}
	public ConSignMent(String conid, String dono, Date pickdate, String whid, String pickid, String skumodel,
			Integer packageqty, Integer pickqty, Integer damagedpty, String damagedreason, Integer totalweight,
			Integer totalvolume) {
		super();
		this.conid = conid;
		this.dono = dono;
		this.pickdate = pickdate;
		this.whid = whid;
		this.pickid = pickid;
		this.skumodel = skumodel;
		this.packageqty = packageqty;
		this.pickqty = pickqty;
		this.damagedpty = damagedpty;
		this.damagedreason = damagedreason;
		this.totalweight = totalweight;
		this.totalvolume = totalvolume;
	}
	public String getConid() {
		return conid;
	}
	public void setConid(String conid) {
		this.conid = conid;
	}
	public String getDono() {
		return dono;
	}
	public void setDono(String dono) {
		this.dono = dono;
	}
	public Date getPickdate() {
		return pickdate;
	}
	public void setPickdate(Date pickdate) {
		this.pickdate = pickdate;
	}
	public String getWhid() {
		return whid;
	}
	public void setWhid(String whid) {
		this.whid = whid;
	}
	public String getPickid() {
		return pickid;
	}
	public void setPickid(String pickid) {
		this.pickid = pickid;
	}
	public String getSkumodel() {
		return skumodel;
	}
	public void setSkumodel(String skumodel) {
		this.skumodel = skumodel;
	}
	public Integer getPackageqty() {
		return packageqty;
	}
	public void setPackageqty(Integer packageqty) {
		this.packageqty = packageqty;
	}
	public Integer getPickqty() {
		return pickqty;
	}
	public void setPickqty(Integer pickqty) {
		this.pickqty = pickqty;
	}
	public Integer getDamagedpty() {
		return damagedpty;
	}
	public void setDamagedpty(Integer damagedpty) {
		this.damagedpty = damagedpty;
	}
	public String getDamagedreason() {
		return damagedreason;
	}
	public void setDamagedreason(String damagedreason) {
		this.damagedreason = damagedreason;
	}
	public Integer getTotalweight() {
		return totalweight;
	}
	public void setTotalweight(Integer totalweight) {
		this.totalweight = totalweight;
	}
	public Integer getTotalvolume() {
		return totalvolume;
	}
	public void setTotalvolume(Integer totalvolume) {
		this.totalvolume = totalvolume;
	}
}
