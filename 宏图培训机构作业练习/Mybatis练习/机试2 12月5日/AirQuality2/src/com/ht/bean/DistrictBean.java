package com.ht.bean;

import java.io.Serializable;
import java.util.List;

public class DistrictBean implements Serializable{
	private Integer d_id;
	private String d_name;
	
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	
}
