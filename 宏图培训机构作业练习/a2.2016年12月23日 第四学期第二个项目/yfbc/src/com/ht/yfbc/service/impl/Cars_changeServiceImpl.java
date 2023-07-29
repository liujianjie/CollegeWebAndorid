package com.ht.yfbc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.Cars_changeDao;
import com.ht.yfbc.pojo.Cars_change;
import com.ht.yfbc.service.Cars_changeService;
@Service
public class Cars_changeServiceImpl implements Cars_changeService {

	@Resource
	private Cars_changeDao cars_changeDao;
	
	
	@Override
	public List<Cars_change> selCars_change() {
		
		return cars_changeDao.selCars_change();
	}


	@Override
	public int delCars_change(String id) {
		int i = cars_changeDao.delCars_change(id);
		return i;
	}


	@Override
	public int addCars_change(Cars_change cars_change) {
		int i = cars_changeDao.addCars_change(cars_change);
		return i;
	}


	@Override
	public List<Cars_change> selCars_changePage(Map<String, Object> map) {
		
		return cars_changeDao.selCars_changePage(map);
	}


	@Override
	public int selCount() {
		return cars_changeDao.selCount();
	}

}
