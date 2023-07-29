package com.ljj.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ljj.service.UserService;

public class TestMain {
	public static void main(String[] args) {
		String path = "application.xml";
		ApplicationContext apx = new ClassPathXmlApplicationContext(path);
		UserService usersei = (UserService) apx.getBean("userService");
		boolean bln = usersei.login("admin", "123");
		if(bln){
			System.out.println("µÇÂ¼³É¹¦");
		}else{
			System.out.println("µÇÂ¼Ê§°Ü");
		}
	}
}
