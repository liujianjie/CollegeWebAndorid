package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Department;
import com.aaa.entity.Staff;
import com.aaa.entity.User;
public interface StaffDao {
	int add(Staff st);
	Staff selOneByNameAndPsd(String username,String psd);
}
