package com.ht.yfbc.pojo;

public class Msg2 extends Msgpojo{
	private Users user;
	public Msg2() {
		// TODO Auto-generated constructor stub
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Msg2(Users user) {
		super();
		this.user = user;
	}
	
}
