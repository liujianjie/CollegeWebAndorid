package com.jlgouwu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jlgouwu.dao.MoldDao;
import com.jlgouwu.pojo.Mold;
import com.jlgouwu.service.MoldService;

@Service
public class MoldImp implements MoldService{
	@Resource
	MoldDao moldDao;
	public List selmold() {	
		return moldDao.selmold();
	}

}
