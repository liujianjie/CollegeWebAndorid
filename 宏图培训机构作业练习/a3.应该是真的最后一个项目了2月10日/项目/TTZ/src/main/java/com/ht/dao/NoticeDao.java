package com.ht.dao;

import java.util.List;
import java.util.Map;

import com.ht.pojo.Notice;

/**
 * 公告
 * */
public interface NoticeDao {
	//index展示页 筛选5条
	public List<Notice> selnoticelistindex();
	
	public Notice getnoticeone(String id);
	//增加浏览次数
	public int addnoticecount(String id);
	
	public List<Notice> selnoticelist(Map<String,Object> map);
	//大小
	public int selnoticelistsize();
	
	//后台list
	public List<Notice> selnoticelistback();
	public int addnotice(Notice no);
	public int delnotice(String id);
	public int updnotice(Notice no);
}
