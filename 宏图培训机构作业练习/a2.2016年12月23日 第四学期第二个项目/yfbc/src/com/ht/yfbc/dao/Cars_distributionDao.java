package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;


import com.ht.yfbc.pojo.Cars_distribution;
import com.ht.yfbc.pojo.Cars_info;





/**
 * @author hjx
 * 车辆分配表数据库操作
 */
public interface Cars_distributionDao {

	/**查询车辆分配表*/
	public List<Cars_distribution> selCars_dis(); 
	/**
	 * 分页查询
	 * @param map
	 * @return List
	 */
	public List<Cars_distribution> selCars_disPage(Map<String, Object> map); 
	public int selCount();
	/**添加车辆分配表*/
	public int addCars_dis(Cars_distribution cars_dis);
	/**删除车辆分配表*/	
	public int delcars_dis(String id);
	
	/**
	 * 根据userid查询
	 * @param userid 用户id
	 * @return
	 */
	public List<Cars_distribution> selCars_disbyuserid(String userid);
	/**根据仓库id查询*/
	public List<Cars_distribution> selCars_distributionByWhid(String warehouseid);
	
	/**
	 * 修改车辆分配表
	 * @param cars_dis 车辆分配表对象
	 * @return
	 */
	public int updCars_dis(Cars_distribution cars_dis);
	/**根据 id 查询
	 * @param id 分配表id
	 * @return
	 */
	public Cars_distribution selCars_disbyid(String id);
}
