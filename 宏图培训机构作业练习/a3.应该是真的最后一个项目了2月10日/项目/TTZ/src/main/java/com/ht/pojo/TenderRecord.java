package com.ht.pojo;

import java.io.Serializable;
import java.util.Date;

public class TenderRecord implements Serializable {
	private String t_id;// �����
	private String tender_id;// Ͷ���¼���
	private double tender_money;// Ͷ����
	private Date tender_time;// Ͷ��ʱ��
	private String tender_name;// Ͷ����id
	private String tender_type;// Ͷ������
	private String tender_statu;// ״̬
	private String sign_statu;// ���״̬
	private double tender_interest;// ����Ϣ
	private double tender_fee;// ��������

	// mapperӳ���ֶ�
	private String zsname;// Ͷ������ʵ����
	private String rate;// �껯����
	private String sex;
	private Double mon;

	public TenderRecord() {
	}

	public TenderRecord(String t_id, String tender_id, double tender_money, Date tender_time, String tender_name,
			String tender_type, String tender_statu, String sign_statu, double tender_interest, double tender_fee) {
		this.t_id = t_id;
		this.tender_id = tender_id;
		this.tender_money = tender_money;
		this.tender_time = tender_time;
		this.tender_name = tender_name;
		this.tender_type = tender_type;
		this.tender_statu = tender_statu;
		this.sign_statu = sign_statu;
		this.tender_interest = tender_interest;
		this.tender_fee = tender_fee;
	}

	public Double getMon() {
		return mon;
	}

	public void setMon(Double mon) {
		this.mon = mon;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getZsname() {
		return zsname;
	}

	public void setZsname(String zsname) {
		this.zsname = zsname;
	}

	public String getT_id() {
		return t_id;
	}

	public void setT_id(String t_id) {
		this.t_id = t_id;
	}

	public String getTender_id() {
		return tender_id;
	}

	public void setTender_id(String tender_id) {
		this.tender_id = tender_id;
	}

	public double getTender_money() {
		return tender_money;
	}

	public void setTender_money(double tender_money) {
		this.tender_money = tender_money;
	}

	public Date getTender_time() {
		return tender_time;
	}

	public void setTender_time(Date tender_time) {
		this.tender_time = tender_time;
	}

	public String getTender_name() {
		return tender_name;
	}

	public void setTender_name(String tender_name) {
		this.tender_name = tender_name;
	}

	public String getTender_type() {
		return tender_type;
	}

	public void setTender_type(String tender_type) {
		this.tender_type = tender_type;
	}

	public String getTender_statu() {
		return tender_statu;
	}

	public void setTender_statu(String tender_statu) {
		this.tender_statu = tender_statu;
	}

	public String getSign_statu() {
		return sign_statu;
	}

	public void setSign_statu(String sign_statu) {
		this.sign_statu = sign_statu;
	}

	public double getTender_interest() {
		return tender_interest;
	}

	public void setTender_interest(double tender_interest) {
		this.tender_interest = tender_interest;
	}

	public double getTender_fee() {
		return tender_fee;
	}

	public void setTender_fee(double tender_fee) {
		this.tender_fee = tender_fee;
	}

}
