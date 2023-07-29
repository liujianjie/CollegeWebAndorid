package com.ht.yfbc.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * id:主键id<br>
 * userid:用户id<br>
 * bonus:奖励金额<br>
 * bonus_cause:奖励原因<br>
 * fine:处罚金额<br>
 * fine_cause:处罚原因<br>
 * recordtime:记录时间<br>
 * @author 刘宗龙
 *
 */
public class Rewards_penalties implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String userid;
	private Double bonus;
	private String bonus_cause;
	private Double fine;
	private String fine_cause;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date recordtime;
	public Rewards_penalties() {
	}
	public Rewards_penalties(String id, String userid, Double bonus, String bonus_cause, Double fine, String fine_cause,
			Date recordtime) {
		super();
		this.id = id;
		this.userid = userid;
		this.bonus = bonus;
		this.bonus_cause = bonus_cause;
		this.fine = fine;
		this.fine_cause = fine_cause;
		this.recordtime = recordtime;
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
	public Double getBonus() {
		return bonus;
	}
	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	public String getBonus_cause() {
		return bonus_cause;
	}
	public void setBonus_cause(String bonus_cause) {
		this.bonus_cause = bonus_cause;
	}
	public Double getFine() {
		return fine;
	}
	public void setFine(Double fine) {
		this.fine = fine;
	}
	public String getFine_cause() {
		return fine_cause;
	}
	public void setFine_cause(String fine_cause) {
		this.fine_cause = fine_cause;
	}
	public Date getRecordtime() {
		return recordtime;
	}
	public void setRecordtime(Date recordtime) {
		this.recordtime = recordtime;
	}
	@Override
	public String toString() {
		return "Rewards_penalties [id=" + id + ", userid=" + userid + ", bonus=" + bonus + ", bonus_cause="
				+ bonus_cause + ", fine=" + fine + ", fine_cause=" + fine_cause + ", recordtime=" + recordtime + "]";
	}
	
	

}
