package com.ht.yfbc.service;

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
public interface ReceivingService {
	public Map<String, Object> selReceiving(Integer cpage,String whid,Integer unit,String sku);
	public Map<String, Object> selReceiving2(Integer cpage,String whid,Integer unit,String sku);
	public int addReceiving(Receiving receiving);

}
