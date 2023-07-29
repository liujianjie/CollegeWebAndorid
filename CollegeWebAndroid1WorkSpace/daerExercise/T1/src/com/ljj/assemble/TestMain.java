package com.ljj.assemble;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String path = "application.xml";
		ApplicationContext apx = new ClassPathXmlApplicationContext(path);
		User user1 = (User) apx.getBean("user1");
		User user2 = (User) apx.getBean("user2");
		System.out.println(user1);
		System.out.println(user2);
	}
}
