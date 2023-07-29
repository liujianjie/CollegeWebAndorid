package com.ht.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.RatesDao;
import com.ht.pojo.Rates;
import com.ht.service.RatesServiceI;

@Service
public class RatesServiceImpl implements RatesServiceI{
	
	@Resource
	RatesDao ratesdao;

	@Override
	public List<Rates> selrateslist() {
		// TODO Auto-generated method stub
		return ratesdao.selrateslist();
	}

	@Override
	public int add(Rates rates) {
		// TODO Auto-generated method stub
		return ratesdao.add(rates);
	}

	@Override
	public int upd(Rates rates) {
		// TODO Auto-generated method stub
		return ratesdao.upd(rates);
	}

	@Override
	public int del(String id) {
		return ratesdao.del(id);
	}

	@Override
	public Rates get(String id) {
		return ratesdao.get(id);
	}
	
}
