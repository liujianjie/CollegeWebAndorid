package com.ht.dao;

import java.util.List;
import java.util.Map;

import com.ht.pojo.Notice;

/**
 * ����
 * */
public interface NoticeDao {
	//indexչʾҳ ɸѡ5��
	public List<Notice> selnoticelistindex();
	
	public Notice getnoticeone(String id);
	//�����������
	public int addnoticecount(String id);
	
	public List<Notice> selnoticelist(Map<String,Object> map);
	//��С
	public int selnoticelistsize();
	
	//��̨list
	public List<Notice> selnoticelistback();
	public int addnotice(Notice no);
	public int delnotice(String id);
	public int updnotice(Notice no);
}
