package com.ht.yfbc.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author hjx
 * 车辆变更表对象 
 * <p>id车辆变更记录表主键</p>
 * <p>userid 司机编号</p>
 * <p>carsid 车辆编号</p>
 * <p>changedata 分配时间</p>
 * */
public class Cars_change {

	private String id;
	private String warehouseid;
	private String userid;
	private String carsid;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date changedate;
	
	public Cars_change(){
		
	}
	public Cars_change(String id, String userid, String carsid, Date changedate, String warehouseid) {
		super();
		this.id = id;
		this.userid = userid;
		this.carsid = carsid;
		this.changedate = changedate;
		this.warehouseid = warehouseid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCarsid() {
		return carsid;
	}
	public void setCarsid(String carsid) {
		this.carsid = carsid;
	}
	public Date getChangedate() {
		return changedate;
	}
	public void setChangedate(Date changedate) {
		this.changedate = changedate;
	}
	public String getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid;
	}
	@Override
	public String toString() {
		return "Cars_change [id=" + id + ", warehouseid=" + warehouseid + ", userid=" + userid + ", carsid=" + carsid
				+ ", changedate=" + changedate + "]";
	}
	
	
}
