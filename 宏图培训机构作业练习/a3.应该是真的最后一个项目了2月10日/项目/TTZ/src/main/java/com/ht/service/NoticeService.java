package com.ht.service;

import java.util.List;
import java.util.Map;

import com.ht.pojo.Notice;

/**
 * ����
 * */
public interface NoticeService {
	//indexչʾҳ ɸѡ5��
	public List<Notice> selnoticelistindex();
	
	public Notice getnoticeone(String id);
	
	public Map<String,Object> selnoticelist(Integer cpage);
	
	//��̨list
	public List<Notice> selnoticelistback();
}
