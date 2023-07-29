package com.ht.yfbc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 出库单表（delivery）
 * day 2017-1-05
 * @author 魏海明
 *
 */
@SuppressWarnings("serial")
public class Delivery implements Serializable{
	private String deid;
	private String productname;
	private String sku;
	private Integer purchaseqty;
	private String unit;
	private String supplier;
	private String supplierno;
	private String receivename;
	private String receiveno;
	private String whid;
	private String inno;
	private String statu;
	private Float univalent;
	private Float price;
	public Delivery(String deid, String productname, String sku, Integer purchaseqty, String unit, String supplier,
			String supplierno, String receivename, String receiveno, String whid, String inno, String statu,
			Float univalent, Float price) {
		super();
		this.deid = deid;
		this.productname = productname;
		this.sku = sku;
		this.purchaseqty = purchaseqty;
		this.unit = unit;
		this.supplier = supplier;
		this.supplierno = supplierno;
		this.receivename = receivename;
		this.receiveno = receiveno;
		this.whid = whid;
		this.inno = inno;
		this.statu = statu;
		this.univalent = univalent;
		this.price = price;
	}
	
	public Delivery() {
		// TODO Auto-generated constructor stub
	}

	public String getDeid() {
		return deid;
	}

	public void setDeid(String deid) {
		this.deid = deid;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
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

	public String getWhid() {
		return whid;
	}

	public void setWhid(String whid) {
		this.whid = whid;
	}

	public String getInno() {
		return inno;
	}

	public void setInno(String inno) {
		this.inno = inno;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	public Float getUnivalent() {
		return univalent;
	}

	public void setUnivalent(Float univalent) {
		this.univalent = univalent;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	
}
