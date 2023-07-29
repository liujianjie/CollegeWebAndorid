package com.ht.service;

import java.util.List;

import com.ht.vo.DepartmentVo;
import com.ht.vo.EmployeeVo;

public interface DeptEmpService {
	public boolean addDept(DepartmentVo dept);
	public List listDept();
	public DepartmentVo getDept(int id);
	public boolean updDept(DepartmentVo dept);
	public boolean delDept(DepartmentVo dept);
	public EmployeeVo selEmp(int id);
	public boolean addEmp(EmployeeVo emp);
}
