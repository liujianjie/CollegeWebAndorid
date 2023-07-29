package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Department;
import com.aaa.entity.Staff;
import com.aaa.entity.User;
public interface StaffBiz {
	int add(Staff st);
	Staff selOneByNameAndPsd(String username,String psd);
}
