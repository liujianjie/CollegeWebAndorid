package com.ht.yfbc.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 收货表(receiving)
 * day 2016-12-29
 * @author 刘建杰
 * */
public class Receiving {
	private String reid;
	private String inid;//算作入库主键吧
	private Date receivedate;
	private String whid;
	private String productname;
	private String sku;
	private Integer purchaseqty;
	private Integer unit;
	private Integer shortqty;
	private Integer partflag;
	private Integer putstate;//是否摆货了
	
	public Receiving() {
		// TODO 自动生成的构造函数存根
	}
	
	public Receiving(String reid, String inid, Date receivedate, String whid, String productname, String sku,
			Integer purchaseqty, Integer unit, Integer shortqty, Integer partflag, Integer putstate) {
		super();
		this.reid = reid;
		this.inid = inid;
		this.receivedate = receivedate;
		this.whid = whid;
		this.productname = productname;
		this.sku = sku;
		this.purchaseqty = purchaseqty;
		this.unit = unit;
		this.shortqty = shortqty;
		this.partflag = partflag;
		this.putstate = putstate;
	}


	public Integer getPutstate() {
		return putstate;
	}
	public void setPutstate(Integer putstate) {
		this.putstate = putstate;
	}


	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getReid() {
		return reid;
	}
	public void setReid(String reid) {
		this.reid = reid;
	}
	public String getInid() {
		return inid;
	}
	public void setInid(String inid) {
		this.inid = inid;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GTM+8")
	public Date getReceivedate() {
		return receivedate;
	}
	public void setReceivedate(Date receivedate) {
		this.receivedate = receivedate;
	}
	public String getWhid() {
		return whid;
	}
	public void setWhid(String whid) {
		this.whid = whid;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Integer getPurchaseqty() {
		return purchaseqty;
	}
	public void setPurchaseqty(Integer purchaseqty) {
		this.purchaseqty = purchaseqty;
	}
	public Integer getUnit() {
		return unit;
	}
	public void setUnit(Integer unit) {
		this.unit = unit;
	}
	public Integer getShortqty() {
		return shortqty;
	}
	public void setShortqty(Integer shortqty) {
		this.shortqty = shortqty;
	}
	public Integer getPartflag() {
		return partflag;
	}
	public void setPartflag(Integer partflag) {
		this.partflag = partflag;
	}
}
