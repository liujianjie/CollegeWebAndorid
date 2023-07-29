package com.ht.yfbc.pojo;

import java.io.Serializable;

public class Cars_attendanceVo implements Serializable{

	private Cars_attendance cars_attendance;
	private String carname;
	private String drivername;
	private String whname;
	public Cars_attendanceVo(){
		
	}
	public Cars_attendanceVo(Cars_attendance cars_attendance, String carname, String drivername, String whname) {
		super();
		this.cars_attendance = cars_attendance;
		this.carname = carname;
		this.drivername = drivername;
		this.whname = whname;
	}
	public Cars_attendance getCars_attendance() {
		return cars_attendance;
	}
	public void setCars_attendance(Cars_attendance cars_attendance) {
		this.cars_attendance = cars_attendance;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
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
