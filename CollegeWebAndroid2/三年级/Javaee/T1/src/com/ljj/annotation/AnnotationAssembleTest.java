package com.ljj.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationAssembleTest {
	public static void main(String[] args) {
		String path = "application.xml";
		ApplicationContext apx = new ClassPathXmlApplicationContext(path);
		UserController userc = (UserController) apx.getBean("userController");
		userc.save();
	}
}
