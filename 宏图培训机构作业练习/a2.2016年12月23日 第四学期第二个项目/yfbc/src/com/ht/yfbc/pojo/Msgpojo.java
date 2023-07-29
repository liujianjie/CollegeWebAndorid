package com.ht.yfbc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Msgpojo implements Serializable {
	private String id;
	private String msgtitle;
	private String msgcon;
	private String msgstatu;
	private String  msgtopeople;
	private String msgpeople;
	private Date msgtime;
	private String msgfile;
	private String date;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Msgpojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Msgpojo(String id, String msgtitle, String msgcon, String msgstatu, String msgtopeople, String msgpeople,
			Date msgtime, String msgfile) {
		super();
		this.id = id;
		this.msgtitle = msgtitle;
		this.msgcon = msgcon;
		this.msgstatu = msgstatu;
		this.msgtopeople = msgtopeople;
		this.msgpeople = msgpeople;
		this.msgtime = msgtime;
		this.msgfile = msgfile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMsgtitle() {
		return msgtitle;
	}

	public void setMsgtitle(String msgtitle) {
		this.msgtitle = msgtitle;
	}

	public String getMsgcon() {
		return msgcon;
	}

	public void setMsgcon(String msgcon) {
		this.msgcon = msgcon;
	}

	public String getMsgstatu() {
		return msgstatu;
	}

	public void setMsgstatu(String msgstatu) {
		this.msgstatu = msgstatu;
	}

	public String getMsgtopeople() {
		return msgtopeople;
	}

	public void setMsgtopeople(String msgtopeople) {
		this.msgtopeople = msgtopeople;
	}

	public String getMsgpeople() {
		return msgpeople;
	}

	public void setMsgpeople(String msgpeople) {
		this.msgpeople = msgpeople;
	}

	public Date getMsgtime() {
		return msgtime;
	}

	public void setMsgtime(Date msgtime) {
		this.msgtime = msgtime;
	}

	public String getMsgfile() {
		return msgfile;
	}

	public void setMsgfile(String msgfile) {
		this.msgfile = msgfile;
	}
	
	
}
