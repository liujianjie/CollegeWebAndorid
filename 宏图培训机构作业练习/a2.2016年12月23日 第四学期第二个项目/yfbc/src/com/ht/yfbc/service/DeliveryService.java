package com.ht.yfbc.service;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Delivery;

public interface DeliveryService {
	public int insert(Delivery deli);
	
	public List<Delivery> seldeAll();
	
	public List<Delivery> seldeAll2(String whid);
	
	public Map<String, Object> seldeBypage(Integer curr);
	
	public Map<String, Object> seldeBypage2(Integer curr,String whid);
	
	public int updateStaut(String deid);
}
