package com.ht.service;


import java.util.List;
import java.util.Map;

import com.ht.pojo.Rengzheng;
import com.ht.pojo.Rengzheng2;

public interface RengzhengService {
	public void insert(Rengzheng ren);
	
	public List<Rengzheng> sel(String userid);
	

	public List<Rengzheng2> selAll();
	
	public Rengzheng selone(String userid,String rtype);
	
	public void deleteone(String userid,String rtype);
	
	public void updatexyed(Integer xyed,String userid,String rtype);
}
