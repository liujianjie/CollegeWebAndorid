package com.ht.daoi;

import java.util.List;
import java.util.Map;

import com.ht.bean.Users;

public interface UsersDaoI {
	//用户大小
	public int seluserlistcount();
	
	public Users getUsersandlog(Map<String,Object> map);
	public int alertuser(Map<String,Object> map);
	public List<Users> userlist(Map<String,Object> map);
	
	public int useradd(Users user);
	public int userdel(Integer id);
}
