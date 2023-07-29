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
		// 当监听开始执行时,设置一个TIME
		 Timer timer = new Timer(); 
		 System.out.println("-------MailSend   Timer开始进行执行--------------");  
		 MailSendTask msendTask = new MailSendTask();
		 //schedule为执行的函数
		 timer.schedule(msendTask,0, 10 * 1000);
		 System.out.println("-------MailSend   Timer已经在执行--------------");
	}

}
