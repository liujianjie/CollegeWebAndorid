package com.ht.bean;

import java.io.Serializable;

public class AirQualityBean implements Serializable{
	private Integer a_id;
	private Integer d_id;
	private String a_time;
	private Integer a_pm10;
	private Integer a_pm25;
	private String a_station;
	private String a_latetime;
	
	private DistrictBean dis;
	
	public DistrictBean getDis() {
		return dis;
	}
	public void setDis(DistrictBean dis) {
		this.dis = dis;
	}
	public Integer getA_id() {
		return a_id;
	}
	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	public String getA_time() {
		return a_time;
	}
	public void setA_time(String a_time) {
		this.a_time = a_time;
	}
	public Integer getA_pm10() {
		return a_pm10;
	}
	public void setA_pm10(Integer a_pm10) {
		this.a_pm10 = a_pm10;
	}
	public Integer getA_pm25() {
		return a_pm25;
	}
	public void setA_pm25(Integer a_pm25) {
		this.a_pm25 = a_pm25;
	}
	public String getA_station() {
		return a_station;
	}
	public void setA_station(String a_station) {
		this.a_station = a_station;
	}
	public String getA_latetime() {
		return a_latetime;
	}
	public void setA_latetime(String a_latetime) {
		this.a_latetime = a_latetime;
	}
	
	
}
