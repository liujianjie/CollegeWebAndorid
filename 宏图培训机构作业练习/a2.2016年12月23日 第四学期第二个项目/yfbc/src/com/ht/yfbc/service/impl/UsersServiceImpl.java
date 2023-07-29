package com.ht.yfbc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.UsersDao;
import com.ht.yfbc.pojo.Users;
import com.ht.yfbc.pojo.UsersVo;
import com.ht.yfbc.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService {
	@Resource
	private UsersDao userDao;
	public Users selUserByNameAndPwd(Map<String, Object> map) {
		return userDao.selUserByNameAndPwd(map);
	}

	public int selCount() {
		return userDao.selCount();
	}

	public List<Users> selUserListPage(Map<String, Object> map) {
		return userDao.selUserListPage(map);
	}
	public List<Users> selUserList() {
		return userDao.selUserList();
	}
	public List<Users> selUserListByMap(Map<String, Object> map) {
		return userDao.selUserListByMap(map);
	}
	public void addUsers(Users user) {
		userDao.addUsers(user);
	}

	public int delUsers(String userid) {
		return userDao.delUsers(userid);
	}

	@Override
	public Users selUsersById(String id) {
		return userDao.selUsersById(id);
	}

	@Override
	public int updUsers(Users user) {
		return userDao.updUsers(user);
	}

	public String selUsernameById(String userid) {
		return userDao.selUsernameById(userid);
	}

}
