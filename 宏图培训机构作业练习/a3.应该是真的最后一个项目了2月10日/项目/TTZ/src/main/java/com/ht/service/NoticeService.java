package com.ht.service;

import java.util.List;
import java.util.Map;

import com.ht.pojo.Notice;

/**
 * 公告
 * */
public interface NoticeService {
	//index展示页 筛选5条
	public List<Notice> selnoticelistindex();
	
	public Notice getnoticeone(String id);
	
	public Map<String,Object> selnoticelist(Integer cpage);
	
	//后台list
	public List<Notice> selnoticelistback();
}
