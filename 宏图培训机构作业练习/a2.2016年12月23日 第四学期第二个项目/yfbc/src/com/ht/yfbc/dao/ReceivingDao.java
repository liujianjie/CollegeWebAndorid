package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Putaway;
import com.ht.yfbc.pojo.Receiving;

/**
 * 收货数据操作(receiving)
 * day 2016-12-29
 * @author 刘建杰
 *
 */
public interface ReceivingDao {
	public List<Receiving> selReceiving(Map<String, Object> map);
	public int addReceiving(Receiving receiving);
	
	//修改为已摆货状态
	public int updatePutstate(String reid);
	//查询大小
	public int selReceivingCount(Map<String, Object> map);
}
