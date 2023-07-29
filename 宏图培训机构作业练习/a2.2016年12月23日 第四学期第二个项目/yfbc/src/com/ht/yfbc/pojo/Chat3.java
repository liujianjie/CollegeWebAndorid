package com.ht.yfbc.pojo;

import java.util.Date;

public class Chat3 extends Chat2{
	private String date;

	public Chat3(String chid, String setid, String getid, Date setdate, String chtext, Users setuser, Users getuser,
			String date) {
		super(chid, setid, getid, setdate, chtext, setuser, getuser);
		this.date = date;
	}
	
	public Chat3() {
		// TODO Auto-generated constructor stub
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
