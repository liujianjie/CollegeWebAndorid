package com.ht.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.PeopleDao;
import com.ht.pojo.People;
import com.ht.service.PeopleService;

@Service
public class PeopleServiceImpl implements PeopleService {

	@Resource
	private PeopleDao dao;

	@Override
	public People selPeople(String pname, String pcard) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pname", pname);
		map.put("pcard", pcard);
		// TODO Auto-generated method stub
		return dao.selPeople(map);
	}

	// 查询用户详细信息
	public People selectOnePeopleForIDcard(String userid) {
		return dao.selectOnePeopleForIDcard(userid);
	}

}
