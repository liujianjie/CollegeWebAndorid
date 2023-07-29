package com.example.qq_lxr9y18r.bean;

import java.util.Date;

public class AndroidQqShowMessage implements java.io.Serializable{
	private Long smId;
	private Long qqId;
	private String qqZhanghao;
	private String qqName;
	private String qqTouxiang;
	private Long hyId;
	private String hyZhanghao;
	private String hyName;
	private String hyTouxiang;
	private String smContent;
	private Long smDate;



	public AndroidQqShowMessage() {
		super();
	}

	public AndroidQqShowMessage(Long smId, Long qqId, String qqZhanghao, String qqName, String qqTouxiang, Long hyId,
								String hyZhanghao, String hyName, String hyTouxiang, String smContent, Long smDate) {
		super();
		this.smId = smId;
		this.qqId = qqId;
		this.qqZhanghao = qqZhanghao;
		this.qqName = qqName;
		this.qqTouxiang = qqTouxiang;
		this.hyId = hyId;
		this.hyZhanghao = hyZhanghao;
		this.hyName = hyName;
		this.hyTouxiang = hyTouxiang;
		this.smContent = smContent;
		this.smDate = smDate;
	}
	public Long getSmId() {
		return smId;
	}



	public void setSmId(Long smId) {
		this.smId = smId;
	}



	public Long getQqId() {
		return qqId;
	}



	public void setQqId(Long qqId) {
		this.qqId = qqId;
	}



	public String getQqName() {
		return qqName;
	}



	public void setQqName(String qqName) {
		this.qqName = qqName;
	}



	public String getQqTouxiang() {
		return qqTouxiang;
	}



	public void setQqTouxiang(String qqTouxiang) {
		this.qqTouxiang = qqTouxiang;
	}



	public Long getHyId() {
		return hyId;
	}



	public void setHyId(Long hyId) {
		this.hyId = hyId;
	}



	public String getHyName() {
		return hyName;
	}



	public void setHyName(String hyName) {
		this.hyName = hyName;
	}



	public String getHyTouxiang() {
		return hyTouxiang;
	}



	public void setHyTouxiang(String hyTouxiang) {
		this.hyTouxiang = hyTouxiang;
	}



	public String getSmContent() {
		return smContent;
	}



	public void setSmContent(String smContent) {
		this.smContent = smContent;
	}



	public Long getSmDate() {
		return smDate;
	}



	public void setSmDate(Long smDate) {
		this.smDate = smDate;
	}

	public String getQqZhanghao() {
		return qqZhanghao;
	}

	public void setQqZhanghao(String qqZhanghao) {
		this.qqZhanghao = qqZhanghao;
	}

	public String getHyZhanghao() {
		return hyZhanghao;
	}

	public void setHyZhanghao(String hyZhanghao) {
		this.hyZhanghao = hyZhanghao;
	}


}
