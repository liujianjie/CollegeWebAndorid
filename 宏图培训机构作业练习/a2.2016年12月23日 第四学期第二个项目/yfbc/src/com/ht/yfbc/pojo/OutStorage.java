package com.ht.yfbc.pojo;

import java.util.Date;

/**
 * 出货计划表(out_storage)
 * day 2016-12-27
 * @author 刘建杰
 * 
 * */
public class OutStorage{
	private String outid;
	private String productname;
	private String sku;
	private Integer purchaseqty;
	private String unit;
	private String supplier;
	private String supplierno;
	private String receivename;
	private String receiveno;
	private Date arrivaldate;
	private String whid;
	private String yueku;
	private String inno;
	private String statu;
	
	
	public OutStorage() {
		
	}


	


	public OutStorage(String outid, String productname, String sku, Integer purchaseqty, String unit, String supplier,
			String supplierno, String receivename, String receiveno, Date arrivaldate, String whid, String yueku,
			String inno, String statu) {
		super();
		this.outid = outid;
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
		this.yueku = yueku;
		this.inno = inno;
		this.statu = statu;
	}





	public String getYueku() {
		return yueku;
	}


	public void setYueku(String yueku) {
		this.yueku = yueku;
	}


	public String getOutid() {
		return outid;
	}


	public void setOutid(String outid) {
		this.outid = outid;
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
	
	
	
}
