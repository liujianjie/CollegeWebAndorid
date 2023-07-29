package com.ht.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ht.vo6.Msg;

public interface ITongZhiService {
	//查询员工通知
	public List TongZhilist1();
	//查学生通知
	public List TongZhilist2();
	//查询已发布员工通知
	public List TongZhilist3();
	//查询已发布学生通知
	public List TongZhilist4();
	
	
	public boolean TongZhidel(Msg msgid);
	public Msg getMsgById(int id);
	//查询所有员工
	public List findAllEmp();
	//添加公告
	public boolean TongZhiadd(Msg msg);
	
	public boolean delte(Msg id);
	public boolean tongzhiget(Msg id);
	public boolean upd(Msg msg);
	public List xq(Msg msg);
	public List release();
	//更改发布状态
	public boolean updStatus(int id);
	//保存发布时间
	public boolean saveFabuTime(int id,String t);
	//删除通知;
	public boolean delTongzhi(Msg m);
	//修改通知
	public boolean updTongzhi(Msg m);
	//查通知类型
	public List selTongzhiType(int id);
	
	//g更改发布人
	public boolean upd_faburen(int id,String fuburen);
	
} 
