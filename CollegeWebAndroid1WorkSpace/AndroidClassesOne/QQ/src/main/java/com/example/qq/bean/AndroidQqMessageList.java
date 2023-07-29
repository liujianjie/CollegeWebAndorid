package com.example.qq.bean;

import java.util.List;

/**
 * AndroidQqDynamic entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AndroidQqMessageList implements java.io.Serializable {

	private int result;
	private List<AndroidQqMessage> msg;
	
	public AndroidQqMessageList(int result, List<AndroidQqMessage> msg) {
		super();
		this.result = result;
		this.msg = msg;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public List<AndroidQqMessage> getMsg() {
		return msg;
	}
	public void setMsg(List<AndroidQqMessage> msg) {
		this.msg = msg;
	}
	
}