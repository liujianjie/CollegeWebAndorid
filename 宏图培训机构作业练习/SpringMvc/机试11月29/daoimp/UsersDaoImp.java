package com.ht.daoimp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.ht.bean.Users;
import com.ht.daoi.UsersDaoI;

@Repository
public class UsersDaoImp implements UsersDaoI{
	
	@Resource
	SqlSessionFactory sqlsession;
	
	@Override
	public Users getUsersandlog(Map<String,Object> map) {
		SqlSession session = sqlsession.openSession();
		return session.selectOne("com.ht.daoi.UsersDaoI.getUsersandlog",map);
	}

	@Override
	public int alertuser(Map<String, Object> map) {
		SqlSession session = sqlsession.openSession();
		return session.update("com.ht.daoi.UsersDaoI.alertuser",map);
	}
	
	public List<Users> userlist(Map<String,Object> map){
		SqlSession session = sqlsession.openSession();
		return session.selectList("com.ht.daoi.UsersDaoI.userlist",map);
	}

	@Override
	public int useradd(Users user) {
		SqlSession session = sqlsession.openSession();
		return session.insert("com.ht.daoi.UsersDaoI.useradd",user);
	}
	public int userdel(Integer id){
		SqlSession session = sqlsession.openSession();
		return session.delete("com.ht.daoi.UsersDaoI.userdel",id);
	}
	public int seluserlistcount(){
		SqlSession session = sqlsession.openSession();
		return session.selectOne("com.ht.daoi.UsersDaoI.seluserlistcount");
	}
}
