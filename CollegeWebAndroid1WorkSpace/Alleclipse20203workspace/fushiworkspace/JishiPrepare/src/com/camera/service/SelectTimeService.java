package com.camera.service;

import org.springframework.stereotype.Service;

public interface SelectTimeService {
	// 查询时间段是否工作
	public boolean selctTimeIsWork(String datetime);
}
