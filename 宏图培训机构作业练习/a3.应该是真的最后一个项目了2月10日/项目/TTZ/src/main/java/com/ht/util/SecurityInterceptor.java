package com.ht.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * spring拦截器
 * 
 * @author tianyong
 * 
 */
public class SecurityInterceptor implements HandlerInterceptor {

	public String[] allowUrls;// 还没发现可以直接配置不拦截的资源，所以在代码里面来排除

	public void setAllowUrls(String[] allowUrls) {
		this.allowUrls = allowUrls;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession(true);
		boolean GL = false;// 判断有没被过滤
		boolean returnStatu = true;// 判断继不继续执行请求
		System.out.println("提示: URL拦截中......" + requestUrl);
		if (null != allowUrls && allowUrls.length >= 1)
			for (String url : allowUrls) {
				if (requestUrl.contains(url)) {
					System.out.println("提示: 该URL被过滤...");
					GL = true;
					return true;
				}
			}
		if (GL == false) {// 没有被过滤
			// 判断登陆的是前台还是后台
			String system = (String) session.getAttribute("system");
			String consystem = SystemContant.System;
			if (system != null) {// session未失效 拦截
				if (system.equals("前台系统")) {
					Object obj = session.getAttribute("user");
					String path = session.getServletContext().getContextPath();
					if (obj == null || "".equals(obj.toString()) || SystemContant.tuser == null) {
						System.out.println("提示: 前台系统session: 已失效 >");
						// throw new SessionTimeoutException();// 返回到配置文件中定义的路径
						// response.sendRedirect(SystemConstants.LOGIN_URL);
						PrintWriter out = response.getWriter();
						StringBuilder builder = new StringBuilder();
						builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
						builder.append("alert(\"页面过期，请重新登录\");");
						builder.append("window.top.location.href=\"" + path + "/foregroundSystem/login.jsp\"");
						builder.append("</script>");
						out.print(builder.toString());
						try {
							out.flush();
						} finally {
							out.close();
						}
						returnStatu = false;
					} else {
						System.out.println("提示: 前台系统session: 已登录 未失效 >");
						returnStatu = true;
					}
				} else if (system.equals("后台系统")) {
					// 获取当前登陆用户信息
					Object obj = session.getAttribute("backuser");
					String path = session.getServletContext().getContextPath();
					if (obj == null || "".equals(obj.toString()) || SystemContant.buser == null) {
						System.out.println("提示: 后台系统session: 已失效 >");
						// throw new SessionTimeoutException();// 返回到配置文件中定义的路径
						// response.sendRedirect(SystemConstants.LOGIN_URL);
						PrintWriter out = response.getWriter();
						StringBuilder builder = new StringBuilder();
						builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
						builder.append("alert(\"页面过期，请重新登录\");");
						// 判断当前登陆的是哪个系统 从而决定跳哪个登陆界面
						builder.append("window.top.location.href=\"" + path + "/backgroundSystem/login.jsp\"");
						builder.append("</script>");
						out.print(builder.toString());
						try {
							out.flush();
						} finally {
							out.close();
						}
						returnStatu = false;
					} else {
						System.out.println("提示: 后台系统session: 已登录 未失效 >");
						returnStatu = true;
					}
				}
			} else if (system == null && consystem != null) {// session失效,但是常量还没被重置
				if (consystem.equals(SystemContant.ForegroundSystem)) {
					Object obj = session.getAttribute("user");
					String path = session.getServletContext().getContextPath();
					if (obj == null || "".equals(obj.toString()) || SystemContant.tuser == null) {
						System.out.println("提示: 前台系统session: 已失效 >");
						// throw new SessionTimeoutException();// 返回到配置文件中定义的路径
						// response.sendRedirect(SystemConstants.LOGIN_URL);
						PrintWriter out = response.getWriter();
						StringBuilder builder = new StringBuilder();
						builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
						builder.append("alert(\"页面过期，请重新登录\");");
						builder.append("window.top.location.href=\"" + path + "/foregroundSystem/login.jsp\"");
						builder.append("</script>");
						out.print(builder.toString());
						try {
							out.flush();
						} finally {
							out.close();
						}
						returnStatu = false;
					} else {
						System.out.println("提示: 前台系统session: 已登录 未失效 >");
						returnStatu = true;
					}
				} else if (consystem.equals(SystemContant.BackgroundSystem)) {
					// 获取当前登陆用户信息
					Object obj = session.getAttribute("backuser");
					String path = session.getServletContext().getContextPath();
					if (obj == null || "".equals(obj.toString()) || SystemContant.buser == null) {
						System.out.println("提示: 后台系统session: 已失效 >");
						// throw new SessionTimeoutException();// 返回到配置文件中定义的路径
						// response.sendRedirect(SystemConstants.LOGIN_URL);
						PrintWriter out = response.getWriter();
						StringBuilder builder = new StringBuilder();
						builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
						builder.append("alert(\"页面过期，请重新登录\");");
						// 判断当前登陆的是哪个系统 从而决定跳哪个登陆界面
						builder.append("window.top.location.href=\"" + path + "/backgroundSystem/login.jsp\"");
						builder.append("</script>");
						out.print(builder.toString());
						try {
							out.flush();
						} finally {
							out.close();
						}
						returnStatu = false;
					} else {
						System.out.println("提示: 后台系统session: 已登录 未失效 >");
						returnStatu = true;
					}
				}
			}
		}
		return returnStatu; // 返回true，则这个方面调用后会接着调用postHandle(),
							// false 将不会继续执行请求的方法
	}
}