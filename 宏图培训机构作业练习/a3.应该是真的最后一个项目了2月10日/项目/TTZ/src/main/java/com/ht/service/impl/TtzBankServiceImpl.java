package com.ht.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.TtzbankDao;
import com.ht.pojo.Ttzbank;
import com.ht.service.TtzbanlService;
@Service
public class TtzBankServiceImpl implements TtzbanlService{

	@Resource
	private TtzbankDao bankDao;

	@Override
	public void addTtzbank(Ttzbank bank) {
		// TODO Auto-generated method stub
		bankDao.addTtzbank(bank);
	}

	@Override
	public List<Ttzbank> seluserBank(String userid) {
		// TODO Auto-generated method stub
		return bankDao.seluserBank(userid);
	}

	@Override
	public void withDraw(String userid, String bankcard, Double takeMoney) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("p_user_id", userid);
		map.put("p_bankcard", bankcard);
		map.put("p_current_money", takeMoney);
		bankDao.withDraw(map);;
	}

	@Override
	public List<Ttzbank> selBankcard(String userid) {
		// TODO Auto-generated method stub
		return bankDao.selBankcard(userid);
	}

	@Override
	public int delbankcard(String userid) {
		// TODO Auto-generated method stub
		return bankDao.delbankcard(userid);
	}

}
