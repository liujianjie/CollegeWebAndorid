package com.ht.service;

import java.util.List;
import java.util.Map;

import com.ht.bean.AirQualityBean;

public interface AirQualityI {
	//全部数量
	public int selcount();
	
	//全部
	public List<AirQualityBean> selairlist(Map<String,Object> map);
	//部分
	public List<AirQualityBean> selairlistofdid(Map<String,Object> map);
	public int selcountofid(Integer id);
	//添加
	public int addair(AirQualityBean air);
	//详情
	public AirQualityBean airxq(Integer id);
	public int alertair(AirQualityBean airs);
	//删除
	public int delair(Integer id);
}
