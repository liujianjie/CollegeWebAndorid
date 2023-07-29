package com.ht.dao;

import java.util.List;
import java.util.Map;

import com.ht.pojo.People;

public interface PeopleDao {
	public People selPeople(Map<String, Object> map);
	//查询用户详细信息
	public People selectOnePeopleForIDcard(String userid);
}
