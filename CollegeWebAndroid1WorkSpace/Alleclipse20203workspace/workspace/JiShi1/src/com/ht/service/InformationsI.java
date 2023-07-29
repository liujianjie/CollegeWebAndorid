package com.ht.service;

import java.util.List;
import java.util.Map;

import com.ht.bean.Informations;

public interface InformationsI {
	//查询列表
	public List<Informations> selinforlist();
	//获取一个资讯
	public Informations getinfor(Long id);
	//修改一个资讯的信息
	public int alertinfor(Map<String,Object> map);
	
}
