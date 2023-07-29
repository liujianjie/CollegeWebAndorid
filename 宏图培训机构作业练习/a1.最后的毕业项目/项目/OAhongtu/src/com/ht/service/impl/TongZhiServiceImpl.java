package com.ht.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ht.common.Hibernate_Dao;
import com.ht.service.ITongZhiService;
import com.ht.vo6.Msg;

public class TongZhiServiceImpl extends Hibernate_Dao implements ITongZhiService{
	//查询员工通知
	public List TongZhilist1() {
		// TODO Auto-generated method stub
		return listbysql("select * from msg where msgface="+1);
	}
	//查询学生通知
	public List TongZhilist2() {
		// TODO Auto-generated method stub
		return listbysql("select * from msg where msgface="+2);
	}

	public boolean TongZhidel(Msg msgid) {
		// TODO Auto-generated method stub
		return delObj(msgid);
	}
	
	//查询所有员工
	public List findAllEmp() {
		// TODO Auto-generated method stub
		System.out.println("进来实现类");
		return listbysql("select e.eid,e.ename from emp e");
	}
	//添加公告
	public boolean TongZhiadd(Msg msg) {
		// TODO Auto-generated method stub
		System.out.println("4444");
		return addObj(msg);
	}
	
	//查询单个对象
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

	//查询未发布公告
	public List release() {
		// TODO Auto-generated method stub
		//0 未发布   1已发布
		return listbysql("select * from msg where msgstatus="+0);
	}
	
	////更改发布状态
	public boolean updStatus(int id) {
		// TODO Auto-generated method stub
		return executesql("update msg set msgstatus=1 where msgid="+id);
	}
	
	//保存发布时间
	public boolean saveFabuTime(int id, String  t) {
		// TODO Auto-generated method stub
		String sql="update msg set fabutime='"+t+"' where msgid='"+id+"' ";
		
		return executesql(sql);
	}
	//删除通知
	public boolean delTongzhi(Msg m) {
		// TODO Auto-generated method stub
		return delObj(m);
	}
	//修改通知
	public boolean updTongzhi(Msg m) {
		// TODO Auto-generated method stub
		return upd(m);
	}
	
	//查通知类型
	public List selTongzhiType(int id){
		System.out.println("come here");
		return listbysql("select msgface from msg where msgid="+id);
	}
	
	//查询已发布员工通知
	public List TongZhilist3(){
		return listbysql("select * from msg where msgface=1 and msgstatus=1");
	}
	//查询已发布学生通知
	public List TongZhilist4(){
		return listbysql("select * from msg where msgface=2 and msgstatus=1");
	}
	
	//g更改发布人
	public boolean upd_faburen(int id, String fuburen) {
		// TODO Auto-generated method stub
		return executesql("update msg set faburen='"+fuburen+"' where msgid="+id);
	}
	
	
}
