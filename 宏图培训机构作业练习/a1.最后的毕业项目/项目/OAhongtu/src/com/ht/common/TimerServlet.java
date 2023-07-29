package com.ht.common;


import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


public class TimerServlet extends HttpServlet {
	@Override 
	public void init() throws ServletException {
		super.init();
		try {
			// 处理超时（24小时）订单
			System.out.println(new Date() + " ：订单处理应用监控程序");
			
			ForeclosureTimer foreclosureTimer = new ForeclosureTimer();
			foreclosureTimer.startService();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("启动定时器出错...");
		}
	}
}
