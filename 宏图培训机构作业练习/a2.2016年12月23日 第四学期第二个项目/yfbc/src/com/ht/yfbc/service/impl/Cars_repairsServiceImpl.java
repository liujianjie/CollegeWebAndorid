package com.ht.yfbc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.Cars_repairsDao;
import com.ht.yfbc.pojo.Cars_repairs;
import com.ht.yfbc.service.Cars_repairsService;

@Service
public class Cars_repairsServiceImpl implements Cars_repairsService {

	@Resource
	private Cars_repairsDao cars_repDao;
	
	public List<Cars_repairs> selCars_rep() {
		return cars_repDao.selCars_rep();
	}

	@Override
	public List<Cars_repairs> selCars_repPage(Map<String, Object> map) {
		
		return cars_repDao.selCars_repPage(map);
	}

	@Override
	public int selCount() {
		return cars_repDao.selCount();
	}

	@Override
	public int addCars_rep(Cars_repairs cars_rep) {
		int i = cars_repDao.addCars_rep(cars_rep);
		return i;
	}

	@Override
	public int delCars_rep(String id) {
		int i = cars_repDao.delCars_rep(id);
		return i;
	}

	@Override
	public int updCars_rep(Cars_repairs cars_rep) {
		return cars_repDao.updCars_rep(cars_rep);
	}

	@Override
	public Cars_repairs selCars_repbyid(String id) {
		return cars_repDao.selCars_repbyid(id);
	}

}
