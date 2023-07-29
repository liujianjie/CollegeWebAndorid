package com.ht.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ht.common.Hibernate_Dao;
import com.ht.service.ITongZhiService;
import com.ht.vo6.Msg;

public class TongZhiServiceImpl extends Hibernate_Dao implements ITongZhiService{
	//��ѯԱ��֪ͨ
	public List TongZhilist1() {
		// TODO Auto-generated method stub
		return listbysql("select * from msg where msgface="+1);
	}
	//��ѯѧ��֪ͨ
	public List TongZhilist2() {
		// TODO Auto-generated method stub
		return listbysql("select * from msg where msgface="+2);
	}

	public boolean TongZhidel(Msg msgid) {
		// TODO Auto-generated method stub
		return delObj(msgid);
	}
	
	//��ѯ����Ա��
	public List findAllEmp() {
		// TODO Auto-generated method stub
		System.out.println("����ʵ����");
		return listbysql("select e.eid,e.ename from emp e");
	}
	//��ӹ���
	public boolean TongZhiadd(Msg msg) {
		// TODO Auto-generated method stub
		System.out.println("4444");
		return addObj(msg);
	}
	
	//��ѯ��������
	public Msg getMsgById(int id) {
		// TODO Auto-generated method stub
		return (Msg)getObj(Msg.class, id);
	}

	public boolean delte(Msg id) {
		// TODO Auto-generated method stub
		return delObj(id);
	}

	public boolean tongzhiget(Msg id) {
		// TODO Auto-generated method stub
		return updObj(id);
	}

	public boolean upd(Msg msg) {
		// TODO Auto-generated method stub
		return updObj(msg);
	}

	public List xq(Msg msg) {
		// TODO Auto-generated method stub
		return list("from msg");
	}

	//��ѯδ��������
	public List release() {
		// TODO Auto-generated method stub
		//0 δ����   1�ѷ���
		return listbysql("select * from msg where msgstatus="+0);
	}
	
	////���ķ���״̬
	public boolean updStatus(int id) {
		// TODO Auto-generated method stub
		return executesql("update msg set msgstatus=1 where msgid="+id);
	}
	
	//���淢��ʱ��
	public boolean saveFabuTime(int id, String  t) {
		// TODO Auto-generated method stub
		String sql="update msg set fabutime='"+t+"' where msgid='"+id+"' ";
		
		return executesql(sql);
	}
	//ɾ��֪ͨ
	public boolean delTongzhi(Msg m) {
		// TODO Auto-generated method stub
		return delObj(m);
	}
	//�޸�֪ͨ
	public boolean updTongzhi(Msg m) {
		// TODO Auto-generated method stub
		return upd(m);
	}
	
	//��֪ͨ����
	public List selTongzhiType(int id){
		System.out.println("come here");
		return listbysql("select msgface from msg where msgid="+id);
	}
	
	//��ѯ�ѷ���Ա��֪ͨ
	public List TongZhilist3(){
		return listbysql("select * from msg where msgface=1 and msgstatus=1");
	}
	//��ѯ�ѷ���ѧ��֪ͨ
	public List TongZhilist4(){
		return listbysql("select * from msg where msgface=2 and msgstatus=1");
	}
	
	//g���ķ�����
	public boolean upd_faburen(int id, String fuburen) {
		// TODO Auto-generated method stub
		return executesql("update msg set faburen='"+fuburen+"' where msgid="+id);
	}
	
	
}
