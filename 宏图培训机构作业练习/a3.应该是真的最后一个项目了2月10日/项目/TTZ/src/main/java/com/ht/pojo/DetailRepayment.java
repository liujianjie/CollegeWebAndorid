package com.ht.pojo;

import java.io.Serializable;
import java.util.Date;

public class DetailRepayment implements Serializable {
	private String repay_id;//������ϸ���
	private String b_id;//�����
	private Integer periods;//��������
	private Double repay_interest;//������Ϣ
	private Double repay_capital;//���Ϣ
	private Double repay_corpus;//�����
	private Date repay_date;//��������
	private Integer repay_status;//����״̬
	private Date actual_repay_date;//ʵ�ʻ�������
	private Double actual_repay_capital;//ʵ�ʻ��Ϣ
	
	public DetailRepayment(){
		
	}
	
	public DetailRepayment(String repay_id, String b_id, Integer periods, Double repay_interest, Double repay_capital,
			Double repay_corpus, Date repay_date, Integer repay_status, Date actual_repay_date,
			Double actual_repay_capital) {
		
		this.repay_id = repay_id;
		this.b_id = b_id;
		this.periods = periods;
		this.repay_interest = repay_interest;
		this.repay_capital = repay_capital;
		this.repay_corpus = repay_corpus;
		this.repay_date = repay_date;
		this.repay_status = repay_status;
		this.actual_repay_date = actual_repay_date;
		this.actual_repay_capital = actual_repay_capital;
	}
	public String getRepay_id() {
		return repay_id;
	}
	public void setRepay_id(String repay_id) {
		this.repay_id = repay_id;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public Integer getPeriods() {
		return periods;
	}
	public void setPeriods(Integer periods) {
		this.periods = periods;
	}
	public Double getRepay_interest() {
		return repay_interest;
	}
	public void setRepay_interest(Double repay_interest) {
		this.repay_interest = repay_interest;
	}
	public Double getRepay_capital() {
		return repay_capital;
	}
	public void setRepay_capital(Double repay_capital) {
		this.repay_capital = repay_capital;
	}
	public Double getRepay_corpus() {
		return repay_corpus;
	}
	public void setRepay_corpus(Double repay_corpus) {
		this.repay_corpus = repay_corpus;
	}
	public Date getRepay_date() {
		return repay_date;
	}
	public void setRepay_date(Date repay_date) {
		this.repay_date = repay_date;
	}
	public Integer getRepay_status() {
		return repay_status;
	}
	public void setRepay_status(Integer repay_status) {
		this.repay_status = repay_status;
	}
	public Date getActual_repay_date() {
		return actual_repay_date;
	}
	public void setActual_repay_date(Date actual_repay_date) {
		this.actual_repay_date = actual_repay_date;
	}
	public Double getActual_repay_capital() {
		return actual_repay_capital;
	}
	public void setActual_repay_capital(Double actual_repay_capital) {
		this.actual_repay_capital = actual_repay_capital;
	}
	
	
}
