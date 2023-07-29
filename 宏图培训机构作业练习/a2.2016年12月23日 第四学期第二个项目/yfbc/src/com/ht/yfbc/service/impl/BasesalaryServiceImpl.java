package com.ht.yfbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.BasesalaryDao;
import com.ht.yfbc.pojo.Basesalary;
import com.ht.yfbc.service.BasesalaryService;
@Service
public class BasesalaryServiceImpl implements BasesalaryService{
	@Resource
	private BasesalaryDao basesalDao;
	
	public Basesalary selBasesalaryByPositionId(String positionid) {
		return basesalDao.selBasesalaryByPositionId(positionid);
	}

	public List<Basesalary> selBasesalaryList() {
		return basesalDao.selBasesalaryList();
	}

	public void updateBasesalaryById(Basesalary basesalary) {
		basesalDao.updateBasesalaryById(basesalary);
	}

	public void deleteBasesalaryById(String id) {
		basesalDao.deleteBasesalaryById(id);
	}

	public void addBasesalary(Basesalary basesalary) {
		basesalDao.addBasesalary(basesalary);
	}

}
