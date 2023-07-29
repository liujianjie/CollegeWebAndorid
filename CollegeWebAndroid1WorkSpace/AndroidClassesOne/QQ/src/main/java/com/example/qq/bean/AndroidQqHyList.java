package com.example.qq.bean;

import java.util.List;

/**
 * AndroidQqUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AndroidQqHyList  {
	private int result;
	private List<AndroidQqHy> qqhy;
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public AndroidQqHyList(int result,
			List<AndroidQqHy> qqhy) {
		super();
		this.result = result;
		this.qqhy = qqhy;
	}
	public List<AndroidQqHy> getQqhy() {
		return qqhy;
	}
	public void setQqhy(List<AndroidQqHy> qqhy) {
		this.qqhy = qqhy;
	}

}