package com.aaa.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.UserDao;
import com.aaa.entity.User;
@Service
public class UserBizimpl implements UserBiz {
	@Autowired
  private UserDao userDao;
	public List login(User user) {
		System.out.println("biz��"+user.getUserName()+user.getUserPwd());
 List list= userDao.login(user);
		 //ֻ��ȷ��list�������ݲ���ʹ��get
		 if(list.size()>0){
			 return list;
		 }else{
			 return null;
		 }
		
	}

}
