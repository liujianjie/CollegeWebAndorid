package com.ht.yfbc.service;

import java.util.List;

import com.ht.yfbc.pojo.City;

public interface CityService {
	public List<City> selbypid(Integer  province);
	public String selcityNameById(Integer id);
}
