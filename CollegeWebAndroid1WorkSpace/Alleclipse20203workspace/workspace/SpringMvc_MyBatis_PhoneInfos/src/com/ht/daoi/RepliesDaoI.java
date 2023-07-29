package com.ht.daoi;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ht.bean.Replies;

public interface RepliesDaoI {
	//查询回复列表
	public List<Replies> selrep(Long id);
	//添加评论
	public int add(Replies re);
}
