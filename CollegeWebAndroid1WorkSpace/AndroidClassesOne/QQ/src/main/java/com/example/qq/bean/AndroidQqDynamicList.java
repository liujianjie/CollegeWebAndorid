package com.example.qq.bean;

import java.util.List;

/**
 * AndroidQqDynamic entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AndroidQqDynamicList implements java.io.Serializable {

	private int result;
	private List<AndroidQqDynamic> qqdt;
	
	public AndroidQqDynamicList(int result, List<AndroidQqDynamic> qqdt) {
		super();
		this.result = result;
		this.qqdt = qqdt;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public List<AndroidQqDynamic> getQqdt() {
		return qqdt;
	}
	public void setQqdt(List<AndroidQqDynamic> qqdt) {
		this.qqdt = qqdt;
	}
	
}