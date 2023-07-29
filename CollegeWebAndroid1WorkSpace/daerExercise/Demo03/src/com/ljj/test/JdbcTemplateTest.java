package com.ljj.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {

	public static void main(String[] args) {
		ApplicationContext app = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdt = (JdbcTemplate) app.getBean("jdbcTemplate");
		// 执行sql语句
		jdt.execute("create table account(" +
				"id int primary key auto_increment," +
				"username varchar(50)," +
				"balance double)");
		System.out.println("创建成功");
	}

}
