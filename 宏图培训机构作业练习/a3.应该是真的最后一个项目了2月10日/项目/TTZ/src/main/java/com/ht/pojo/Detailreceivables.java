package com.ht.pojo;

import java.util.Date;

public class Detailreceivables {
	private String dr_id;//Ӧ�տ���
	private String tender_id;//�����
	private String repay_id;//������
	private Double capitals;//����
	private Double interest;//��Ϣ
	private Double principal_interest;//��Ϣ
	private Date principal_date;//�տ�����
	private Integer rece_status;//�տ�״̬ 
	private Double actual_interest;//ʵ�ձ�Ϣ
	private Double actual_date;//ʵ������
	private Double factorage;//�����ѣ����ղ�����
	
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
