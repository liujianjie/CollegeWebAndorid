package com.ht.daoi;

import java.util.List;
import java.util.Map;

import com.ht.bean.Blog;
import com.ht.bean.Users;

public interface BlogDaoI {
	//��������
	public int selbloglistcount();
	//����΢����������
	public int seluserblogcount(Integer id);
	//ȫ��΢��
	public List<Blog> selbloglist(Map<String, Object> map);
	//����΢��
	public List<Blog> seluserblog(Map<String, Object> map);
	public int addblog(Map<String, Object> map);
	public int delblog(Integer id);
}
