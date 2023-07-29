package com.ht.service;

import java.util.List;
import java.util.Map;

import com.ht.bean.Informations;

public interface InformationsI {
	//查询列表
	public List<Informations> selinforlist();
	//获取一个资讯
	public Informations getinfor(Long id);

}
