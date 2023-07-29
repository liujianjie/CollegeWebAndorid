package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Comment;
import com.aaa.util.PageEntity;


public interface CommentDao {
	 PageEntity getAllComment(PageEntity page);
	
		//修改
		void update(Comment  ct);
		//删除
		void del(Comment  ct);
		//添加
		void add(Comment  ct);
		//得到评论信息
		public List getct();
}
