package com.ht.yfbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.LimitDao;
import com.ht.yfbc.pojo.Limit;
import com.ht.yfbc.service.LimitService;
@Service
public class LimitServiceImpl implements LimitService {
	@Resource
	private LimitDao limitDao;
	public List<Limit> selLimitList() {
		return limitDao.selLimitList();
	}
	public String selLimitNameById(String id) {
		return limitDao.selLimitNameById(id);
	}
	
}
