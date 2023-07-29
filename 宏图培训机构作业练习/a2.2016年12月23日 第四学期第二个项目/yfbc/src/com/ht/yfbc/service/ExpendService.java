package com.ht.yfbc.service;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Expend;

public interface ExpendService {
	public void addExpend(Expend expend);
	public List<Expend> selExpendListByMap(String exptime);
	public List<Expend> selExpendList();
	public List<Expend> findExpendList(Map<String, Object> map);
	public int delExpend(String id);
	public int updExpend(Expend expend);
	public Expend selExpendById(String id);
	public int selCount();
	public Double selexpend(String time);
}
