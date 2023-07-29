package com.ljj.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ljj.dao.Account;
import com.ljj.jdbc.AccountDao;
public class JdbcTemplateUpdate {
	public static void main(String[] args) {
		ApplicationContext app = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDao accdao = (AccountDao) app.getBean("accountDao");
		// 1.insert
		Account account1 = new Account();
		account1.setUsername("tom");
		account1.setBalance(2000.00);
		
		Account account2 = new Account();
		account2.setUsername("jim");
		account2.setBalance(3000.00);
		
		accdao.addAccount(account1);
		accdao.addAccount(account2);
		System.out.println("插入两条数据成功");
		
		// 2.update
		account2.setId(2);
		account2.setBalance(1.0);
		int i = accdao.updateAccount(account2);
		if(i > 0){
			System.out.println("修改jim的balance为"+account2.getBalance()+"成功");
		}
		// 3.delete
		int j = accdao.deleteAccount(1);
		if(j > 0){
			System.out.println("删除tom成功");
		}
	}

}
