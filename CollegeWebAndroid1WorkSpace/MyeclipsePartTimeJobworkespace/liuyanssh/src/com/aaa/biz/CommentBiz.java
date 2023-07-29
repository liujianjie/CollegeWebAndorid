package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Comment;
import com.aaa.util.PageEntity;


public interface CommentBiz {
	 PageEntity getAllComment(PageEntity page);
	
		//�޸�
		void update(Comment  ct);
		//ɾ��
		void del(Comment  ct);
		//���
		void add(Comment  ct);
		//�õ�������Ϣ
		public List getct();
		
		void delById(Integer id);
}
