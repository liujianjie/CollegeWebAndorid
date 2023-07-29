package com.ht.vo4;

/**
 * JiaoqingZhuangtai entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JiaoqingZhuangtai implements java.io.Serializable {

	// Fields

	private Long jiaoqingId;
	private Long stuid;
	private Long xueqiId;
	private String status;
	
	private String stuname;
	private String stuclass;

	// Constructors

	/** default constructor */
	public JiaoqingZhuangtai() {
	}

	/** minimal constructor */
	public JiaoqingZhuangtai(Long jiaoqingId) {
		this.jiaoqingId = jiaoqingId;
	}

	/** full constructor */
	public JiaoqingZhuangtai(Long jiaoqingId, Long stuid, Long xueqiId,
			String status) {
		this.jiaoqingId = jiaoqingId;
		this.stuid = stuid;
		this.xueqiId = xueqiId;
		this.status = status;
	}

	// Property accessors

	public Long getJiaoqingId() {
		return this.jiaoqingId;
	}

	public void setJiaoqingId(Long jiaoqingId) {
		this.jiaoqingId = jiaoqingId;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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