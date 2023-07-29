package com.ht.yfbc.dao;

import java.util.List;
/**
 * 
 * 城市数据库操作(city)
 * day 2016-12-27
 * @author 魏海明
 *
 */

import com.ht.yfbc.pojo.City;
public interface CityDao {
	
	public List<City> selcity(Integer provinceid);
	
	public String selcityNameById(Integer id);
}
