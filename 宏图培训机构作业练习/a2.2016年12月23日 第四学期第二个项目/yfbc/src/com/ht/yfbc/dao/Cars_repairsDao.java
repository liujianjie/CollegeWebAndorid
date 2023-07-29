package com.ht.yfbc.dao;
import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Cars_repairs;
/**
 * @author hjx
 * 车辆报修表数据库操作
 */
public interface Cars_repairsDao {

	/**查询车辆报修表*/
	public List<Cars_repairs> selCars_rep(); 
	/**
	 * 分页查询
	 * @param map
	 * @return List
	 */
	public List<Cars_repairs> selCars_repPage(Map<String, Object> map); 
	public int selCount();
	/**添加车辆报修表*/
	public int addCars_rep(Cars_repairs cars_rep);
	/**删除车辆报修表*/	
	public int delCars_rep(String id);
	
	/**
	 * 修改车辆报修表
	 * @param cars_rep 车辆报修表对象
	 * @return
	 */
	public int updCars_rep(Cars_repairs cars_rep);
	public Cars_repairs selCars_repbyid(String id);
	

}
