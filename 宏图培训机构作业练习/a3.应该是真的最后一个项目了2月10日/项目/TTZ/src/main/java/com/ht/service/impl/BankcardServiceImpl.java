package com.ht.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.BanmcardDao;
import com.ht.pojo.Bankcard;
import com.ht.service.BankcardService;
@Service
public class BankcardServiceImpl implements BankcardService{
	@Resource
	private BanmcardDao bankcardDao;
	@Override
	public Bankcard selbybkselbybkcard(String bankcard) {
		// TODO Auto-generated method stub
		return bankcardDao.selbybkselbybkcard(bankcard);
	}
	@Override
	public Bankcard selbybkseltwo(String bankcard, String pcard) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bankcard", bankcard);
		map.put("pcard", pcard);
		return bankcardDao.selbytwo(map);
	}

}
