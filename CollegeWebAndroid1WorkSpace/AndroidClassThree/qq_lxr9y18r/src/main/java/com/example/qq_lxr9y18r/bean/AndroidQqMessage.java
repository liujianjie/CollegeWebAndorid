package com.example.qq_lxr9y18r.bean;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

/**
 * AndroidQqMessage entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AndroidQqMessage implements java.io.Serializable {

	// Fields
	@SerializedName("mId")
	private Long MId;
	private Long qqId;
	private String qqZhanghao;
	private String qqName;
	private String qqTouxiang;
	@SerializedName("mMessage")
	private String MMessage;
	@SerializedName("mDate")
	private long MDate;
	@SerializedName("mJsid")
	private Long MJsid;
	@SerializedName("mZhanghao")
	private String MZhanghao;
	@SerializedName("mName")
	private String MName;
	@SerializedName("mTouxiang")
	private String MTouxiang;
	@SerializedName("mStatu")
	private Long MStatu;

	private int result;
	
	// Constructors

	/** default constructor */
	public AndroidQqMessage() {
	}

	/** full constructor */
	public AndroidQqMessage(Long qqId, String qqZhanghao, String qqName,
			String qqTouxiang, String MMessage, long MDate, Long MJsid,
			String MZhanghao, String MName, String MTouxiang, Long MStatu,int result) {
		this.qqId = qqId;
		this.qqZhanghao = qqZhanghao;
		this.qqName = qqName;
		this.qqTouxiang = qqTouxiang;
		this.MMessage = MMessage;
		this.MDate = MDate;
		this.MJsid = MJsid;
		this.MZhanghao = MZhanghao;
		this.MName = MName;
		this.MTouxiang = MTouxiang;
		this.MStatu = MStatu;
		this.result=result;
	}

	// Property accessors

	public Long getMId() {
		return this.MId;
	}

	public void setMId(Long MId) {
		this.MId = MId;
	}

	public Long getQqId() {
		return this.qqId;
	}

	public void setQqId(Long qqId) {
		this.qqId = qqId;
	}

	public String getQqZhanghao() {
		return this.qqZhanghao;
	}

	public void setQqZhanghao(String qqZhanghao) {
		this.qqZhanghao = qqZhanghao;
	}

	public String getQqName() {
		return this.qqName;
	}

	public void setQqName(String qqName) {
		this.qqName = qqName;
	}

	public String getQqTouxiang() {
		return this.qqTouxiang;
	}

	public void setQqTouxiang(String qqTouxiang) {
		this.qqTouxiang = qqTouxiang;
	}

	public String getMMessage() {
		return this.MMessage;
	}

	public void setMMessage(String MMessage) {
		this.MMessage = MMessage;
	}

	public long getMDate() {
		return this.MDate;
	}

	public void setMDate(long MDate) {
		this.MDate = MDate;
	}

	public Long getMJsid() {
		return this.MJsid;
	}

	public void setMJsid(Long MJsid) {
		this.MJsid = MJsid;
	}

	public String getMZhanghao() {
		return this.MZhanghao;
	}

	public void setMZhanghao(String MZhanghao) {
		this.MZhanghao = MZhanghao;
	}

	public String getMName() {
		return this.MName;
	}

	public void setMName(String MName) {
		this.MName = MName;
	}

	public String getMTouxiang() {
		return this.MTouxiang;
	}

	public void setMTouxiang(String MTouxiang) {
		this.MTouxiang = MTouxiang;
	}

	public Long getMStatu() {
		return this.MStatu;
	}

	public void setMStatu(Long MStatu) {
		this.MStatu = MStatu;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}