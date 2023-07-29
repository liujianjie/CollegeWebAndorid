package com.ht.yfbc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.ExpendDao;
import com.ht.yfbc.pojo.Expend;
import com.ht.yfbc.service.ExpendService;
@Service
public class ExpendServiceImpl implements ExpendService {
	@Resource
	private ExpendDao expDao;

	public void addExpend(Expend expend) {
		expDao.addExpend(expend);
	}

	public List<Expend> selExpendListByMap(String exptime) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("exptime", exptime);
		return expDao.selExpendListByMap(map);
	}

	public List<Expend> selExpendList() {
		return expDao.selExpendList();
	}

	public List<Expend> findExpendList(Map<String, Object> map) {
		return expDao.findExpendList(map);
	}

	public int delExpend(String id) {
		return expDao.delExpend(id);
	}

	public int updExpend(Expend expend) {
		return expDao.updExpend(expend);
	}

	public Expend selExpendById(String id) {
		return expDao.selExpendById(id);
	}

	public int selCount() {
		return expDao.selCount();
	}

	public Double selexpend(String time) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("exptime", time);
		return expDao.selexpend(map);
	}

}
