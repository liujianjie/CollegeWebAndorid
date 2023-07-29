package com.ht.vo6;

import java.util.Date;

/**
 * Msg entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Msg{


	private Integer msgid;
	private String msgtitle;
	private String msgcon;
	private Integer msgstatus;
	
	private String faburen;
	private Date fabutime;
	
	private Integer msgface;
	
	public Integer getMsgid() {
		return msgid;
	}
	public void setMsgid(Integer msgid) {
		this.msgid = msgid;
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
	public Integer getMsgstatus() {
		return msgstatus;
	}
	public void setMsgstatus(Integer msgstatus) {
		this.msgstatus = msgstatus;
	}
	public Integer getMsgface() {
		return msgface;
	}
	public void setMsgface(Integer msgface) {
		this.msgface = msgface;
	}
	public String getFaburen() {
		return faburen;
	}
	public void setFaburen(String faburen) {
		this.faburen = faburen;
	}
	public Date getFabutime() {
		return fabutime;
	}
	public void setFabutime(Date fabutime) {
		this.fabutime = fabutime;
	}

	

}