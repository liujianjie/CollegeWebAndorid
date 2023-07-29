package com.ht.yfbc.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.Cars_infoDao;
import com.ht.yfbc.pojo.Cars_info;
import com.ht.yfbc.service.Cars_infoService;
@Service
public class Cars_infoServiceImpl implements Cars_infoService {

	@Resource
	private Cars_infoDao cars_infoDao;
	
	public List<Cars_info> selCars_info() {
		return cars_infoDao.selCars_info();
	}

	public int addCars_info(Cars_info cars_info) {
		int i = cars_infoDao.addCars_info(cars_info);
		return i;
	}

	@Override
	public int delcars(String id) {
		int i = cars_infoDao.delcars(id);
		return i;
	}

	@Override
	public List<Cars_info> selCars_infobywhid(String warehouseid) {
		return cars_infoDao.selCars_infobywhid(warehouseid);
	}

	@Override
	public List<Cars_info> selCars_infoPage(Map<String, Object> map) {
		
		return cars_infoDao.selCars_infoPage(map);
	}

	@Override
	public int selCount() {
		return cars_infoDao.selCount();
	}

	@Override
	public String selCars_infoNameById(String id) {
		return cars_infoDao.selCars_infoNameById(id);
	}

	@Override
	public int updCars_info(Cars_info cars_info) {
		return cars_infoDao.updCars_info(cars_info);
	}

	@Override
	public Cars_info selCars_infobyid(String id) {
		return cars_infoDao.selCars_infobyid(id);
	}

}
