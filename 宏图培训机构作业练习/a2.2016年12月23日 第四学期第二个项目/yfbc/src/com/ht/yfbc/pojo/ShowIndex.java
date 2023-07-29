package com.ht.yfbc.pojo;

import java.io.Serializable;

/**
 * time:时间<br>
 * income:总收入<br>
 * expend:总支出<br>
 * @author lzl
 *
 */
public class ShowIndex implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String time;
	private Double income ;
	private Double expend ;
	public ShowIndex() {
	}
	public ShowIndex(String time, Double income, Double expend) {
		super();
		this.time = time;
		this.income = income;
		this.expend = expend;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public Double getExpend() {
		return expend;
	}
	public void setExpend(Double expend) {
		this.expend = expend;
	}
	
}
