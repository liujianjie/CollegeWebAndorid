package com.ht.yfbc.pojo;
/**
 * stage区表(stage)
 * day 2016-12-28
 * @author 刘建杰
 * staid	主键
 * reid		收货id
 * SKUmodel 货物模型
 * packageqty	外包装数量
 * receiveqty	货物基本单位数量
 * stgstate	是否越库 0:未越库，1为越库
 * 业务：越库 如果为0则是普通收货要摆货
--          如果为1则是越库收货要拣货出库，不用摆货
 * */
public class Stage {
	private String stgid;
	private String reid;
	private String SKUmodel;
	private Integer packageqty;
	private Integer receiveqty;
	private Integer stgstate;
	
	public Stage() {
		// TODO 自动生成的构造函数存根
	}
	public Stage(String stgid, String reid, String sKUmodel, Integer packageqty, Integer receiveqty, Integer stgstate) {
		super();
		this.stgid = stgid;
		this.reid = reid;
		SKUmodel = sKUmodel;
		this.packageqty = packageqty;
		this.receiveqty = receiveqty;
		this.stgstate = stgstate;
	}
	public String getStgid() {
		return stgid;
	}
	public void setStgid(String stgid) {
		this.stgid = stgid;
	}
	public String getReid() {
		return reid;
	}
	public void setReid(String reid) {
		this.reid = reid;
	}
	public String getSKUmodel() {
		return SKUmodel;
	}
	public void setSKUmodel(String sKUmodel) {
		SKUmodel = sKUmodel;
	}
	public Integer getPackageqty() {
		return packageqty;
	}
	public void setPackageqty(Integer packageqty) {
		this.packageqty = packageqty;
	}
	public Integer getReceiveqty() {
		return receiveqty;
	}
	public void setReceiveqty(Integer receiveqty) {
		this.receiveqty = receiveqty;
	}
	public Integer getStgstate() {
		return stgstate;
	}
	public void setStgstate(Integer stgstate) {
		this.stgstate = stgstate;
	}
	
}
