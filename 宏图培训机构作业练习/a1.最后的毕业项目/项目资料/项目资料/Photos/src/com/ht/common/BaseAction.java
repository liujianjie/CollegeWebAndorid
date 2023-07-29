package com.ht.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BaseAction {
	public Object getService(String serviceName) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return  context.getBean(serviceName);
	}
	
	//保存对象到 request
	public void setValueToRequest(String attrName,Object obj){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute(attrName, obj);
	}
	
	//保存的对象到session 
	public void setValueToSession(String attrName,Object obj){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute(attrName, obj);
	}
	
}
