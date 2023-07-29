package com.ht.yfbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.Cars_diliverymanDao;
import com.ht.yfbc.pojo.Cars_diliveryman;
import com.ht.yfbc.service.Cars_diliverymanService;
@Service
public class Cars_diliverymanServiceImpl implements Cars_diliverymanService {
	@Resource
	private Cars_diliverymanDao cars_diliverymanDao; 
	public List<Cars_diliveryman> selCars_diliverymanByWhid(String warehouseid) {
		return cars_diliverymanDao.selCars_diliverymanByWhid(warehouseid);
	}

}
