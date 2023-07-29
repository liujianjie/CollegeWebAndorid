package com.ht.yfbc.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Expend implements Serializable {
	private String id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date exptime;
	private String exptypes;
	private Double money;

	public Expend() {
	}

	public Expend(String id, Date exptime, String exptypes, Double money) {
		super();
		this.id = id;
		this.exptime = exptime;
		this.exptypes = exptypes;
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getExptime() {
		return exptime;
	}

	public void setExptime(Date exptime) {
		this.exptime = exptime;
	}

	public String getExptypes() {
		return exptypes;
	}

	public void setExptypes(String exptypes) {
		this.exptypes = exptypes;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}


}
