package com.ht.service;

import java.util.List;


import com.ht.pojo.Post;

/**
 * 岗位
 * */

public interface PostService {
	//查询
	public List<Post> selpostlist();
	//岗位添加 和删除
	public int addpost(Post post);
	public int delpost(String id);
	//查找
	public Post getpost(String id);
	//修改
	public int updpost(Post post);
	
}
