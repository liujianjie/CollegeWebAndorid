package com.ht.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ht.vo6.Msg;

public interface ITongZhiService {
	//��ѯԱ��֪ͨ
	public List TongZhilist1();
	//��ѧ��֪ͨ
	public List TongZhilist2();
	//��ѯ�ѷ���Ա��֪ͨ
	public List TongZhilist3();
	//��ѯ�ѷ���ѧ��֪ͨ
	public List TongZhilist4();
	
	
	public boolean TongZhidel(Msg msgid);
	public Msg getMsgById(int id);
	//��ѯ����Ա��
	public List findAllEmp();
	//��ӹ���
	public boolean TongZhiadd(Msg msg);
	
	public boolean delte(Msg id);
	public boolean tongzhiget(Msg id);
	public boolean upd(Msg msg);
	public List xq(Msg msg);
	public List release();
	//���ķ���״̬
	public boolean updStatus(int id);
	//���淢��ʱ��
	public boolean saveFabuTime(int id,String t);
	//ɾ��֪ͨ;
	public boolean delTongzhi(Msg m);
	//�޸�֪ͨ
	public boolean updTongzhi(Msg m);
	//��֪ͨ����
	public List selTongzhiType(int id);
	
	//g���ķ�����
	public boolean upd_faburen(int id,String fuburen);
	
} 
