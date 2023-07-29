package com.camera.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.camera.dao.SelectTimeDao;
import com.camera.pojo.WorkTime;
import com.camera.service.SelectTimeService;

@Service
public class SelectTimeImp implements SelectTimeService{
	
	@Resource
	SelectTimeDao selectdao;
	// 时间转换
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/*
	 * @datetime:传入时间
	 * 1.先转换为日期，并获取时分秒
	 * 
	 * */
	@Override
	public boolean selctTimeIsWork(String datetime) {
		// TODO Auto-generated method stub
		Date dt = null;
		try {
			dt = sd.parse(datetime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		System.out.println(dt);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        weekDay = weekDay == 1 ? 7 : weekDay - 1; 
		
        List<WorkTime> noworklist = selectdao.selectWorkTime(weekDay, 1);// 不工作
        for(WorkTime nowk: noworklist) {
        	if(nowk.getStarthour() == hour && nowk.getStartmin() <= min) {
        		return false;
        	}else if(nowk.getEndhour() == hour && nowk.getEndmin() >= min) {
        		return false;
        	}else if(nowk.getStarthour() < hour && nowk.getEndhour() > hour) {
        		return false;
        	}
        }
        List<WorkTime> worklist = selectdao.selectWorkTime(weekDay, 0);// 工作时间
        for(WorkTime wk: worklist) {
        	if(wk.getStarthour() == hour && wk.getStartmin() <= min) {
        		return true;
        	}else if(wk.getEndhour() == hour && wk.getEndmin() >= min) {
        		return true;
        	}else if(wk.getStarthour() < hour && wk.getEndhour() > hour) {
        		return true;
        	}
        }
		return false;
	}
	
}
