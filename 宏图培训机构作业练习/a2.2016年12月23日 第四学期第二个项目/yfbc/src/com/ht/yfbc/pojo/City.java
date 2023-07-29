package com.ht.yfbc.pojo;

import java.io.Serializable;
/**
 * 
 * 城市表对象(city)
 * day 2016-12-27
 * @author 魏海明
 *
 */
public class City implements Serializable{
	private Integer cityid;
	private Integer provinceid;
	private String name;
	
	public City() {
		// TODO Auto-generated constructor stub
	}

	public City(Integer cityid, Integer provinceid, String name) {
		super();
		this.cityid = cityid;
		this.provinceid = provinceid;
		this.name = name;
	}

	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	public Integer getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(Integer provinceid) {
		this.provinceid = provinceid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
