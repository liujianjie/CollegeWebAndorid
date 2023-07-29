package com.ht.yfbc.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * instorage入库计划单表(in_storage)
 * day 2016-12-28
 * @author 刘建杰
 * */
public class InStorage {
	private String inid;
	private String productname;
	private String sku;
	private Integer purchaseqty;
	private Integer unit;
	private String supplier;
	private String supplierno;
	private String receivename;
	private String receiveno;
	private Date arrivaldate;
	private String whid;
	private String inno;
	private Integer instate;
	
	public InStorage() {
		// TODO 自动生成的构造函数存根
	}

	public InStorage(String inid, String productname, String sku, Integer purchaseqty, Integer unit, String supplier,
			String supplierno, String receivename, String receiveno, Date arrivaldate, String whid, String inno,
			Integer instate) {
		super();
		this.inid = inid;
		this.productname = productname;
		this.sku = sku;
		this.purchaseqty = purchaseqty;
		this.unit = unit;
		this.supplier = supplier;
		this.supplierno = supplierno;
		this.receivename = receivename;
		this.receiveno = receiveno;
		this.arrivaldate = arrivaldate;
		this.whid = whid;
		this.inno = inno;
		this.instate = instate;
	}


	public String getInid() {
		return inid;
	}
	public void setInid(String inid) {
		this.inid = inid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
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
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getSupplierno() {
		return supplierno;
	}
	public void setSupplierno(String supplierno) {
		this.supplierno = supplierno;
	}
	public String getReceivename() {
		return receivename;
	}
	public void setReceivename(String receivename) {
		this.receivename = receivename;
	}
	public String getReceiveno() {
		return receiveno;
	}
	public void setReceiveno(String receiveno) {
		this.receiveno = receiveno;
	}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GTM+8")
	public Date getArrivaldate() {
		return arrivaldate;
	}
	public void setArrivaldate(Date arrivaldate) {
		this.arrivaldate = arrivaldate;
	}
	public String getWhid() {
		return whid;
	}
	public void setWhid(String whid) {
		this.whid = whid;
	}

	public Integer getInstate() {
		return instate;
	}

	public void setInstate(Integer instate) {
		this.instate = instate;
	}

	public String getInno() {
		return inno;
	}

	public void setInno(String inno) {
		this.inno = inno;
	}
	
}
