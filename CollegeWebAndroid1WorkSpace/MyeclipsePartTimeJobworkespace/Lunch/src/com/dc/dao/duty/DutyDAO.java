package com.dc.dao.duty;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface DutyDAO {
	public boolean checkDuty(String dutyname,String dutyid);
	
	public void deleteById(String id);
	public void insertDuty(String departname,String dutyname,String accountid,String empuser);
	public void updateDuty(String departname,String dutyid,String dutyname,String accountid,String empuser);
	public List findDepartName();
	public Map findDepartId(String departname);
	public Map findById(String dutyid);
	public List findDuty(Map map,PageEntity page);
	public void close(String dutyid);
	public void open(String dutyid);
	public List findemp(String dutyid);
}
