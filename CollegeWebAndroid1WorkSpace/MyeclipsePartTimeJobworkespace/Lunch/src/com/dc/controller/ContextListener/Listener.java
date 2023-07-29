package com.dc.controller.ContextListener;
import java.util.Timer;
import javax.servlet.ServletContextEvent; 
import javax.servlet.ServletContextListener; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse; 
import javax.servlet.http.HttpServlet;

public class Listener extends HttpServlet implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// ��������ʼִ��ʱ,����һ��TIME
		 Timer timer = new Timer(); 
		 System.out.println("-------MailSend   Timer��ʼ����ִ��--------------");  
		 MailSendTask msendTask = new MailSendTask();
		 //scheduleΪִ�еĺ���
		 timer.schedule(msendTask,0, 10 * 1000);
		 System.out.println("-------MailSend   Timer�Ѿ���ִ��--------------");
	}

}
