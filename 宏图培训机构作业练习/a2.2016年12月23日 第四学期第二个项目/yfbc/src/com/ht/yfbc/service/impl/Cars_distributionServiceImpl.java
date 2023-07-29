package com.ht.yfbc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.Cars_distributionDao;
import com.ht.yfbc.pojo.Cars_distribution;
import com.ht.yfbc.service.Cars_distributionService;
@Service
public class Cars_distributionServiceImpl implements Cars_distributionService {

	@Resource
	private Cars_distributionDao cars_disDao;
	public List<Cars_distribution> selCars_dis() {
		
		return cars_disDao.selCars_dis();
	}

	@Override
	public int addCars_dis(Cars_distribution cars_dis) {
		int i = cars_disDao.addCars_dis(cars_dis);
		return i;
	}

	@Override
	public int delcars_dis(String id) {
		int i = cars_disDao.delcars_dis(id);
		return i;
	}

	@Override
	public List<Cars_distribution> selCars_disbyuserid(String userid) {
		return cars_disDao.selCars_disbyuserid(userid);
	}

	@Override
	public List<Cars_distribution> selCars_distributionByWhid(String warehouseid) {
		
		return cars_disDao.selCars_distributionByWhid(warehouseid);
	}

	@Override
	public List<Cars_distribution> selCars_disPage(Map<String, Object> map) {
		
		return cars_disDao.selCars_disPage(map);
	}

	@Override
	public int selCount() {
		
		return cars_disDao.selCount();
	}

	@Override
	public int updCars_dis(Cars_distribution cars_dis) {
		return cars_disDao.updCars_dis(cars_dis);
	}

	@Override
	public Cars_distribution selCars_disbyid(String id) {
		return cars_disDao.selCars_disbyid(id);
	}

}
