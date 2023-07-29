package com.ht.service.impl;

import java.util.List;

import com.ht.common.Hibernate_Dao;
import com.ht.service.IPageService;

public class PageServiceImpl extends Hibernate_Dao implements IPageService{

	@Override
	public int totalRow() {
		// TODO Auto-generated method stub
		return totalRow("select count(*) from DepartmentVo");
	}

	@Override
	public List pagelist(int startRow, int pageCount) {
		
		return pagelist("from DepartmentVo", startRow , pageCount);
	}

	@Override
	public List pagelistbysql(int startRow, int pageCount) {
		// TODO Auto-generated method stub
		return pagelistbysql("select e.ename,e.sex,d.dname from employee e left join department d on e.deptid=d.did", startRow, pageCount);
	}

}
