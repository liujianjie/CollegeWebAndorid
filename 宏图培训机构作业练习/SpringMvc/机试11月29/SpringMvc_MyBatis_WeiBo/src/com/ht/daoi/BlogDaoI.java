package com.ht.daoi;

import java.util.List;
import java.util.Map;

import com.ht.bean.Blog;
import com.ht.bean.Users;

public interface BlogDaoI {
	//总数数量
	public int selbloglistcount();
	//个人微博的总数量
	public int seluserblogcount(Integer id);
	//全部微博
	public List<Blog> selbloglist(Map<String, Object> map);
	//个人微博
	public List<Blog> seluserblog(Map<String, Object> map);
	public int addblog(Map<String, Object> map);
	public int delblog(Integer id);
}
