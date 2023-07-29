package com.dc.dao.CustomerDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface customerDAO {
	public List<HashMap> selectAllCustomer();

	public List<HashMap> selectCustomerBycheck(Map map, PageEntity page);	
}
