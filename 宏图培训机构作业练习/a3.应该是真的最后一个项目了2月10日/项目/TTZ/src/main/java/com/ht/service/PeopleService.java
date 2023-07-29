package com.ht.service;

import java.util.List;
import java.util.Map;

import com.ht.pojo.People;

public interface PeopleService {
	public People selPeople(String pname, String pcard);

	// 查询用户详细信息
	public People selectOnePeopleForIDcard(String userid);
}
