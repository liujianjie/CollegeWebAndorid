package com.ht.yfbc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 车辆报修对象
 * @author hjx
 *	<p>id:车辆报修表主键</p>
 * <p>userid:用户id</p>
 * <p>carsid:车辆id)</p>
 * <p>repairsdate:申报时间</p>
 * <p>repairsmoney:报修金额</p>
 * <p>repairsreason:报修原因</p>
 * <p>state:审核状态  0未提交  1审核中 2审核通过 3审核未通过</p>
 * <p>processinstanceid:流程实例Id</p>*/
public class Cars_repairs implements Serializable{

	private String id; 
	private String userid; 
	private String carsid; 
	private Date repairsdate;
	private Integer repairsmoney; 
	private String repairsreason; 
	private String state; 
	private String processinstanceid;
	
	public Cars_repairs(){
		
	}
	
	public Cars_repairs(String id, String userid, String carsid, Date repairsdate, Integer repairsmoney,
			String repairsreason, String state, String processinstanceid) {
		super();
		this.id = id;
		this.userid = userid;
		this.carsid = carsid;
		this.repairsdate = repairsdate;
		this.repairsmoney = repairsmoney;
		this.repairsreason = repairsreason;
		this.state = state;
		this.processinstanceid = processinstanceid;
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

	public Date getRepairsdate() {
		return repairsdate;
	}

	public void setRepairsdate(Date repairsdate) {
		this.repairsdate = repairsdate;
	}

	public Integer getRepairsmoney() {
		return repairsmoney;
	}

	public void setRepairsmoney(Integer repairsmoney) {
		this.repairsmoney = repairsmoney;
	}

	public String getRepairsreason() {
		return repairsreason;
	}

	public void setRepairsreason(String repairsreason) {
		this.repairsreason = repairsreason;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProcessinstanceid() {
		return processinstanceid;
	}

	public void setProcessinstanceid(String processinstanceid) {
		this.processinstanceid = processinstanceid;
	} 
	
	
	
	
}
