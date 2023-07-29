package com.aaa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.User;

@Repository
public class UserDaoimpl implements UserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List login(User user) {
		System.out.println("Daoceng" + user.getUserName() + user.getUserPwd());
		String hql = "from User where userName='" + user.getUserName() + "' and userPwd=" + user.getUserPwd() + "";
		// Object [] obj={user.getUserName(),user.getUserPwd()};
		System.out.println(hql);
		System.out.println(hibernateTemplate);
		List list = hibernateTemplate.find(hql);
		System.out.println(list.size());
		return list;
	}
}
