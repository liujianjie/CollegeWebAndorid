package com.ht.service;

import java.io.Serializable;
import java.util.List;

import com.ht.vo5.Sback;
import com.ht.vo6.Msg;

public interface IStumainService {
	public List zhibanlist();
	public List lianxilist();
	//ֵ���ҳ
	public List zhibanlistpage(int start, int pageCount);
	//����֪ͨ
	public List tongzhilistpage(int start, int pageCount);
	//�������
	public List yijianlistpage(int start, int pageCount);
	//������ϵ�绰 
	public List lianxilistpage(int start, int pageCount);
	public Sback getsbk(Serializable id);
	//���๫����ϸ
	//��ѯ��������
	public Msg getMsgById(int id) ;
}
