package com.ht.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Factorage implements Serializable {
	private String fact_id;
	private Double fact_money;
	private Double fact_upd_money;
	private String fact_type;
	private String fact_distribe;
	private String fact_no;
	private Date fact_time;
	private String fact_statu;
	private String user_id;

	public Factorage() {

	}

	public Factorage(String fact_id, Double fact_money, Double fact_upd_money, String fact_type, String fact_distribe,
			String fact_no, Date fact_time, String fact_statu, String user_id) {
		super();
		this.fact_id = fact_id;
		this.fact_money = fact_money;
		this.fact_upd_money = fact_upd_money;
		this.fact_type = fact_type;
		this.fact_distribe = fact_distribe;
		this.fact_no = fact_no;
		this.fact_time = fact_time;
		this.fact_statu = fact_statu;
		this.user_id = user_id;
	}

	public String getFact_id() {
		return fact_id;
	}

	public void setFact_id(String fact_id) {
		this.fact_id = fact_id;
	}

	public Double getFact_money() {
		return fact_money;
	}

	public void setFact_money(Double fact_money) {
		this.fact_money = fact_money;
	}

	public Double getFact_upd_money() {
		return fact_upd_money;
	}

	public void setFact_upd_money(Double fact_upd_money) {
		this.fact_upd_money = fact_upd_money;
	}

	public String getFact_type() {
		return fact_type;
	}

	public void setFact_type(String fact_type) {
		this.fact_type = fact_type;
	}

	public String getFact_distribe() {
		return fact_distribe;
	}

	public void setFact_distribe(String fact_distribe) {
		this.fact_distribe = fact_distribe;
	}

	public String getFact_no() {
		return fact_no;
	}

	public void setFact_no(String fact_no) {
		this.fact_no = fact_no;
	}

	public String getFact_statu() {
		return fact_statu;
	}

	public void setFact_statu(String fact_statu) {
		this.fact_statu = fact_statu;
	}

	public Date getFact_time() {
		return fact_time;
	}

	public void setFact_time(Date fact_time) {
		this.fact_time = fact_time;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
