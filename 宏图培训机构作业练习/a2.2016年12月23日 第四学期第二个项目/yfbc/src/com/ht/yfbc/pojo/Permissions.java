package com.ht.yfbc.pojo;

import java.io.Serializable;

/**
 * <p>Permissions授权表</p>
 *	<p>id:sys_guid(),32位的字符串</p>
 *	<p>lmtlist：权限列表,字符串,类似于[1,2,3,...](记录相应权限的id)</p>
 * 	<p>Day 2016-12-28</p>
 * @author 刘宗龙
 *	
 */
public class Permissions implements Serializable{
	private String id;
	private String userid;
	private String lmtlist;
	public Permissions() {
	}
	public Permissions(String id, String userid, String lmtlist) {
		this.id = id;
		this.userid = userid;
		this.lmtlist = lmtlist;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLmtlist() {
		return lmtlist;
	}
	public void setLmtlist(String lmtlist) {
		this.lmtlist = lmtlist;
	}
	@Override
	public String toString() {
		return "Permissions [id=" + id + ", userid=" + userid + ", lmtlist=" + lmtlist + "]";
	}
	
	
}
