package com.ht.daoi;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ht.bean.Replies;

public interface RepliesDaoI {
	//��ѯ�ظ��б�
	public List<Replies> selrep(Long id);
	//�������
	public int add(Replies re);
}
