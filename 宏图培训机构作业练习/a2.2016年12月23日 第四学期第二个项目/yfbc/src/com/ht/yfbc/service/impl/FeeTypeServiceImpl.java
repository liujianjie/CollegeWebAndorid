package com.ht.yfbc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.FeeTypeDao;
import com.ht.yfbc.pojo.FeeType;
import com.ht.yfbc.service.FeeTypeService;
@Service
public class FeeTypeServiceImpl implements FeeTypeService {
	@Resource
	private FeeTypeDao feeDao;
	public List<FeeType> selFeeTypeList() {
		return feeDao.selFeeTypeList();
	}

	public FeeType selFeeTypeById(String id) {
		return feeDao.selFeeTypeById(id);
	}

	public void updateFeeType(Map<String, Object> map) {
		feeDao.updateFeeType(map);
	}

}
