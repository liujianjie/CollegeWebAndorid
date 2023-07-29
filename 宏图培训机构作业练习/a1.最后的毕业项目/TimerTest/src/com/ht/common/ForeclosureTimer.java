package com.ht.common;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class ForeclosureTimer extends TimerTask {
	private static Timer timer = null;
	// �������м������Ϊ��λ��
	private static Long appTimeInterval = new Long(24*60*60);
	// #����Сʱ��
	private static Long appTimeHour = new Long(23);
	// �����֣�
	private static Long appTimeMin = new Long(00);
	

	@Override
	public void run() {
		
		try {
			
		// ��ʼ����
			System.out.print("��ʱ��������...");
			String sql="update XXX set statu='�ѽ���' where  ����ʱ��<sys_date";

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
