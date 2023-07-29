package com.zuxia.control;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zuxia.dao.CustomerInfoDao;
import com.zuxia.util.StringUtil;

/**
 * 使用Ajax验证某Email（账户）是否已经存在
 */
public class AjaxGetIsEmailExists extends HttpServlet {

	private static final long serialVersionUID = 4789497946364583953L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		if(StringUtil.isNullOrEmpty(email)){
			out.print("null");
		}else{
			CustomerInfoDao dao = new CustomerInfoDao();
			if(dao.isExists(email)){
				out.print("true");
			}else{
				out.print("false");
			}
		}
	}
}
