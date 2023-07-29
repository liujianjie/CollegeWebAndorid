package com.ht.yfbc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.IncomeDao;
import com.ht.yfbc.pojo.Income;
import com.ht.yfbc.service.IncomeService;

@Service
public class IncomeServiceImpl implements IncomeService {
	@Resource
	private IncomeDao IncDao;

	@Override
	public List<Income> findIncomeList(Map<String, Object> map) {
		return IncDao.findIncomeList(map);
	}

	public void addIncome(Income income) {
		IncDao.addIncome(income);
	}

	@Override
	public int delIncome(String id) {
		return IncDao.delIncome(id);
	}

	@Override
	public int updIncome(Income income) {
		return IncDao.updIncome(income);
	}

	@Override
	public int selCount() {
		return IncDao.selCount();
	}

	@Override
	public List<Income> selIncomeList() {
		return IncDao.selIncomeList();
	}

	@Override
	public Income selIncomeById(String id) {
		return IncDao.selIncomeById(id);
	}

	public List<Income> selIncomeListByMap(String time) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("inctime", time);
		return IncDao.selIncomeListByMap(map);
	}

	public Double selincome(String time) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("inctime", time);
		return IncDao.selincome(map);
	}

}
