package com.ht.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BaseAction {
	public void ToRequest(String attrname,Object obj){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute(attrname, obj);
	}
	public void ToSession(String attrname,Object obj){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute(attrname, obj);
	}
	public Object fromSession(String attrname){
		HttpServletRequest request=ServletActionContext.getRequest();
		return request.getSession().getAttribute(attrname);
	}
}
