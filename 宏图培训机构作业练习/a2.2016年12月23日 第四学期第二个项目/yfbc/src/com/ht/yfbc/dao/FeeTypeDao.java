package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.FeeType;

public interface FeeTypeDao {
	public List<FeeType> selFeeTypeList();
	public FeeType selFeeTypeById(String id);
	public void updateFeeType(Map<String, Object> map);
}
