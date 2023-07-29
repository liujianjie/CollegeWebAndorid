package com.ht.yfbc.pojo;


/**
 * putaway摆货表(put_away)
 * day 2016-12-28
 * @author 刘建杰
 * ptid 	主键
 * inid		入库计划单id
 * reid		收货单id
 * whid		仓库id
 * sheid	货架id
 * 
 * ptbln	是否还存在货架中 0不存在，1存在
 * */
public class Putaway {
	private String ptid;
	private String inid;
	private String reid;
	private String sheid;
	private String whid;
	private Integer ptbln;
	
	public Putaway() {
		// TODO 自动生成的构造函数存根
	}
	
	public Putaway(String ptid, String inid, String reid, String sheid, String whid, Integer ptbln) {
		super();
		this.ptid = ptid;
		this.inid = inid;
		this.reid = reid;
		this.sheid = sheid;
		this.whid = whid;
		this.ptbln = ptbln;
	}


	public String getWhid() {
		return whid;
	}

	public void setWhid(String whid) {
		this.whid = whid;
	}

	public String getPtid() {
		return ptid;
	}
	public void setPtid(String ptid) {
		this.ptid = ptid;
	}
	public String getReid() {
		return reid;
	}
	public void setReid(String reid) {
		this.reid = reid;
	}
	public String getSheid() {
		return sheid;
	}
	public void setSheid(String sheid) {
		this.sheid = sheid;
	}
	public Integer getPtbln() {
		return ptbln;
	}
	public void setPtbln(Integer ptbln) {
		this.ptbln = ptbln;
	}
	public String getInid() {
		return inid;
	}
	public void setInid(String inid) {
		this.inid = inid;
	}
	
}
