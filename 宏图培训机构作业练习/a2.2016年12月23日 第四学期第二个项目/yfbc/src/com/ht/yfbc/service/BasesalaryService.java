package com.ht.yfbc.service;


import java.util.List;

import com.ht.yfbc.pojo.Basesalary;
/**
 * Day 2017-1-3
 * @author 刘宗龙
 *
 */
public interface BasesalaryService {
	public void addBasesalary(Basesalary basesalary);
	public Basesalary selBasesalaryByPositionId(String positionid);
	public List<Basesalary> selBasesalaryList();
	public void updateBasesalaryById(Basesalary basesalary);
	public void deleteBasesalaryById(String id);
}
