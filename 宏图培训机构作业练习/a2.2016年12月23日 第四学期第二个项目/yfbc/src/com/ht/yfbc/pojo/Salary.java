package com.ht.yfbc.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * id:主键id<br>
 * userid:用户id<br>
 * positionid:职位id<br>
 * basesal:基本工资<br>
 * deduction_wage:提成工资<br>
 * bonus:奖励工资<br>
 * fine:处罚金额<br>
 * sfgz:实发工资<br>
 * time:记录时间<br>
 * Day 2017-1-3
 * @author 刘宗龙
 *
 */
public class Salary implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String userid;
	private String positionid;
	private Double basesal;
	private Double deduction_wage;
	private Double bonus;
	private Double fine;
	private Double sfgz;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date time;
	public Salary() {
	}
	public Salary(String id, String userid, String positionid, Double basesal, Double deduction_wage, Double bonus,
			Double fine, Double sfgz, Date time) {
		this.id = id;
		this.userid = userid;
		this.positionid = positionid;
		this.basesal = basesal;
		this.deduction_wage = deduction_wage;
		this.bonus = bonus;
		this.fine = fine;
		this.sfgz = sfgz;
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPositionid() {
		return positionid;
	}
	public void setPositionid(String positionid) {
		this.positionid = positionid;
	}
	public Double getBasesal() {
		return basesal;
	}
	public void setBasesal(Double basesal) {
		this.basesal = basesal;
	}
	public Double getDeduction_wage() {
		return deduction_wage;
	}
	public void setDeduction_wage(Double deduction_wage) {
		this.deduction_wage = deduction_wage;
	}
	public Double getBonus() {
		return bonus;
	}
	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	public Double getFine() {
		return fine;
	}
	public void setFine(Double fine) {
		this.fine = fine;
	}
	public Double getSfgz() {
		return sfgz;
	}
	public void setSfgz(Double sfgz) {
		this.sfgz = sfgz;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Salary [id=" + id + ", userid=" + userid + ", positionid=" + positionid + ", basesal=" + basesal
				+ ", deduction_wage=" + deduction_wage + ", bonus=" + bonus + ", fine=" + fine + ", sfgz=" + sfgz
				+ ", time=" + time + "]";
	}
	
	
	
}
