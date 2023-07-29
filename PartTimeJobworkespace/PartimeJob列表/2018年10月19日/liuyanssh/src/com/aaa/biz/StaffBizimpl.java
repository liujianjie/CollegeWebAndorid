package com.aaa.biz;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.aaa.dao.DepartmentDao;
import com.aaa.dao.StaffDao;
import com.aaa.entity.Department;
import com.aaa.entity.Staff;

@Service
public class StaffBizimpl implements StaffBiz {
	@Autowired
	private StaffDao stfdao;
	public int add(Staff st){
		return stfdao.add(st);
	}
	public Staff selOneByNameAndPsd(String username, String psd) {
		// TODO Auto-generated method stub
		return stfdao.selOneByNameAndPsd(username, psd);
	}
}
