package com.ht.yfbc.service;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Cars_info;

public interface Cars_infoService {

	public List<Cars_info> selCars_info(); 
	
	public int addCars_info(Cars_info cars_info);
	public int delcars(String id);
	public List<Cars_info> selCars_infobywhid(String warehouseid);
	/**
	 * 分页查询
	 * @param map
	 * @return List
	 */
	public List<Cars_info> selCars_infoPage(Map<String, Object> map); 
	public int selCount();
	
	public String selCars_infoNameById(String id);
	
	/**
	 * 修改车辆信息表
	 * @param cars_info 车辆信息表对象
	 * @return
	 */
	public int updCars_info(Cars_info cars_info);
	public Cars_info selCars_infobyid(String id);
}
