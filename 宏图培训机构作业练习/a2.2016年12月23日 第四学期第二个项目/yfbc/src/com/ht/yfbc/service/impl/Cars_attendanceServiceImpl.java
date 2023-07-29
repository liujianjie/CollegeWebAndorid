package com.ht.yfbc.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.Cars_attendanceDao;
import com.ht.yfbc.pojo.Cars_attendance;
import com.ht.yfbc.pojo.Users;
import com.ht.yfbc.service.Cars_attendanceService;
@Service
public class Cars_attendanceServiceImpl implements Cars_attendanceService {

	@Resource
	private Cars_attendanceDao cars_attDao;
	
	@Override
	public List<Cars_attendance> selCars_att() {
		
		return cars_attDao.selCars_att();
	}

	@Override
	public int addCars_att(Cars_attendance cars_att) {
		
		int i = cars_attDao.addCars_att(cars_att);
		return i;
	}

	@Override
	public int delcars_att(String id) {
		int i = cars_attDao.delcars_att(id);
		return i;
	}

	@Override
	public Users selUsersByCarId(String carid) {
		return cars_attDao.selUsersByCarId(carid);
	}

	@Override
	public List<Cars_attendance> selCars_attPage(Map<String, Object> map) {
		
		return cars_attDao.selCars_attPage(map);
	}

	@Override
	public int selCount() {
		return cars_attDao.selCount();
	}

	@Override
	public int updCars_att(Cars_attendance cars_att) {
		return cars_attDao.updCars_att(cars_att);
	}

	@Override
	public Cars_attendance selCars_attbyid(String id) {
		return cars_attDao.selCars_attbyid(id);
	}

}
