package com.ht.pojo;

import java.util.Date;

public class Detailreceivables {
	private String dr_id;//应收款编号
	private String tender_id;//借款编号
	private String repay_id;//还款编号
	private Double capitals;//本金
	private Double interest;//利息
	private Double principal_interest;//本息
	private Date principal_date;//收款日期
	private Integer rece_status;//收款状态 
	private Double actual_interest;//实收本息
	private Double actual_date;//实收日期
	private Double factorage;//手续费（风险补偿）
	
	public Detailreceivables(){
		
	}
	public Detailreceivables(String dr_id, String tender_id, String repay_id, Double capitals, Double interest,
			Double principal_interest, Date principal_date, Integer rece_status, Double actual_interest,
			Double actual_date, Double factorage) {
		super();
		this.dr_id = dr_id;
		this.tender_id = tender_id;
		this.repay_id = repay_id;
		this.capitals = capitals;
		this.interest = interest;
		this.principal_interest = principal_interest;
		this.principal_date = principal_date;
		this.rece_status = rece_status;
		this.actual_interest = actual_interest;
		this.actual_date = actual_date;
		this.factorage = factorage;
	}
	public String getDr_id() {
		return dr_id;
	}
	public void setDr_id(String dr_id) {
		this.dr_id = dr_id;
	}
	public String getTender_id() {
		return tender_id;
	}
	public void setTender_id(String tender_id) {
		this.tender_id = tender_id;
	}
	public String getRepay_id() {
		return repay_id;
	}
	public void setRepay_id(String repay_id) {
		this.repay_id = repay_id;
	}
	public Double getCapitals() {
		return capitals;
	}
	public void setCapitals(Double capitals) {
		this.capitals = capitals;
	}
	public Double getInterest() {
		return interest;
	}
	public void setInterest(Double interest) {
		this.interest = interest;
	}
	public Double getPrincipal_interest() {
		return principal_interest;
	}
	public void setPrincipal_interest(Double principal_interest) {
		this.principal_interest = principal_interest;
	}
	public Date getPrincipal_date() {
		return principal_date;
	}
	public void setPrincipal_date(Date principal_date) {
		this.principal_date = principal_date;
	}
	public Integer getRece_status() {
		return rece_status;
	}
	public void setRece_status(Integer rece_status) {
		this.rece_status = rece_status;
	}
	public Double getActual_interest() {
		return actual_interest;
	}
	public void setActual_interest(Double actual_interest) {
		this.actual_interest = actual_interest;
	}
	public Double getActual_date() {
		return actual_date;
	}
	public void setActual_date(Double actual_date) {
		this.actual_date = actual_date;
	}
	public Double getFactorage() {
		return factorage;
	}
	public void setFactorage(Double factorage) {
		this.factorage = factorage;
	}
	
	
	
}
