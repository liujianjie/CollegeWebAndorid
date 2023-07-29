package com.ljj.service.Impl;

import com.ljj.dao.UserDao;
import com.ljj.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public boolean login(String username, String pwd) {
		return userDao.login(username, pwd);
	}

}
