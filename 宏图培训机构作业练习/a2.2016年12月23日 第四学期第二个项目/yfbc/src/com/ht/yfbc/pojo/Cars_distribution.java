package com.ht.yfbc.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**车辆fenpei表对象
 * <p>id:车辆分配表主键
 * <p>carsid:车辆ID
 * <p>userid:车辆配送司机id
 * <p>warehouseid:车辆所属仓库id
 * <p>distributiondate:分配时间*/
public class Cars_distribution implements Serializable{

	private String id;
	private String carsid;
	private String userid;
	private String warehouseid;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date distributiondate;
	
	public Cars_distribution(){
		
	}
	public Cars_distribution(String id, String carsid, String userid, String warehouseid,Date distributiondate) {
		super();
		this.id = id;
		this.carsid = carsid;
		this.userid = userid;
		this.warehouseid = warehouseid;
		this.distributiondate=distributiondate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCarsid() {
		return carsid;
	}
	public void setCarsid(String carsid) {
		this.carsid = carsid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid;
	}
	public Date getDistributiondate() {
		return distributiondate;
	}
	public void setDistributiondate(Date distributiondate) {
		this.distributiondate = distributiondate;
	}
	@Override
	public String toString() {
		return "Cars_distribution [id=" + id + ", carsid=" + carsid + ", userid=" + userid + ", warehouseid="
				+ warehouseid + ", distributiondate=" + distributiondate + "]";
	}
	
	
}
