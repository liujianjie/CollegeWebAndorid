package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Warehouse;
import com.ht.yfbc.pojo.Warehouse2;
/**
 * 仓库表数据库操作
 * Day 2016-12-27 
 * @author 魏海明
 *
 */
public interface WarehouseDao {
	public List<Warehouse2> selWarehouse(Map<String, Object> map);
	
	public int addWarehouse(Warehouse war);
	
	public Warehouse2 selWarById(String whid);
	
	public List<Warehouse2>  selWarehouseAll();
	
	public int delwar(String whid);
	
	public int update(Warehouse war);
	
	public Warehouse2 selWarByUserId2(String userid);
	//查询用户的仓库
	public Warehouse selWarByUserId(String userid);
	public String selWarehouseNameById(String whid);
}
