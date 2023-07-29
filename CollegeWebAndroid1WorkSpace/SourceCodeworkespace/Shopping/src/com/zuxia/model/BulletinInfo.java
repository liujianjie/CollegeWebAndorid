package com.zuxia.model;

import java.io.Serializable;
import java.util.Date;

public class BulletinInfo implements Serializable {
	
	private int id;	//编号
	private String title;	//标题
	private String content;	//内容
	private UserInfo user;	//发布者
	private Date createTime;	//发布时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
