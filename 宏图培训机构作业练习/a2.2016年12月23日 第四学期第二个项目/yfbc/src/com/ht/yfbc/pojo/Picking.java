package com.ht.yfbc.pojo;

/**
 * 拣货表(picking)
 * day 2016-12-27
 * @author 刘建杰
 * 
 * */
public class Picking {
	private String picid;
	private String piid;
	private Integer packageqty;
	private Integer pickqty;
	private Integer	damagedqty;
	private String	damagedreason;
	
	public Picking() {
		// TODO �Զ���ɵĹ��캯����
	}
	
	public Picking(String picid, String piid, Integer packageqty, Integer pickqty, Integer damagedqty,
			String damagedreason) {
		super();
		this.picid = picid;
		this.piid = piid;
		this.packageqty = packageqty;
		this.pickqty = pickqty;
		this.damagedqty = damagedqty;
		this.damagedreason = damagedreason;
	}
	public String getPicid() {
		return picid;
	}
	public void setPicid(String picid) {
		this.picid = picid;
	}
	public String getPiid() {
		return piid;
	}
	public void setPiid(String piid) {
		this.piid = piid;
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
	public Integer getDamagedqty() {
		return damagedqty;
	}
	public void setDamagedqty(Integer damagedqty) {
		this.damagedqty = damagedqty;
	}
	public String getDamagedreason() {
		return damagedreason;
	}
	public void setDamagedreason(String damagedreason) {
		this.damagedreason = damagedreason;
	}
}
