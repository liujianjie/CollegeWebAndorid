package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Delivery;

public interface DeliveryDao {
	public int insert(Delivery deli);
	
	public List<Delivery> seldeAll();
	
	public List<Delivery> seldeAll2(String whid);
	
	public List<Delivery> seldeBypage(Map<String, Object> map);
	
	public List<Delivery> seldeBypage2(Map<String, Object> map);
	
	public int updateStatu(String deid);
}
