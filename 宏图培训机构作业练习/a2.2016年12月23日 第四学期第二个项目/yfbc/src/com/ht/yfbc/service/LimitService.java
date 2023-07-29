package com.ht.yfbc.service;

import java.util.List;

import com.ht.yfbc.pojo.Limit;

public interface LimitService {
	public List<Limit> selLimitList();
	public String selLimitNameById(String id);
}
