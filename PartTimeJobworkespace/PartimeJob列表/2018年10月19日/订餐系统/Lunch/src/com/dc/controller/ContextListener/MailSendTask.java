package com.dc.controller.ContextListener;

import java.util.Date;
import java.util.TimerTask;

import com.dc.dao.predetermine.PredetermineDao;
import com.dc.dao.predetermine.PredetermineDaoImpI;

public class MailSendTask extends TimerTask{
	public MailSendTask() {  
		  
	 } 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(new Date()+ "-----------定时器正在执行它的任务  to RUN ------------");  
		MailSendTask mainSendManager = new MailSendTask();  
		mainSendManager.waitingMailRemind(); 
	}
	private void waitingMailRemind() {
		PredetermineDao dao=new PredetermineDaoImpI();
		dao.dingShiPredetermine();
	}

}
