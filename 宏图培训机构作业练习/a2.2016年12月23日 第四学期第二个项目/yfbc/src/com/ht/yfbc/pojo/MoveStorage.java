package com.ht.yfbc.pojo;

/**
 * 移库单实体MoveStorage
 * @author 刘建杰
 *	
 */
public class MoveStorage {
	private String moid;
	private String mouser;
	private String mowhiname;
	private String ptid;
	private String touser;
	private String towhiname;
	private Integer mostate;
	private String carsid;
	private String processInstanceId;
	private	putaway3 ptay3;
	
	public MoveStorage() {
		// TODO 自动生成的构造函数存根
	}
	public MoveStorage(String moid, String mouser, String mowhiname, String ptid, String touser, String towhiname,
			Integer mostate, String carsid, String processInstanceId, putaway3 ptay3) {
		super();
		this.moid = moid;
		this.mouser = mouser;
		this.mowhiname = mowhiname;
		this.ptid = ptid;
		this.touser = touser;
		this.towhiname = towhiname;
		this.mostate = mostate;
		this.carsid = carsid;
		this.processInstanceId = processInstanceId;
		this.ptay3 = ptay3;
	}



	public putaway3 getPtay3() {
		return ptay3;
	}

	public void setPtay3(putaway3 ptay3) {
		this.ptay3 = ptay3;
	}



	public String getCarsid() {
		return carsid;
	}

	public void setCarsid(String carsid) {
		this.carsid = carsid;
	}

	public String getMoid() {
		return moid;
	}
	public void setMoid(String moid) {
		this.moid = moid;
	}
	public String getMouser() {
		return mouser;
	}
	public void setMouser(String mouser) {
		this.mouser = mouser;
	}
	public String getMowhiname() {
		return mowhiname;
	}
	public void setMowhiname(String mowhiname) {
		this.mowhiname = mowhiname;
	}
	public String getPtid() {
		return ptid;
	}
	public void setPtid(String ptid) {
		this.ptid = ptid;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTowhiname() {
		return towhiname;
	}
	public void setTowhiname(String towhiname) {
		this.towhiname = towhiname;
	}
	public Integer getMostate() {
		return mostate;
	}
	public void setMostate(Integer mostate) {
		this.mostate = mostate;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
}
