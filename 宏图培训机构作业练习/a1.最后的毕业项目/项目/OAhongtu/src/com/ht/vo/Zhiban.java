package com.ht.vo;

/**
 * Zhiban entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Zhiban implements java.io.Serializable {

	// Fields

	private Long zid;
	private String zdate;
	private String zteach1;
	private String zfanwei1;
	private String zteach2;
	private String zfanwei2;
	private String teachs;
	private String zteachers;

	// Constructors

	/** default constructor */
	public Zhiban() {
	}

	/** full constructor */
	public Zhiban(String zdate, String zteach1, String zfanwei1,
			String zteach2, String zfanwei2, String teachs, String zteachers) {
		this.zdate = zdate;
		this.zteach1 = zteach1;
		this.zfanwei1 = zfanwei1;
		this.zteach2 = zteach2;
		this.zfanwei2 = zfanwei2;
		this.teachs = teachs;
		this.zteachers = zteachers;
	}

	// Property accessors

	public Long getZid() {
		return this.zid;
	}

	public void setZid(Long zid) {
		this.zid = zid;
	}

	public String getZdate() {
		return this.zdate;
	}

	public void setZdate(String zdate) {
		this.zdate = zdate;
	}

	public String getZteach1() {
		return this.zteach1;
	}

	public void setZteach1(String zteach1) {
		this.zteach1 = zteach1;
	}

	public String getZfanwei1() {
		return this.zfanwei1;
	}

	public void setZfanwei1(String zfanwei1) {
		this.zfanwei1 = zfanwei1;
	}

	public String getZteach2() {
		return this.zteach2;
	}

	public void setZteach2(String zteach2) {
		this.zteach2 = zteach2;
	}

	public String getZfanwei2() {
		return this.zfanwei2;
	}

	public void setZfanwei2(String zfanwei2) {
		this.zfanwei2 = zfanwei2;
	}

	public String getTeachs() {
		return this.teachs;
	}

	public void setTeachs(String teachs) {
		this.teachs = teachs;
	}

	public String getZteachers() {
		return this.zteachers;
	}

	public void setZteachers(String zteachers) {
		this.zteachers = zteachers;
	}

}