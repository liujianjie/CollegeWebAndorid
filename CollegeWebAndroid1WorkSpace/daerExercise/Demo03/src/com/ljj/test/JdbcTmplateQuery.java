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
		// ������ѯ
		AccountDao acd = (AccountDao)app.getBean("accountDao");
		Account act = acd.findAccountById(1);
		System.out.println("������ѯ");
		System.out.println(act.toString());
		// �����ѯ
		List<Account> account = acd.findAllAccount();
		// ѭ�����
		System.out.println("��ѯ����");
		for(Account ac : account){
			System.out.println(ac);
		}
	}
}
