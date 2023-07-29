package com.example.qq_lxr9y18r.bean;

public class LiaoTianBean {
	private int state;
	private String content;
	
	public LiaoTianBean(int state, String content) {
		super();
		this.state = state;
		this.content = content;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
