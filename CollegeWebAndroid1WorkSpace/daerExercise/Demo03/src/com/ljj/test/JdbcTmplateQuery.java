package com.ljj.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ljj.dao.Account;
import com.ljj.jdbc.AccountDao;

public class JdbcTmplateQuery {
	public static void main(String[] args) {
		ApplicationContext app = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		// 单个查询
		AccountDao acd = (AccountDao)app.getBean("accountDao");
		Account act = acd.findAccountById(1);
		System.out.println("单个查询");
		System.out.println(act.toString());
		// 多个查询
		List<Account> account = acd.findAllAccount();
		// 循环输出
		System.out.println("查询集合");
		for(Account ac : account){
			System.out.println(ac);
		}
	}
}
