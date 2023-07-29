package com.ht.yfbc.service;


import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Salary;

public interface SalaryService {
	public void addSalary(Salary salary);
	public List<Salary> selSalaryListPage(Map<String, Object> map);
	public List<Salary> selSalaryListByUserId(String userid);
	public List<Salary> selSalaryList(Map<String, Object> map);
	public int selCount(Map<String , Object> map);
	public Salary isExist(String userid,String time);
 	public void updateSalaryById(Salary Salary);
	public void deleteSalaryById(String id);
	public Double selSfgzByMap(String time);
}
