package com.camera.pojo;

public class WorkTime {
	private int wid;
	private int day;
	private int starthour;
	private int startmin;
	private int endhour;
	private int endmin;
	private int type;// 0工作，1不工作
	
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getStarthour() {
		return starthour;
	}
	public void setStarthour(int starthour) {
		this.starthour = starthour;
	}
	public int getStartmin() {
		return startmin;
	}
	public void setStartmin(int startmin) {
		this.startmin = startmin;
	}
	public int getEndhour() {
		return endhour;
	}
	public void setEndhour(int endhour) {
		this.endhour = endhour;
	}
	public int getEndmin() {
		return endmin;
	}
	public void setEndmin(int endmin) {
		this.endmin = endmin;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "WorkTime [wid=" + wid + ", day=" + day + ", starthour=" + starthour + ", startmin=" + startmin
				+ ", endhour=" + endhour + ", endmin=" + endmin + ", type=" + type + "]";
	}
	
}
