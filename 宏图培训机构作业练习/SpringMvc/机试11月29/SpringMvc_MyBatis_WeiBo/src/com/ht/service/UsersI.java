package com.ht.service;

import java.util.List;
import java.util.Map;


import com.ht.bean.Users;

public interface UsersI {
	//�û���С
	public int seluserlistcount();
	public Users getUsersandlog(Map<String, Object> map);
	public int alertuser(Map<String,Object> map);
	
	public List<Users> userlist(Map<String,Object> map);
	public int useradd(Users user);
	public int userdel(Integer id);
}
