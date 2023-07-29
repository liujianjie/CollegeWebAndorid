package com.ht.yfbc.dao;
import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Cars_info;
/**
 * @author hjx
 * 车辆信息表数据库操作
 */
public interface Cars_infoDao {

	/**查询车辆信息表*/
	public List<Cars_info> selCars_info(); 
	/**
	 * 分页查询
	 * @param map
	 * @return List
	 */
	public List<Cars_info> selCars_infoPage(Map<String, Object> map); 
	public int selCount();
	/**添加车辆信息表*/
	public int addCars_info(Cars_info cars_info);
	/**删除车辆信息表*/	
	public int delcars(String id);
	/**
	 * 根据id查询车辆信息全部
	 * @param id 仓库表id
	 * @return
	 */
	public List<Cars_info> selCars_infobywhid(String warehouseid);
	
	/**
	 * 根据id查询名字
	 * @param id 车辆信息表id
	 * @return
	 */
	public String selCars_infoNameById(String id);
	
	/**
	 * 修改车辆信息表
	 * @param cars_info 车辆信息表对象
	 * @return
	 */
	public int updCars_info(Cars_info cars_info);
	public Cars_info selCars_infobyid(String id);
	
	//1月13日空闲状态 和 仓库id 为条件搜索
	public List<Cars_info> selCars_infobywhidandstate(String warehouseid);
	
}
