package com.snake.bean;

// ≈≈––∞Ò Ù–‘
public class GsnRankBean {
	private String name;
	private int socre;
	private String date;
	
	public GsnRankBean() {
		// TODO Auto-generated constructor stub
	}
	public GsnRankBean(GsnRankBean g) {
		name = new String(g.getName());
		date = new String(g.getDate());
		socre = g.socre;
	}
	@Override
	public String toString() {
		return "name:" + name + "&socre:" + socre + "&date:" + date ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSocre() {
		return socre;
	}
	public void setSocre(int socre) {
		this.socre = socre;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
