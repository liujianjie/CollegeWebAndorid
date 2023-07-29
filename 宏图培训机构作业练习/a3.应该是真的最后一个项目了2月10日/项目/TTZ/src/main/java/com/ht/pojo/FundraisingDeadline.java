package com.ht.pojo;

import java.io.Serializable;

public class FundraisingDeadline implements Serializable {

	private String fid;
	private String jiekuantime;// 借款期限
	private String choukuantime;// 筹款期限

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getJiekuantime() {
		return jiekuantime;
	}

	public void setJiekuantime(String jiekuantime) {
		this.jiekuantime = jiekuantime;
	}

	public String getChoukuantime() {
		return choukuantime;
	}

	public void setChoukuantime(String choukuantime) {
		this.choukuantime = choukuantime;
	}

	public FundraisingDeadline() {
	}

	public FundraisingDeadline(String fid, String jiekuantime, String choukuantime) {
		this.fid = fid;
		this.jiekuantime = jiekuantime;
		this.choukuantime = choukuantime;
	}

}