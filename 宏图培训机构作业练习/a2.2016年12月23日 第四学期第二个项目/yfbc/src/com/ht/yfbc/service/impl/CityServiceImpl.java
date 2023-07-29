package com.ht.yfbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.CityDao;
import com.ht.yfbc.pojo.City;
import com.ht.yfbc.service.CityService;

@Service
public class CityServiceImpl implements CityService{
	@Resource
	private CityDao cDao;
	@Override
	public List<City> selbypid(Integer province) {
		// TODO Auto-generated method stub
		return cDao.selcity(province);
	}
	public String selcityNameById(Integer id) {
		return cDao.selcityNameById(id);
	}

}
