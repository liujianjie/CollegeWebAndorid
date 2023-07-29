
package com.dc.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
public class BaseAction {
	/**
	 * 获取request对象
	 * @return
	 */
	public HttpServletRequest getRequest(){
		HttpServletRequest request=ServletActionContext.getRequest();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return request;
	}
	/**
	 * 获取session
	 * @return
	 */
	public HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	/**
	 * 获取response对象
	 * @return
	 */
	public HttpServletResponse getResponse(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		return response;
	}
	/**
	 * 获取out输出对象
	 * @return
	 */
	public PrintWriter getOut(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		try {
			return response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取上下文对象
	 * @return
	 */
	public ServletContext getApplication(){
		return ServletActionContext.getServletContext();
	}
}

