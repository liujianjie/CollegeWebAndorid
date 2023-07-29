package com.ht.yfbc.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Income implements Serializable {
	private String id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date inctime;
	private String types;
	private Double money;

	public Income() {
	}

	public Income(String id, Date inctime, String types, Double money) {
		super();
		this.id = id;
		this.inctime = inctime;
		this.types = types;
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getInctime() {
		return inctime;
	}

	public void setInctime(Date inctime) {
		this.inctime = inctime;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}


}
