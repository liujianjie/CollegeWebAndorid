package com.ht.dao;

import java.util.List;
import java.util.Map;

import com.ht.pojo.Forengmessage;

public interface ForengmessageDao {
	// ���빫��
	public int insertForengmessage(Forengmessage fore);

	// ����ȫ������
	public List<Forengmessage> selectAllMsg(Map<String, Object> map);

	// ����������
	public int countAllMsg(String userid);
}
