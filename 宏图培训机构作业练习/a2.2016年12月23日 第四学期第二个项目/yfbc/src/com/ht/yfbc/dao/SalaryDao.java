package com.ht.yfbc.dao;


import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Salary;

public interface SalaryDao {
	public void addSalary(Salary salary);
	public List<Salary> selSalaryListPage(Map<String, Object> map);
	public List<Salary> selSalaryList(Map<String, Object> map);
	public List<Salary> selSalaryListByUserId(String userid);
	public int selCount(Map<String , Object> map);
	public Salary isExist(Map<String , Object> map);
 	public void updateSalaryById(Salary Salary);
	public void deleteSalaryById(String id);
	public Double selSfgzByMap(Map<String , Object> map);
}
