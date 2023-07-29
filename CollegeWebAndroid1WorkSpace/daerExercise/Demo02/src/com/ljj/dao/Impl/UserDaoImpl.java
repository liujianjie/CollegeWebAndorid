package com.ljj.dao.Impl;

import com.ljj.dao.UserDao;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean login(String loginName, String loginPwd) {
		if(loginName.equals("admin") && loginPwd.equals("123")){
			return true;
		}else{
			return false;
		}
	}
	
}
