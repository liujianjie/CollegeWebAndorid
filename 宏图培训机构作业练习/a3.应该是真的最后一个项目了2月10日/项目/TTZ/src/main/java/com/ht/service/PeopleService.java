package com.ht.service;

import java.util.List;
import java.util.Map;

import com.ht.pojo.People;

public interface PeopleService {
	public People selPeople(String pname, String pcard);

	// ��ѯ�û���ϸ��Ϣ
	public People selectOnePeopleForIDcard(String userid);
}
