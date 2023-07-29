package com.ht.vo4;

import java.util.Date;



/**
 * Zhichu entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Zhichu {

	private Integer zhichu_id;
	private Integer zhichu_xiangmu;
	private float zhichu_jine;
	private String jingshouren;
	private String beizhu;
	private Date zhichu_time;
	private Integer z_year;
	private Integer z_month;
	
	public Integer getZhichu_id() {
		return zhichu_id;
	}
	public void setZhichu_id(Integer zhichu_id) {
		this.zhichu_id = zhichu_id;
	}
	public Integer getZhichu_xiangmu() {
		return zhichu_xiangmu;
	}
	public void setZhichu_xiangmu(Integer zhichu_xiangmu) {
		this.zhichu_xiangmu = zhichu_xiangmu;
	}
	public float getZhichu_jine() {
		return zhichu_jine;
	}
	public void setZhichu_jine(float zhichu_jine) {
		this.zhichu_jine = zhichu_jine;
	}
	public String getJingshouren() {
		return jingshouren;
	}
	public void setJingshouren(String jingshouren) {
		this.jingshouren = jingshouren;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public Date getZhichu_time() {
		return zhichu_time;
	}
	public void setZhichu_time(Date zhichu_time) {
		this.zhichu_time = zhichu_time;
	}
	public Integer getZ_year() {
		return z_year;
	}
	public void setZ_year(Integer z_year) {
		this.z_year = z_year;
	}
	public Integer getZ_month() {
		return z_month;
	}
	public void setZ_month(Integer z_month) {
		this.z_month = z_month;
	}

}