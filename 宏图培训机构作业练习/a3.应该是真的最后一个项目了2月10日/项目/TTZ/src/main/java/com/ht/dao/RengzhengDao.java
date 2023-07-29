package com.ht.dao;

import java.util.List;
import java.util.Map;

import com.ht.pojo.Rengzheng;
import com.ht.pojo.Rengzheng2;

public interface RengzhengDao {
	public void insert(Rengzheng ren);
	
	public List<Rengzheng> sel(String userid);
	
	public List<Rengzheng2> selAll();
	
	public Rengzheng selone(Map<String, Object> map);
	
	public void deleteone(Map<String, Object> map);
	
	
	public void updatexyed(Map<String, Object> map);
}
