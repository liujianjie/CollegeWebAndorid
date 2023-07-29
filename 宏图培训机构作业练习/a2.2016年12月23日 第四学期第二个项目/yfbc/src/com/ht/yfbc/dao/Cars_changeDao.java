package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Cars_attendance;
import com.ht.yfbc.pojo.Cars_change;
import com.ht.yfbc.pojo.Cars_distribution;
import com.ht.yfbc.pojo.Users;


/**
 * @author hjx
 * 车辆变更表数据库操作
 */
public interface Cars_changeDao {

	/**查询车辆变更表*/
	public List<Cars_change> selCars_change(); 
	/**
	 * 分页查询
	 * @param map
	 * @return List
	 */
	public List<Cars_change> selCars_changePage(Map<String, Object> map); 
	public int selCount();
	/**添加车辆变更表*/
	public int addCars_change(Cars_change cars_change);
	/**删除车辆变更表
	 * */	
	public int delCars_change(String id);
}
