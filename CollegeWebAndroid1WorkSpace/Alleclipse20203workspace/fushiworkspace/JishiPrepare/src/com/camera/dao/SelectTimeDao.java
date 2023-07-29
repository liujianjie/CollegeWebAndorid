package com.camera.dao;

import java.util.List;

import com.camera.pojo.WorkTime;

public interface SelectTimeDao {
	public List<WorkTime> selectWorkTime(Integer day, Integer type);
}
