package com.ht.service;

import java.util.List;
import java.util.Map;

import com.ht.bean.Blog;


public interface BlogI {
	public int selbloglistcount();
	//����΢����������
	public int seluserblogcount(Integer id);
	public List<Blog> selbloglist(Map<String, Object> map);
	public List<Blog> seluserblog(Map<String, Object> map);
	public int addblog(Map<String, Object> map);
	public int delblog(Integer id);
}
