package com.dc.dao.Empinfo;

import java.util.HashMap;
import java.util.List;

public interface EmpDAO {

	List<HashMap> selectOneEmpById(String empid);

	boolean checkUserName(String username, String accountid);
	int insertOneEmp(String departid,String ssuserid,String ssusername,String empname, String phone, String username, 
			String pwd, String province, String city, String district, 
			String day, String month, String year, String age, String sex, 
			String address,String dutyname);
	int updateThisEmp(String departid,String ssuserid,String ssusername,String accountid, String empid, String empname,
			String phone, String pwd, String username, String province,
			String city, String district, String day, String month,
			String year, String age, String sex,String address,String dutyname);
	public List<HashMap> selectAllDuty();
	public List<HashMap> selectAllRole();

	List<HashMap> selectEmpRole(String empaccountid);

	public boolean insertEmpRole(String empaccountid, String[] roleid);

	public List<HashMap> selectAllDepart();

	public List selectDutyBydepid(String departid);

}
