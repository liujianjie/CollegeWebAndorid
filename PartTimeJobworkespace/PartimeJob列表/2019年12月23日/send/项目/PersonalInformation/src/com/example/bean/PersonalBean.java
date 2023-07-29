package com.example.bean;
// 个人信息bean
public class PersonalBean {
	int perid;
	String title;
	String context;
	
	public PersonalBean(){
		
	}
	public PersonalBean(int perid, String title, String context) {
		super();
		this.perid = perid;
		this.title = title;
		this.context = context;
	}

	
	
	@Override
	public String toString() {
		return "PersonalBean [perid=" + perid + ", title=" + title + ", context=" + context + "]";
	}
	public int getPerid() {
		return perid;
	}
	public void setPerid(int perid) {
		this.perid = perid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
}
