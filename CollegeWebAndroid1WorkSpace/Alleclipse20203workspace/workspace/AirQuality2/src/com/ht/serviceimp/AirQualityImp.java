package com.ht.serviceimp;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.bean.AirQualityBean;
import com.ht.daoi.AirQualityDaoI;
import com.ht.service.AirQualityI;

@Service
public class AirQualityImp implements AirQualityI{
	@Resource
	AirQualityDaoI air;
	
	@Override
	public List<AirQualityBean> selairlist(Map<String,Object> map) {
		
		return air.selairlist(map);
	}

	@Override
	public List<AirQualityBean> selairlistofdid(Map<String,Object> map) {
		return air.selairlistofdid(map);
	}
	public int selcountofid(Integer id){
		return air.selcountofid(id);
	}

	@Override
	public int addair(AirQualityBean airs) {
		// TODO 自动生成的方法存根
		return air.addair(airs);
	}

	@Override
	public AirQualityBean airxq(Integer id) {
		// TODO 自动生成的方法存根
		return air.airxq(id);
	}

	@Override
	public int alertair(AirQualityBean airs) {
		return air.alertair(airs);
	}

	@Override
	public int delair(Integer id) {
		return air.delair(id);
	}

	@Override
	public int selcount() {
		return air.selcount();
	}

	
}
