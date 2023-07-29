package com.ht.yfbc.service;


import java.util.List;
import java.util.Map;
import java.util.Map;

import com.ht.yfbc.pojo.Warehouse;
import com.ht.yfbc.pojo.Warehouse2;


public interface WarehouseService {
	
	public Map<String, Object> selWarehouse(Integer curr);
	
	public int addWarehouse(Warehouse war);
	
	public int delwar(String whid);
	
	public Warehouse2 selWarById(String whid);
	
	public int update(Warehouse war);
	
	public List<Warehouse2>  selWarehouseAll();
	
	public String selWarehouseNameById(String whid);
	
	public Warehouse2 selWarByUserId2(String userid);
}
