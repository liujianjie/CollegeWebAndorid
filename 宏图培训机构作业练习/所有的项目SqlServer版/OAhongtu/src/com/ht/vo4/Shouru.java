package com.ht.vo4;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Shouru entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Shouru{

	// Fields
	private Integer shouru_id;
	private Integer shoufei_xiangmu;
	private float shoufei_jine;
	private String jingshouren;
	private String beizhu;
	private Date shoufei_time;
	private Integer s_year;
	private Integer s_month;
	
	public Integer getShouru_id() {
		return shouru_id;
	}
	public void setShouru_id(Integer shouru_id) {
		this.shouru_id = shouru_id;
	}
	public Integer getShoufei_xiangmu() {
		return shoufei_xiangmu;
	}
	public void setShoufei_xiangmu(Integer shoufei_xiangmu) {
		this.shoufei_xiangmu = shoufei_xiangmu;
	}
	public float getShoufei_jine() {
		return shoufei_jine;
	}
	public void setShoufei_jine(float shoufei_jine) {
		this.shoufei_jine = shoufei_jine;
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
	
	public Integer getS_year() {
		return s_year;
	}
	public void setS_year(Integer s_year) {
		this.s_year = s_year;
	}
	public Integer getS_month() {
		return s_month;
	}
	public void setS_month(Integer s_month) {
		this.s_month = s_month;
	}
	public Date getShoufei_time() {
		return shoufei_time;
	}
	public void setShoufei_time(Date shoufei_time) {
		this.shoufei_time = shoufei_time;
	}
	
	
	
}