package com.ht.vo2;

import java.util.Date;

/**
 * Feedback entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Feedback implements java.io.Serializable {

	// Fields

	private Long fid;
	private Long empid;
	private String fpro;
	private Long cid;
	private Long stuid;
	private Long s1;
	private Long s2;
	private Long s3;
	private Long s4;
	private Long s5;
	private Long s6;
	private Long s7;
	private Long s8;
	private Long sum;
	private Long states;
	private Date times;
	private Long feedyear;
	private Long feedmonth;
	private Long fdid;
	// Constructors

	/** default constructor */
	public Feedback() {
	}

	/** full constructor */
	public Feedback(Long empid, String fpro, Long cid, Long stuid, Long s1,
			Long s2, Long s3, Long s4, Long s5, Long s6, Long s7, Long s8,
			Long sum, Long states, Date times,Long feedyear,Long feedmonth,Long fdid) {
		this.empid = empid;
		this.fpro = fpro;
		this.cid = cid;
		this.stuid = stuid;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.s4 = s4;
		this.s5 = s5;
		this.s6 = s6;
		this.s7 = s7;
		this.s8 = s8;
		this.sum = sum;
		this.states = states;
		this.times = times;
		this.feedyear = feedyear;
		this.feedmonth = feedmonth;
		this.fdid=fdid;
	}

	// Property accessors

	public Long getFid() {
		return this.fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public Long getEmpid() {
		return this.empid;
	}

	public void setEmpid(Long empid) {
		this.empid = empid;
	}

	public String getFpro() {
		return this.fpro;
	}

	public void setFpro(String fpro) {
		this.fpro = fpro;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getStuid() {
		return this.stuid;
	}

	public void setStuid(Long stuid) {
		this.stuid = stuid;
	}

	public Long getS1() {
		return this.s1;
	}

	public void setS1(Long s1) {
		this.s1 = s1;
	}

	public Long getS2() {
		return this.s2;
	}

	public void setS2(Long s2) {
		this.s2 = s2;
	}

	public Long getS3() {
		return this.s3;
	}

	public void setS3(Long s3) {
		this.s3 = s3;
	}

	public Long getS4() {
		return this.s4;
	}

	public void setS4(Long s4) {
		this.s4 = s4;
	}

	public Long getS5() {
		return this.s5;
	}

	public void setS5(Long s5) {
		this.s5 = s5;
	}

	public Long getS6() {
		return this.s6;
	}

	public void setS6(Long s6) {
		this.s6 = s6;
	}

	public Long getS7() {
		return this.s7;
	}

	public void setS7(Long s7) {
		this.s7 = s7;
	}

	public Long getS8() {
		return this.s8;
	}

	public void setS8(Long s8) {
		this.s8 = s8;
	}

	public Long getSum() {
		return this.sum;
	}

	public void setSum(Long sum) {
		this.sum = sum;
	}

	public Long getStates() {
		return this.states;
	}

	public void setStates(Long states) {
		this.states = states;
	}

	public Date getTimes() {
		return this.times;
	}

	public void setTimes(Date times) {
		this.times = times;
	}

	public Long getFeedyear() {
		return feedyear;
	}

	public void setFeedyear(Long feedyear) {
		this.feedyear = feedyear;
	}

	public Long getFeedmonth() {
		return feedmonth;
	}

	public void setFeedmonth(Long feedmonth) {
		this.feedmonth = feedmonth;
	}

	
	public Long getFdid() {
		return fdid;
	}

	public void setFdid(Long fdid) {
		this.fdid = fdid;
	}

}