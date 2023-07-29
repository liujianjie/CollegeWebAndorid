package com.ht.yfbc.dao;

import java.util.List;

import com.ht.yfbc.pojo.Cars_diliveryman;

public interface Cars_diliverymanDao {
	public List<Cars_diliveryman> selCars_diliverymanByWhid(String warehouseid);
	public Cars_diliveryman selCars_diliverymanByCarid(String carid);
}
