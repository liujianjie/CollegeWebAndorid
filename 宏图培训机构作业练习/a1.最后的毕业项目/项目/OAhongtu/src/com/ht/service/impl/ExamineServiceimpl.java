package com.ht.service.impl;

import java.util.List;

import com.ht.common.Hibernate_Dao;
import com.ht.service.IExamineService;
import com.ht.vo.Holday;
import com.ht.vo.Jiaban;
import com.ht.vo.Kaoqin;
import com.ht.vo.Zhiban;

public class ExamineServiceimpl extends Hibernate_Dao implements IExamineService{

	public List listkao() {
		// TODO Auto-generated method stub
		return list("from Kaoqin");
	}

	public List toaddkao() {
		// TODO Auto-generated method stub
		return list("from Deptmans");
	}
	
	public boolean addkao(Kaoqin kao) {
		// TODO Auto-generated method stub
		return addObj(kao);
	}

	public List hollist() {
		// TODO Auto-generated method stub
		return list("from Holday");
	}

	public boolean holadd(Holday hol) {
		// TODO Auto-generated method stub
		return addObj(hol);
	}

	public Holday gethol(long id) {
		// TODO Auto-generated method stub
		return (Holday)getObj(Holday.class, id);
	}

	public boolean holdel(Holday hol) {
		// TODO Auto-generated method stub
		return delObj(hol);
	}

	public boolean holupd(Holday hol) {
		// TODO Auto-generated method stub
		return updObj(hol);
	}

	public boolean toupload(long id) { 
		// TODO Auto-generated method stub
		return executesql("update holday set hstatu="+S_STATE_1+" where hid="+id);
	}

	public boolean jiaadd(Jiaban jia) {
		// TODO Auto-generated method stub
		return addObj(jia);
	}

	public List jialist() {
		// TODO Auto-generated method stub
		return list("from Jiaban");
	}

	public Jiaban getjia(long id) {
		// TODO Auto-generated method stub
		return (Jiaban)getObj(Jiaban.class, id);
	}

	public boolean jiadel(Jiaban jia) {
		// TODO Auto-generated method stub
		return delObj(jia); 
	}  

	public boolean jiaupd(Jiaban jia) {
		return updObj(jia);
	}

	public boolean toupdstatu(long id) {
		// TODO Auto-generated method stub
		return executesql("update jiaban set jstatu="+S_STATE_1+" where jid="+id);
	}

	public List zhibanlist() {
		// TODO Auto-generated method stub
		return list("from Zhiban");
	}

	public List myjiaban(long eid) {
		// TODO Auto-generated method stub
		return listbysql("select * from jiaban where eid="+eid+" or jman="+eid);
	}

	//查询值班单条记录
	public Zhiban selZhibanById(Long id) {
		// TODO Auto-generated method stub
		return (Zhiban)getObj(Zhiban.class, id);
	}

	//修改值班
	public boolean updZhiban(Zhiban zh) {
		// TODO Auto-generated method stub
		return updObj(zh);
	}

	public List mylistkao(String ename) {
		// TODO Auto-generated method stub
		return listbysql("select * from kaoqin where ename='"+ename+"'");
	}

	public List myhollist(long id) {
		// TODO Auto-generated method stub
		return listbysql("select * from holday where eid="+id+" or holman="+id);
	}

	public List deptman() {
		// TODO Auto-generated method stub
		return listbysql("select * from Deptmans");
	}

	public boolean toupdstatuNO(long id) {
		// TODO Auto-generated method stub
		return executesql("update jiaban set jstatu="+S_STATE_3+" where jid="+id);
	}

	public boolean toupdstatuYES(long id) {
		// TODO Auto-generated method stub
		return executesql("update jiaban set jstatu="+S_STATE_2+" where jid="+id);
	}

	public boolean toupdjman(long jid,long sid) {
		// TODO Auto-generated method stub
		return executesql("update jiaban set jman="+jid+" where jid="+sid);
	}

	public boolean toupdNO(long id) {
		// TODO Auto-generated method stub
		return executesql("update holday set hstatu="+S_STATE_3+" where hid="+id);
	}

	public boolean toupdYES(long id) {
		// TODO Auto-generated method stub
		return executesql("update holday set hstatu="+S_STATE_2+" where hid="+id);
	}

	public boolean toupdholman(long hmid, long hid) {
		// TODO Auto-generated method stub
		return executesql("update holday set holman="+hmid+" where hid="+hid);
	}

	public boolean toupdhday(long eid, long hday) {
		// TODO Auto-generated method stub
		return executesql("update emp set eday=(eday-"+hday+") where eid="+eid);
	}

	public boolean toupdaddhday(long eid, long jday) {
		// TODO Auto-generated method stub
		return executesql("update emp set eday=(eday+"+jday+") where eid="+eid);
	}
	
}
