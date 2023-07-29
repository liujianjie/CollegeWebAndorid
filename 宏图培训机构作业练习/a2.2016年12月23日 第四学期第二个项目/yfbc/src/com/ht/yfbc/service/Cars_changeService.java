package com.ht.yfbc.service;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Cars_attendance;
import com.ht.yfbc.pojo.Cars_change;
import com.ht.yfbc.pojo.Users;


/**
 * @author hjx
 *
 */
public interface Cars_changeService {

	/**查询车辆变更表*/
	public List<Cars_change> selCars_change(); 
	/**添加车辆变更表*/
	public int addCars_change(Cars_change cars_change);
	/**删除车辆变更表
	 * */	
	public int delCars_change(String id);
	/**
	 * 分页查询
	 * @param map
	 * @return List
	 */
	public List<Cars_change> selCars_changePage(Map<String, Object> map); 
	public int selCount();
}
