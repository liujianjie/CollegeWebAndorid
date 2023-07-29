package com.ht.yfbc.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.ProvinceDao;
import com.ht.yfbc.pojo.Province;
import com.ht.yfbc.service.ProvinceService;

/**
 * 省份业务层
 * day 2016-12-27
 * @author 魏海明
 *
 */
@Service
public class ProvinceServiceImpl implements ProvinceService{
	@Resource
	private ProvinceDao pDao;

	public List<Province> selProvince() {
		// TODO Auto-generated method stub
		List<Province> list = pDao.selProvince();
		return list;
	}

	public String selProvinceNameById(Integer provinceid) {
		return pDao.selProvinceNameById(provinceid);
	}

}
