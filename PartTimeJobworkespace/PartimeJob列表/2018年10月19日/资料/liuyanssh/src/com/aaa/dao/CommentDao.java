package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Comment;
import com.aaa.util.PageEntity;


public interface CommentDao {
	 PageEntity getAllComment(PageEntity page);
	
		//�޸�
		void update(Comment  ct);
		//ɾ��
		void del(Comment  ct);
		//���
		void add(Comment  ct);
		//�õ�������Ϣ
		public List getct();
}
