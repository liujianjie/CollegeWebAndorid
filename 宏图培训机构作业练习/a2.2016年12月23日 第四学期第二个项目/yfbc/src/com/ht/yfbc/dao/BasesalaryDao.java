package com.ht.yfbc.dao;


import java.util.List;

import com.ht.yfbc.pojo.Basesalary;
/**
 * Day
 * @author 刘宗龙
 *
 */
public interface BasesalaryDao {
	public void addBasesalary(Basesalary basesalary);
	public Basesalary selBasesalaryByPositionId(String positionid);
	public List<Basesalary> selBasesalaryList();
	public void updateBasesalaryById(Basesalary basesalary);
	public void deleteBasesalaryById(String id);
}
