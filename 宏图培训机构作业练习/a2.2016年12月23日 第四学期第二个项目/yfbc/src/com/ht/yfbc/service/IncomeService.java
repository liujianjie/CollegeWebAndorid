package com.ht.yfbc.service;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Income;

public interface IncomeService {
	public void addIncome(Income income);
	public List<Income> selIncomeListByMap(String time);
	public List<Income> selIncomeList();
	public List<Income> findIncomeList(Map<String, Object> map);
	public int delIncome(String id);
	public int updIncome(Income income);
	public Income selIncomeById(String id);
	public int selCount();
	public Double selincome(String inctime);
}
