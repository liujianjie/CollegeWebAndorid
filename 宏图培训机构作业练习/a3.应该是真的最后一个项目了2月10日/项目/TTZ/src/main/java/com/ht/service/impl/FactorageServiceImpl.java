package com.ht.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.FactorageDao;
import com.ht.service.FactorageService;

@Service
public class FactorageServiceImpl implements FactorageService {

	@Resource
	private FactorageDao fdao;

	// 查询手续费
	@Override
	public List ListFactorage() {
		return fdao.ListFactorage();
	}

	// 查询手续费count
	@Override
	public Integer CountFactorage() {
		return fdao.CountFactorage();
	}

}
