package com.ht.service.impl;

import java.util.List;

import com.ht.common.Hibernate_Dao;
import com.ht.service.DeptEmpService;
import com.ht.vo.DepartmentVo;
import com.ht.vo.EmployeeVo;

public class DeptEmpServiceImpl extends Hibernate_Dao implements DeptEmpService{

	@Override
	public boolean addDept(DepartmentVo dept) {
		// TODO Auto-generated method stub
		return addObj(dept);
	}

	@Override
	public List listDept() {
		// TODO Auto-generated method stub
		return list("from DepartmentVo");
	}

	@Override
	public DepartmentVo getDept(int id) {
		// TODO Auto-generated method stub
		return (DepartmentVo)getObj(DepartmentVo.class, id);
	}

	@Override
	public boolean updDept(DepartmentVo dept) {
		// TODO Auto-generated method stub
		return updObj(dept);
	}

	@Override
	public boolean delDept(DepartmentVo dept) {
		// TODO Auto-generated method stub
		return delObj(dept);
	}

	@Override
	public EmployeeVo selEmp(int id) {
		
		return (EmployeeVo)getObj(EmployeeVo.class, id);
	}

	@Override
	public boolean addEmp(EmployeeVo emp) {
		// TODO Auto-generated method stub
		return addObj(emp);
	}

}
