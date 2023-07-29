package com.ht.yfbc.pojo;

import java.io.Serializable;

public class Cars_repairsVo implements Serializable{

	private Cars_repairs cars_repairs;
	private String carsname;
	private String username;
	
	public Cars_repairsVo(){
		
	}
	public Cars_repairsVo(Cars_repairs cars_repairs, String carsname, String username) {
		super();
		this.cars_repairs = cars_repairs;
		this.carsname = carsname;
		this.username = username;
	}
	public Cars_repairs getCars_repairs() {
		return cars_repairs;
	}
	public void setCars_repairs(Cars_repairs cars_repairs) {
		this.cars_repairs = cars_repairs;
	}
	public String getCarsname() {
		return carsname;
	}
	public void setCarsname(String carsname) {
		this.carsname = carsname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
