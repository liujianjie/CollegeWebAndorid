package com.ht.service;

import java.util.List;

import com.ht.bean.Dept;
import com.ht.bean.Informations;

public interface InformationsI {
	//查询列表
	public List<Informations> selinforlist();
	//获取一个资讯
	public Informations getinfor(Long id);
	//修改一个资讯的信息
	public boolean alertinfor(Informations infor);
	
	public List<Dept> seldept();
}
