package com.ht.service;

import java.util.List;

import com.ht.bean.Replies;

public interface RepliesI {
	//查询回复列表
	public List selrep(Long id);
	//添加评论
	public boolean add(Replies re);
}
