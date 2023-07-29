package com.ht.yfbc.pojo;

/**
 * 拣货单列表(pickinglist)
 * day 2016-12-27
 * @author 刘建杰
 * 
 * */
public class PickingList {
	private String piid;
	private String outid;
	private String sku;
	private Integer saleqty;
	
	public PickingList() {
		// TODO �Զ���ɵĹ��캯����
	}

	public PickingList(String piid, String outid, String sku, Integer saleqty) {
		super();
		this.piid = piid;
		this.outid = outid;
		this.sku = sku;
		this.saleqty = saleqty;
	}
	
	public String getPiid() {
		return piid;
	}
	public void setPiid(String piid) {
		this.piid = piid;
	}
	public String getOutid() {
		return outid;
	}
	public void setOutid(String outid) {
		this.outid = outid;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Integer getSaleqty() {
		return saleqty;
	}
	public void setSaleqty(Integer saleqty) {
		this.saleqty = saleqty;
	}
}
