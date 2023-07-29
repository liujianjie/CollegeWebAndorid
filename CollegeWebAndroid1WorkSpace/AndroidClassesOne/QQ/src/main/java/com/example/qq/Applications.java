package com.example.qq;

import java.util.List;

import com.example.qq.bean.AndroidQqDynamic;
import com.example.qq.bean.AndroidQqHy;
import com.example.qq.bean.AndroidQqMessage;
import com.example.qq.bean.AndroidQqUser;

import android.app.Application;

//放入 msglist消息列表 和 qquser
public class Applications extends Application{
	//用户信息
	public static AndroidQqUser qqusers;
	
	//消息列表
	public static List<AndroidQqMessage> msglist;
	
	//好友列表 为了不每次都访问后台
	public static List<AndroidQqHy> hylist;//好友列表
	
	//新朋友列表
	public static List<AndroidQqHy> newhylist;
	
	//好友动态列表
	public static List<AndroidQqDynamic> hydtlist;
	
	//id
	public static int needid;
	
	//单个好友信息
	public static AndroidQqHy hyqquser;
	
	//消息详情
	public static AndroidQqMessage msgxq;
	
	@Override
	public void onCreate() {
		// TODO 自动生成的方法存根
		super.onCreate();
	}
	public static AndroidQqUser getqquser(){
		return qqusers;
	}
	public static void setQquser(AndroidQqUser qquser) {
		qqusers = qquser;
	}
	public static List<AndroidQqMessage> getMsgList(){
		return msglist;
	}
	public static void setMsgList(List<AndroidQqMessage> msglists) {
		msglist = msglists;
	}
	public static List<AndroidQqHy> getHyList(){
		return hylist;
	}
	public static void setHyList(List<AndroidQqHy> hylists) {
		hylist = hylists;
	}
	public static List<AndroidQqHy> getNewhylist() {
		return newhylist;
	}
	public static void setNewhylist(List<AndroidQqHy> newhylist) {
		Applications.newhylist = newhylist;
	}
	public static List<AndroidQqDynamic> getHydtlist() {
		return hydtlist;
	}
	public static void setHydtlist(List<AndroidQqDynamic> hydtlist) {
		Applications.hydtlist = hydtlist;
	}
	public static int getNeedid() {
		return needid;
	}
	public static void setNeedid(int needid) {
		Applications.needid = needid;
	}
	public static AndroidQqHy getHyqquser() {
		return hyqquser;
	}
	public static void setHyqquser(AndroidQqHy hyqquser) {
		Applications.hyqquser = hyqquser;
	}
	public static AndroidQqMessage getMsgxq() {
		return msgxq;
	}
	public static void setMsgxq(AndroidQqMessage msgxq) {
		Applications.msgxq = msgxq;
	}
	
}

