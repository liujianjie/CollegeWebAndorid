package com.ht.serviceimp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.bean.Users;
import com.ht.daoi.UsersDaoI;
import com.ht.service.UsersI;

@Service
public class Usersimp  implements UsersI{

	@Resource
	UsersDaoI usersi;
	
	@Override
	public Users getUsersandlog(Map<String, Object> map) {
		return usersi.getUsersandlog(map);
	}
	public int alertuser(Map<String,Object> map){
		return usersi.alertuser(map);
	}
	public List<Users> userlist(Map<String,Object> map){
		return usersi.userlist(map);
	}
	public int useradd(Users user){
		return usersi.useradd(user);
	}
	@Override
	public int userdel(Integer id) {
		return usersi.userdel(id);
	}
	@Override
	public int seluserlistcount() {
		return usersi.seluserlistcount();
	}
		
}
