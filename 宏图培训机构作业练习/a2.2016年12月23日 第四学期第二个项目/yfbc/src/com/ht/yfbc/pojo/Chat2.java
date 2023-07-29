package com.ht.yfbc.pojo;

import java.util.Date;

public class Chat2 extends Chat{
	private Users setuser;
	private Users getuser;
	public Users getSetuser() {
		return setuser;
	}
	public void setSetuser(Users setuser) {
		this.setuser = setuser;
	}
	public Users getGetuser() {
		return getuser;
	}
	public void setGetuser(Users getuser) {
		this.getuser = getuser;
	}
	public Chat2(String chid, String setid, String getid, Date setdate, String chtext, Users setuser, Users getuser) {
		super(chid, setid, getid, setdate, chtext);
		this.setuser = setuser;
		this.getuser = getuser;
	}
	
	public Chat2() {
		// TODO Auto-generated constructor stub
	}
	
}
