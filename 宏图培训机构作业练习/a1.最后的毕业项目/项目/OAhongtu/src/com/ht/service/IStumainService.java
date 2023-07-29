package com.ht.service;

import java.io.Serializable;
import java.util.List;

import com.ht.vo5.Sback;
import com.ht.vo6.Msg;

public interface IStumainService {
	public List zhibanlist();
	public List lianxilist();
	//值班分页
	public List zhibanlistpage(int start, int pageCount);
	//控制通知
	public List tongzhilistpage(int start, int pageCount);
	//控制意见
	public List yijianlistpage(int start, int pageCount);
	//控制联系电话 
	public List lianxilistpage(int start, int pageCount);
	public Sback getsbk(Serializable id);
	//更多公告详细
	//查询单个对象
	public Msg getMsgById(int id) ;
}
