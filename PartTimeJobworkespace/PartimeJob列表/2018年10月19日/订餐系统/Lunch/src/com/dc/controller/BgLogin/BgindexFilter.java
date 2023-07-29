package com.dc.controller.BgLogin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BgindexFilter implements Filter{
	String except;
	public void destroy() {
		
		
	}
/**
 * 拦截非正常用户登录
 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
			HttpServletRequest request=(HttpServletRequest) arg0;
			HttpServletResponse response=(HttpServletResponse) arg1;
			HttpSession sess=request.getSession();
			String uri=request.getRequestURI();
			//System.out.println(uri+"uri");
			boolean state=true;
			if(except!=null){
				String strs[]=except.split(",");
				for(int i=0;i<strs.length;i++){
					if(uri.endsWith(strs[i])){
						arg2.doFilter(arg0, arg1);
						state=false;
						break;
					}
				}
			}
			if(state){
				//userinfo
				if((sess.getAttribute("userinfo")!=null||sess.getAttribute("UserMap")!=null)&&sess!=null){
					arg2.doFilter(arg0, arg1);
				}
				else{
					response.sendRedirect("/Lunch/module/BgLogin/BgLogin.jsp");
				}
			}
			
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		 except=arg0.getInitParameter("except");
		
	}
	
}
