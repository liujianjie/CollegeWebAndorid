package com.ht.dao;

import java.util.List;
import java.util.Map;

import com.ht.pojo.People;

public interface PeopleDao {
	public People selPeople(Map<String, Object> map);
	//��ѯ�û���ϸ��Ϣ
	public People selectOnePeopleForIDcard(String userid);
}
