package com.ht.yfbc.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 聊天表对象（chat）
 * day 2017-01-09
 * @author 魏海明
 *
 */
@SuppressWarnings("serial")
public class Chat implements Serializable{
	private String chid;
	private String setid;
	private String getid;
	private Date setdate;
	private String chtext;
	public Chat(String chid, String setid, String getid, Date setdate, String chtext) {
		super();
		this.chid = chid;
		this.setid = setid;
		this.getid = getid;
		this.setdate = setdate;
		this.chtext = chtext;
	}
	public String getChid() {
		return chid;
	}
	public void setChid(String chid) {
		this.chid = chid;
	}
	public String getSetid() {
		return setid;
	}
	public void setSetid(String setid) {
		this.setid = setid;
	}
	public String getGetid() {
		return getid;
	}
	public void setGetid(String getid) {
		this.getid = getid;
	}
	public Date getSetdate() {
		return setdate;
	}
	public void setSetdate(Date setdate) {
		this.setdate = setdate;
	}
	public String getChtext() {
		return chtext;
	}
	public void setChtext(String chtext) {
		this.chtext = chtext;
	}
	
	public Chat() {
		// TODO Auto-generated constructor stub
	}
}
