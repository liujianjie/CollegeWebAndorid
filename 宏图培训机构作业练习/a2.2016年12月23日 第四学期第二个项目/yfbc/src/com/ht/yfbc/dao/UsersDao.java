package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Users;

public interface UsersDao {
	public Users selUserByNameAndPwd(Map<String, Object> map);
	public List<Users> selUserListPage(Map<String, Object> map);
	public List<Users> selUserList();
	public List<Users> selUserListByMap(Map<String, Object> map);
	public int selCount();
	public void addUsers(Users user);
	public int delUsers(String userid);
	public Users selUsersById(String id);
	public int updUsers(Users user);
	public String selUsernameById(String userid);
}

