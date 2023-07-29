package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Cars_attendance;
import com.ht.yfbc.pojo.Cars_distribution;
import com.ht.yfbc.pojo.Users;


/**
 * @author hjx
 * 车辆出勤表数据库操作
 */
public interface Cars_attendanceDao {

	/**查询车辆出勤表*/
	public List<Cars_attendance> selCars_att(); 
	/**
	 * 分页查询
	 * @param map
	 * @return List
	 */
	public List<Cars_attendance> selCars_attPage(Map<String, Object> map); 
	public int selCount();
	/**添加车辆出勤表*/
	public int addCars_att(Cars_attendance cars_att);
	/**删除车辆出勤表*/	
	public int delcars_att(String id);
	/**
	 * 根据车id查询司机信息
	 * @param carid 车辆id
	 * @return Users 用户
	 */
	public Users selUsersByCarId(String carid);
	
	/**
	 * 修改车辆出勤表
	 * @param cars_att 车辆出勤表对象
	 * @return
	 */
	public int updCars_att(Cars_attendance cars_att);
	/**根据 id 查询
	 * @param id 出勤表id
	 * @return
	 */
	public Cars_attendance selCars_attbyid(String id);
}
