package com.ht.yfbc.service;

import java.util.List;

import com.ht.yfbc.pojo.Province;

public interface ProvinceService {
	public List<Province> selProvince();
	public String selProvinceNameById(Integer provinceid);
}
