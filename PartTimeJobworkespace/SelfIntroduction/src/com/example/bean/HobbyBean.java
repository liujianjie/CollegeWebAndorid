package com.example.bean;

// 拥有的所有爱好bean
public class HobbyBean {
	int hobbyid;
	String hobbyname;
	
	public HobbyBean(){
		
	}
	public HobbyBean(int id, String hoyname){
		this.hobbyid = id;
		this.hobbyname = hoyname;
	}
	
	public int getHobbyid() {
		return hobbyid;
	}
	public void setHobbyid(int hobbyid) {
		this.hobbyid = hobbyid;
	}
	public String getHobbyname() {
		return hobbyname;
	}
	public void setHobbyname(String hobbyname) {
		this.hobbyname = hobbyname;
	}
	
	
}
