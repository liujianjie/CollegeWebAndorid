package com.ht.yfbc.dao;

import java.util.List;

import com.ht.yfbc.pojo.Limit;

public interface LimitDao {
	public List<Limit> selLimitList();
	public String selLimitNameById(String id);
}
