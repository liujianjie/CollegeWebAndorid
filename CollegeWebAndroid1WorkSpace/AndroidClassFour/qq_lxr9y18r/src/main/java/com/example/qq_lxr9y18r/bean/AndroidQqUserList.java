package com.example.qq_lxr9y18r.bean;

import java.util.List;

/**
 * AndroidQqUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AndroidQqUserList implements java.io.Serializable {
	private int result;
	private List<AndroidQqUser> qquser;
	
	public AndroidQqUserList(int result, List<AndroidQqUser> qquser) {
		super();
		this.result = result;
		this.qquser = qquser;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public List<AndroidQqUser> getQquser() {
		return qquser;
	}
	public void setQquser(List<AndroidQqUser> qquser) {
		this.qquser = qquser;
	}
}