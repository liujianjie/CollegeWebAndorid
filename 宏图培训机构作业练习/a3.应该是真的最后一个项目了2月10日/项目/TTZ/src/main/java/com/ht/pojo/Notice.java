package com.ht.pojo;

import java.util.Date;

/**
 *ÍøÕ¾¹«¸æ 
 * */
public class Notice {
	private String n_id;
	private String n_title;
	private String n_body;
	private Date n_date;
	private String n_author;
	private Integer n_count;
	
	public Notice() {}

	public Notice(String n_id, String n_title, String n_body, Date n_date, String n_author, Integer n_count) {
		super();
		this.n_id = n_id;
		this.n_title = n_title;
		this.n_body = n_body;
		this.n_date = n_date;
		this.n_author = n_author;
		this.n_count = n_count;
	}



	public String getN_id() {
		return n_id;
	}
	public void setN_id(String n_id) {
		this.n_id = n_id;
	}
	public String getN_title() {
		return n_title;
	}
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}
	public String getN_body() {
		return n_body;
	}
	public void setN_body(String n_body) {
		this.n_body = n_body;
	}
	public Date getN_date() {
		return n_date;
	}
	public void setN_date(Date n_date) {
		this.n_date = n_date;
	}



	public String getN_author() {
		return n_author;
	}
	public void setN_author(String n_author) {
		this.n_author = n_author;
	}
	public Integer getN_count() {
		return n_count;
	}

	public void setN_count(Integer n_count) {
		this.n_count = n_count;
	}
	
	
}
