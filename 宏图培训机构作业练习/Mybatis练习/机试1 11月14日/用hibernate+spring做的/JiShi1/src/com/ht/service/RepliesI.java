package com.ht.service;

import java.util.List;

import com.ht.bean.Replies;

public interface RepliesI {
	//��ѯ�ظ��б�
	public List selrep(Long id);
	//�������
	public boolean add(Replies re);
}
