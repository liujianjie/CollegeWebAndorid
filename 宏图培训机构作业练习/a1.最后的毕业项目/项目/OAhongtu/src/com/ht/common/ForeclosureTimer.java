package com.ht.common;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.ht.service.ICourseService;
import com.ht.service.impl.CourseServiceImpl;

public class ForeclosureTimer extends TimerTask {
	
	private static Timer timer = null;
	// 程序运行间隔，秒为单位，不读取配置文件的默认值为30分钟
	private static Long appTimeInterval = new Long(60*60*24);
	// #启动小时，默认早晨9时
	private static Long appTimeHour = new Long(23);
	// 启动分，默认0
	private static Long appTimeMin = new Long(50);
	

	@Override
	public void run() {
		ICourseService cou=new CourseServiceImpl();
		
		try {
			// 开始处理
			System.out.print("定时器进来了...");
			//更改反馈状态
			cou.changestate(new Date());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void startService() {
		// 重新启动之前，一定要把之前的timer停掉！切记！
		if (timer != null)
			timer.cancel();
		timer = new Timer();

		// 获取一个固定的时间
		Calendar ca = new GregorianCalendar();
		ca.set(Calendar.DAY_OF_MONTH, ca.get(Calendar.DAY_OF_MONTH));
		ca.set(Calendar.HOUR_OF_DAY, appTimeHour.intValue());
		ca.set(Calendar.MINUTE, appTimeMin.intValue());
		Date date = ca.getTime();
		// 获取时间间隔，可以从数据户或者配置文件中重新读取
		timer.schedule(new ForeclosureTimer(), 120 * 1000, 1000 * appTimeInterval);
	}

	public void stopService() {
		if (timer != null)
			timer.cancel();
	}

}
