package com.dc.dao.BgLogin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface UserDAO {
	public Map login(String username,String pwd);
	public List<HashMap> findAllFunctionByUserId(String accountid);
	public List<HashMap> selectEmpBycheck(Map map, PageEntity page);
	public int changeEmpAccountState(String empid);
}
