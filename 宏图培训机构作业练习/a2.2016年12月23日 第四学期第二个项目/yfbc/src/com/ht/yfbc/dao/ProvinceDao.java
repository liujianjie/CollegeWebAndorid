package com.ht.yfbc.dao;

import java.util.List;


import com.ht.yfbc.pojo.Province;

/**
 * 省份数据库操作(province)
 * day 2016-12-27
 * @author 魏海明
 *
 */
public interface ProvinceDao {
	public List<Province> selProvince();
	
	public String selProvinceNameById(Integer provinceid);
}
