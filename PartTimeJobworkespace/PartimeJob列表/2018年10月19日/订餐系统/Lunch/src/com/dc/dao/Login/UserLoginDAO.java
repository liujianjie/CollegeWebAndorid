package com.dc.dao.Login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserLoginDAO {
	public Map Login(String username, String customerid);
	public int register(String customername, String customeruser,String pwd,String birthday,
			String sex,String customerphone,String province,String city,String district,String customeradd);
	public Map selectBycustid(String customerid);
	public int updatecustomer(String customerid, String customername,
			String customeruser, String pwd, String birthday, String sex,
			String customerphone, String province, String city,
			String district, String customeradd); 
}
