package com.ht.service;

import java.util.List;

import com.ht.bean.Replies;

public interface RepliesI {
	//��ѯ�ظ��б�
	public List<Replies> selrep(Long id);
	//�������
	public int add(Replies re);
}
