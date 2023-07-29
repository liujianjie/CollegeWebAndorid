package com.example.qq_lxr9y18r.bean;

import java.util.List;

/**
 * AndroidQqDynamic entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AndroidQqShowMessageList implements java.io.Serializable {

	private int result;
	private List<AndroidQqShowMessage> showmsg;
	
	public AndroidQqShowMessageList(int result, List<AndroidQqShowMessage> msg) {
		super();
		this.result = result;
		this.showmsg = msg;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public List<AndroidQqShowMessage> getMsg() {
		return showmsg;
	}
	public void setMsg(List<AndroidQqShowMessage> msg) {
		this.showmsg = msg;
	}
	
}