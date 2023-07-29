package com.camera.service;

import org.springframework.stereotype.Service;

import com.camera.pojo.WorkTime;


public interface SetTimeService {
	public int insertWorkTime(WorkTime worktime);
}
