package com.ht.vo4;

import java.util.Date;

/**
 * Xuefei entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Xuefei implements java.io.Serializable {

	// Fields

	private Long xuefeiId;
	private Long stuid;
	private Long xueqiId;
	private Float jine;
	private String jingshouren;
	private Long jiaofeiFangshi;
	private java.util.Date xuefeiTime;
	
	private String stuname;
	private String stuclass;

	// Constructors

	/** default constructor */
	public Xuefei() {
	}

	/** minimal constructor */
	public Xuefei(Long xuefeiId) {
		this.xuefeiId = xuefeiId;
	}

	/** full constructor */
	public Xuefei(Long xuefeiId, Long stuid, Long xueqiId, Float jine,
			String jingshouren, Long jiaofeiFangshi, Date xuefeiTime) {
		this.xuefeiId = xuefeiId;
		this.stuid = stuid;
		this.xueqiId = xueqiId;
		this.jine = jine;
		this.jingshouren = jingshouren;
		this.jiaofeiFangshi = jiaofeiFangshi;
		this.xuefeiTime = xuefeiTime;
	}

	// Property accessors

	public Long getXuefeiId() {
		return this.xuefeiId;
	}

	public void setXuefeiId(Long xuefeiId) {
		this.xuefeiId = xuefeiId;
	}

	public Long getStuid() {
		return this.stuid;
	}

	public void setStuid(Long stuid) {
		this.stuid = stuid;
	}

	public Long getXueqiId() {
		return this.xueqiId;
	}

	public void setXueqiId(Long xueqiId) {
		this.xueqiId = xueqiId;
	}

	public Float getJine() {
		return this.jine;
	}

	public void setJine(Float jine) {
		this.jine = jine;
	}

	public String getJingshouren() {
		return this.jingshouren;
	}

	public void setJingshouren(String jingshouren) {
		this.jingshouren = jingshouren;
	}

	public Long getJiaofeiFangshi() {
		return this.jiaofeiFangshi;
	}

	public void setJiaofeiFangshi(Long jiaofeiFangshi) {
		this.jiaofeiFangshi = jiaofeiFangshi;
	}

	public java.util.Date getXuefeiTime() {
		return xuefeiTime;
	}

	public void setXuefeiTime(java.util.Date xuefeiTime) {
		this.xuefeiTime = xuefeiTime;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getStuclass() {
		return stuclass;
	}

	public void setStuclass(String stuclass) {
		this.stuclass = stuclass;
	}

	

}