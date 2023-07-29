package com.ht.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户资金交易记录 
 */
public class MoneyRecord {
	private String m_id;
	private String p_userid;
	private String m_jytype;
	private Double m_yxmoney;
	private Double m_kymoney;
	private Double m_djmoney;
	private Double m_dsmoney;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date m_happentime;
	private String m_remark;
	private int m_type;
	
	public MoneyRecord(){}

	public MoneyRecord(String m_id, String p_userid, String m_jytype, Double m_yxmoney, Double m_kymoney,
			Double m_djmoney, Double m_dsmoney, Date m_happentime, String m_remark, int m_type) {
		super();
		this.m_id = m_id;
		this.p_userid = p_userid;
		this.m_jytype = m_jytype;
		this.m_yxmoney = m_yxmoney;
		this.m_kymoney = m_kymoney;
		this.m_djmoney = m_djmoney;
		this.m_dsmoney = m_dsmoney;
		this.m_happentime = m_happentime;
		this.m_remark = m_remark;
		this.m_type = m_type;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getP_userid() {
		return p_userid;
	}

	public void setP_userid(String p_userid) {
		this.p_userid = p_userid;
	}

	public String getM_jytype() {
		return m_jytype;
	}

	public void setM_jytype(String m_jytype) {
		this.m_jytype = m_jytype;
	}

	public Double getM_yxmoney() {
		return m_yxmoney;
	}

	public void setM_yxmoney(Double m_yxmoney) {
		this.m_yxmoney = m_yxmoney;
	}

	public Double getM_kymoney() {
		return m_kymoney;
	}

	public void setM_kymoney(Double m_kymoney) {
		this.m_kymoney = m_kymoney;
	}

	public Double getM_djmoney() {
		return m_djmoney;
	}

	public void setM_djmoney(Double m_djmoney) {
		this.m_djmoney = m_djmoney;
	}

	public Double getM_dsmoney() {
		return m_dsmoney;
	}

	public void setM_dsmoney(Double m_dsmoney) {
		this.m_dsmoney = m_dsmoney;
	}



	public Date getM_happentime() {
		return m_happentime;
	}



	public void setM_happentime(Date m_happentime) {
		this.m_happentime = m_happentime;
	}



	public String getM_remark() {
		return m_remark;
	}



	public void setM_remark(String m_remark) {
		this.m_remark = m_remark;
	}



	public int getM_type() {
		return m_type;
	}



	public void setM_type(int m_type) {
		this.m_type = m_type;
	}


	
	
}
