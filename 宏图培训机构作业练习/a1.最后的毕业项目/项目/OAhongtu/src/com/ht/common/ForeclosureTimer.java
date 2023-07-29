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
	// �������м������Ϊ��λ������ȡ�����ļ���Ĭ��ֵΪ30����
	private static Long appTimeInterval = new Long(60*60*24);
	// #����Сʱ��Ĭ���糿9ʱ
	private static Long appTimeHour = new Long(23);
	// �����֣�Ĭ��0
	private static Long appTimeMin = new Long(50);
	

	@Override
	public void run() {
		ICourseService cou=new CourseServiceImpl();
		
		try {
			// ��ʼ����
			System.out.print("��ʱ��������...");
			//���ķ���״̬
			cou.changestate(new Date());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void startService() {
		// ��������֮ǰ��һ��Ҫ��֮ǰ��timerͣ�����мǣ�
		if (timer != null)
			timer.cancel();
		timer = new Timer();

		// ��ȡһ���̶���ʱ��
		Calendar ca = new GregorianCalendar();
		ca.set(Calendar.DAY_OF_MONTH, ca.get(Calendar.DAY_OF_MONTH));
		ca.set(Calendar.HOUR_OF_DAY, appTimeHour.intValue());
		ca.set(Calendar.MINUTE, appTimeMin.intValue());
		Date date = ca.getTime();
		// ��ȡʱ���������Դ����ݻ����������ļ������¶�ȡ
		timer.schedule(new ForeclosureTimer(), 120 * 1000, 1000 * appTimeInterval);
	}

	public void stopService() {
		if (timer != null)
			timer.cancel();
	}

}
