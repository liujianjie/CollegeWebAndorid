package com.dc.dao.department;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;



public interface DepartDAO {
	
	
	public boolean checkDepart(String departname,String departid);
	
	public void deleteById(String departid);
	public void insertDepart(String departname,String departdesc,String accountid,String empuser);
	public void updateDepart(String departid,String departname,String departdesc,String accountid,String empuser);
	public Map findDepartById(String departid);
	public List findDepart(PageEntity page,String departname);
	public List findDepartEmp(String departid,PageEntity page);
	public void close(String departid);
	public void open(String departid);
	public List findDepartEmployee(String departid);
}
