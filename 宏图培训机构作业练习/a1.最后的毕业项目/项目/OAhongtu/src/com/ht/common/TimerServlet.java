package com.ht.common;


import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


public class TimerServlet extends HttpServlet {
	@Override 
	public void init() throws ServletException {
		super.init();
		try {
			// ����ʱ��24Сʱ������
			System.out.println(new Date() + " ����������Ӧ�ü�س���");
			
			ForeclosureTimer foreclosureTimer = new ForeclosureTimer();
			foreclosureTimer.startService();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("������ʱ������...");
		}
	}
}
