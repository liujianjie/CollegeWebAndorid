package com.example.qq;

import java.util.List;

import com.example.qq.bean.AndroidQqDynamic;
import com.example.qq.bean.AndroidQqHy;
import com.example.qq.bean.AndroidQqMessage;
import com.example.qq.bean.AndroidQqUser;

import android.app.Application;

//���� msglist��Ϣ�б� �� qquser
public class Applications extends Application{
	//�û���Ϣ
	public static AndroidQqUser qqusers;
	
	//��Ϣ�б�
	public static List<AndroidQqMessage> msglist;
	
	//�����б� Ϊ�˲�ÿ�ζ����ʺ�̨
	public static List<AndroidQqHy> hylist;//�����б�
	
	//�������б�
	public static List<AndroidQqHy> newhylist;
	
	//���Ѷ�̬�б�
	public static List<AndroidQqDynamic> hydtlist;
	
	//id
	public static int needid;
	
	//����������Ϣ
	public static AndroidQqHy hyqquser;
	
	//��Ϣ����
	public static AndroidQqMessage msgxq;
	
	@Override
	public void onCreate() {
		// TODO �Զ����ɵķ������
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

