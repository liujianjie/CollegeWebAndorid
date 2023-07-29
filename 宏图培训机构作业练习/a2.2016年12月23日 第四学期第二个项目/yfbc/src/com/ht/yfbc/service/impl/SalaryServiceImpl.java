package com.ht.yfbc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.SalaryDao;
import com.ht.yfbc.pojo.Salary;
import com.ht.yfbc.service.SalaryService;
@Service
public class SalaryServiceImpl implements SalaryService {
@Resource
private SalaryDao salDao;
	public List<Salary> selSalaryListByUserId(String userid) {
		return salDao.selSalaryListByUserId(userid);
	}

	public List<Salary> selSalaryList(Map<String, Object> map) {
		return salDao.selSalaryList(map);
	}

	public void updateSalaryById(Salary Salary) {
		salDao.updateSalaryById(Salary);
	}

	public void deleteSalaryById(String id) {
		salDao.deleteSalaryById(id);
	}

	public void addSalary(Salary salary) {
		salDao.addSalary(salary);
	}

	public List<Salary> selSalaryListPage(Map<String, Object> map) {
		return salDao.selSalaryListPage(map);
	}

	public int selCount(Map<String , Object> map) {
		return salDao.selCount(map);
	}

	public Salary isExist(String userid, String time) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("time", time);
		return salDao.isExist(map);
	}

	public Double selSfgzByMap(String time) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("time", time);
		return salDao.selSfgzByMap(map);
	}

}
