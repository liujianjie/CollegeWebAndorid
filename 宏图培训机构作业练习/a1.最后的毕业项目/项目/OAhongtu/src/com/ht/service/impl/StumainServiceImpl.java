package com.ht.service.impl;

import java.io.Serializable;
import java.util.List;

import com.ht.common.Hibernate_Dao;
import com.ht.service.IStumainService;
import com.ht.vo5.Sback;
import com.ht.vo6.Msg;

public class StumainServiceImpl extends Hibernate_Dao implements IStumainService{
	//ֵ��
	public List zhibanlist() {
		// TODO Auto-generated method stub
		return list("from Zhiban");
	}
	public List zhibanlistpage(int start, int pageCount) {
		return pagelistByhql("from Zhiban", start, pageCount);
	}

	//��ѯѧ��֪ͨ
	public List TongZhilist2() {
		// TODO Auto-generated method stub
		return listbysql("select * from msg where msgface="+2+" order by msgid desc");
	}
	public List tongzhilistpage(int start, int pageCount){
		return pagelistbysql("select * from msg where msgface=2 and msgstatus=1 order by msgid desc", start, pageCount);
	}
	
	//�������
	public List selallsbklist(){
		return listbysql("select s.*,t.intenname from sback s inner join student t on t.intenid=s.stdid where s.statu in(0,1) order by sbackid desc");
	}
	//�������
	public List yijianlistpage(int start, int pageCount){
		return pagelistbysql("select s.*,t.intenname from sback s inner join student t on t.intenid=s.stdid where s.statu in(0,1) order by sbackid desc",start,pageCount);
	}
	//������ϵ�绰 
	public List lianxilistpage(int start, int pageCount){
		return pagelistbysql("select ename,ephone from emp",start,pageCount);
	}
	public List lianxilist(){
		return listbysql("select ename,ephone from emp");
	}
	//��ѯ��������
	public Msg getMsgById(int id) {
		// TODO Auto-generated method stub
		return (Msg)getObj(Msg.class, id);
	}
	public Sback getsbk(Serializable id){
		return (Sback)getObj(Sback.class, id);
	}
}
