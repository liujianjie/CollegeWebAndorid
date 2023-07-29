package com.ht.yfbc.pojo;

import java.io.Serializable;
import java.util.Date;

public class Financing implements Serializable {
	private String id;
	private Date fintime;
	private Double income_money;
	private Double expend_money;
	private Double profit;
	
	public Financing() {
	}

	public Financing(String id, Date fintime, Double income_money, Double expend_money, Double profit) {
		super();
		this.id = id;
		this.fintime = fintime;
		this.income_money = income_money;
		this.expend_money = expend_money;
		this.profit = profit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFintime() {
		return fintime;
	}

	public void setFintime(Date fintime) {
		this.fintime = fintime;
	}

	public Double getIncome_money() {
		return income_money;
	}

	public void setIncome_money(Double income_money) {
		this.income_money = income_money;
	}

	public Double getExpend_money() {
		return expend_money;
	}

	public void setExpend_money(Double expend_money) {
		this.expend_money = expend_money;
	}

	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

}
