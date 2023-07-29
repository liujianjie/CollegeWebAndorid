package com.aaa.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class BaseAction {
public Map getRequest(){
	//得到request对象
	return (Map) ActionContext.getContext().get("request");
	
}
public PrintWriter getWrite() throws IOException{
	//输出json
	
	ServletActionContext.getResponse().setCharacterEncoding("utf-8");
	return ServletActionContext.getResponse().getWriter();
}
public Map getSession(){
	//
	return ActionContext.getContext().getSession();
	
	
	
}


}
