package com.aaa.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.aaa.biz.UserBiz;
import com.aaa.entity.User;

public class UserAction extends BaseAction{
	private User tabUser;
	@Autowired
	private UserBiz userBiz;
@Action("login")
public String login() throws IOException{
	System.out.println(tabUser.getUserName()+tabUser.getUserPwd());
	List user=userBiz.login(tabUser);
	
	if(user!=null){
		//将用户信息放到session中
		
		getSession().put("user", user);
		getWrite().print("true");
		System.out.println("true");
			return null;
		
	}else{
			getWrite().print("false");
			return "false";
		
	}
	

}
public User getTabUser() {
	return tabUser;
}
public void setTabUser(User tabUser) {
	this.tabUser = tabUser;
}

}
