package com.ht.yfbc.pojo;

import java.io.Serializable;
/**
 * 仓库数据对象 Warehouse
 * day 2016-12-27
 * @author 魏海明
 *
 */

@SuppressWarnings("serial")
public class Warehouse implements Serializable {
	
	private String whid;
	private String whiname;
	private String userid;
	private Integer whvolume;
	private Integer cityid;
	private Integer whistate;
	
	public Warehouse() {
		// TODO Auto-generated constructor stub
	}

	public Warehouse(String whid, String whiname, String userid, Integer whvolume, Integer cityid, Integer whistate) {
		super();
		this.whid = whid;
		this.whiname = whiname;
		this.userid = userid;
		this.whvolume = whvolume;
		this.cityid = cityid;
		this.whistate = whistate;
	}

	public String getWhid() {
		return whid;
	}

	public void setWhid(String whid) {
		this.whid = whid;
	}

	public String getWhiname() {
		return whiname;
	}

	public void setWhiname(String whiname) {
		this.whiname = whiname;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getWhvolume() {
		return whvolume;
	}

	public void setWhvolume(Integer whvolume) {
		this.whvolume = whvolume;
	}

	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	public Integer getWhistate() {
		return whistate;
	}

	public void setWhistate(Integer whistate) {
		this.whistate = whistate;
	}
	
	
}
