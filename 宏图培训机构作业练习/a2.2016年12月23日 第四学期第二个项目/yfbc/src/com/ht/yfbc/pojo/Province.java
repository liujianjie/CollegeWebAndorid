package com.ht.yfbc.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 省份表数据对象
 * day 2016-12-27
 * @author 魏海明
 *
 */
public class Province implements Serializable{
	
	private Integer provinceid;
	private String name;
	private List<City> citys;
	
	public Province() {
		// TODO Auto-generated constructor stub
	}
	
	public Province(Integer provinceid, String name, List<City> citys) {
		super();
		this.provinceid = provinceid;
		this.name = name;
		this.citys = citys;
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

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
	
	
}
