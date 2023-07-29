package com.ht.service;

import java.util.List;
import java.util.Map;

import com.ht.pojo.Forengmessage;

public interface ForengmessageService {
	// 插入公告
	public int insertForengmessage(Forengmessage fore);

	// 查找全部公告
	public List<Forengmessage> selectAllMsg(Map<String, Object> map);

	// 公告总条数
	public int countAllMsg(String userid);
}
