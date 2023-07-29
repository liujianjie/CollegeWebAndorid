package com.ht.yfbc.pojo;

import java.io.Serializable;

public class Cars_changeVo implements Serializable{

	private Cars_change cars_change;
	private String carsname;
	private String drivername;
	private String whname;
	public Cars_changeVo(){
		
	}
	public Cars_changeVo(Cars_change cars_change, String carsname, String drivername, String whname) {
		super();
		this.cars_change = cars_change;
		this.carsname = carsname;
		this.drivername = drivername;
		this.whname = whname;
	}
	public Cars_change getCars_change() {
		return cars_change;
	}
	public void setCars_change(Cars_change cars_change) {
		this.cars_change = cars_change;
	}
	public String getCarsname() {
		return carsname;
	}
	public void setCarsname(String carsname) {
		this.carsname = carsname;
	}
	public String getDrivername() {
		return drivername;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public String getWhname() {
		return whname;
	}
	public void setWhname(String whname) {
		this.whname = whname;
	}
	
	
	
}
