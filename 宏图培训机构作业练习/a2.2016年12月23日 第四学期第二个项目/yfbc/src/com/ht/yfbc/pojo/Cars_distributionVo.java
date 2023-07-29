package com.ht.yfbc.pojo;

import java.io.Serializable;

public class Cars_distributionVo implements Serializable{

	private Cars_distribution cars_distribution;
	private String carsname;
	private String drivername;
	private String whname;
	public Cars_distributionVo(){
		
	}
	public Cars_distributionVo(Cars_distribution cars_distribution, String carsname, String drivername, String whname) {
		super();
		this.cars_distribution = cars_distribution;
		this.carsname = carsname;
		this.drivername = drivername;
		this.whname = whname;
	}
	public Cars_distribution getCars_distribution() {
		return cars_distribution;
	}
	public void setCars_distribution(Cars_distribution cars_distribution) {
		this.cars_distribution = cars_distribution;
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
