package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Income;

public interface IncomeDao {
	public void addIncome(Income income);
	public List<Income> selIncomeListByMap(Map<String, Object> map);
	public List<Income> selIncomeList();
	public List<Income> findIncomeList(Map<String, Object> map);
	public int delIncome(String id);
	public int updIncome(Income income);
	public Income selIncomeById(String id);
	public int selCount();
	public String selIncById(String id);
	public Double selincome(Map<String, Object> map);
}
