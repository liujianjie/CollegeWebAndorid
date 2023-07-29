package com.ht.yfbc.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/** 车辆出勤表对象 
 * <p>id:车辆出勤记录表主键</p>
 * <p>userid:配送员编号</p>
 * <p>carsid:车辆编号</p>
 * <p>carsstartdate:发车时间</p>
 * <p>carsarrivedate:(预计)抵达时间</p>
 * <p>carsbywhouse:所属分公司(仓库)编号</p>
 * */
public class Cars_attendance implements Serializable{

	private String id;
	private String userid;
	private String carsid;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date carsstartdate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date carsarrivedate;
	private String warehouseid;
	private String inno;
	public Cars_attendance(){
		
	}
	public Cars_attendance(String id, String userid, String carsid, Date carsstartdate, Date carsarrivedate,
			String warehouseid,String inno) {
		super();
		this.id = id;
		this.userid = userid;
		this.carsid = carsid;
		this.carsstartdate = carsstartdate;
		this.carsarrivedate = carsarrivedate;
		this.warehouseid = warehouseid;
		this.inno = inno;
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
	public Date getCarsstartdate() {
		return carsstartdate;
	}
	public void setCarsstartdate(Date carsstartdate) {
		this.carsstartdate = carsstartdate;
	}
	public Date getCarsarrivedate() {
		return carsarrivedate;
	}
	public void setCarsarrivedate(Date carsarrivedate) {
		this.carsarrivedate = carsarrivedate;
	}
	public String getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid;
	}
	public String getInno() {
		return inno;
	}
	public void setInno(String inno) {
		this.inno = inno;
	}
	
	

}
