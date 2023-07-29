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
		// 若是每周的，要处理
		if(worktime.getDay() >= 8) {// 每周，就要插入7个
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
