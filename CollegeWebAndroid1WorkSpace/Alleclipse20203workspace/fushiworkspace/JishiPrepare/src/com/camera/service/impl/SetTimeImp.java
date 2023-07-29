package com.camera.service.impl;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.camera.dao.SetTimeDao;
import com.camera.pojo.WorkTime;
import com.camera.service.SetTimeService;

@Service
public class SetTimeImp implements SetTimeService{
	@Resource
	SetTimeDao settimedao;
	
	@Override
	public int insertWorkTime(WorkTime worktime) {
		// TODO Auto-generated method stub
		// ����ÿ�ܵģ�Ҫ����
		if(worktime.getDay() >= 8) {// ÿ�ܣ���Ҫ����7��
			WorkTime work = worktime; 
			int sumrow = 0;
			for(int i = 1; i < 8; i++) {
				work.setDay(i);
				sumrow += settimedao.insertWorkTime(worktime);
			}
			return sumrow;
		}else {
			return settimedao.insertWorkTime(worktime);
		}
	}

}
