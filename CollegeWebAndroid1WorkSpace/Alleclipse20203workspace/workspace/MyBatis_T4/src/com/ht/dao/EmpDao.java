package com.ht.dao;

import java.util.List;
import java.util.Map;

import com.ht.bean.Emp;
import com.ht.bean.EmpAndDept;

public interface EmpDao {
	public List<EmpAndDept> selEmpAndDept();
}	
