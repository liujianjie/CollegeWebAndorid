package com.ht.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hibernate_Util {
	private static SessionFactory sessionf = null;

	public static SessionFactory getSessionFactory() {
		if (sessionf == null) {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			sessionf = (SessionFactory) context.getBean("sFactory");
		}
		return sessionf;
	}
	
	public static Session getSession(){
		return getSessionFactory().openSession();
	}
}
