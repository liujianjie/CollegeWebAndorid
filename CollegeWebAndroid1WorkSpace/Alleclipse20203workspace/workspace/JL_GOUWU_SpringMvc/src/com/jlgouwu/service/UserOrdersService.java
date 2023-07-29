package com.jlgouwu.service;

import java.util.List;

import com.jlgouwu.pojo.Comment;
import com.jlgouwu.pojo.JRuser;
import com.jlgouwu.pojo.Orders;


public interface UserOrdersService {
	//�½��û�
	public boolean zhuce(JRuser jr); 
	
	//��¼��֤
	public boolean denglu(String uname,String pwd);
	
	//�Ƿ����uname
	public boolean cunzaiuname(String uname);
	
	//ͨ���û�����ѯ�û�
	public JRuser seljruser(String uname);
	
	//�µ�
	public boolean addorders(Orders order);
	
	//������Ϣ ��ҳ
	public List<Orders> selorders(int pageCount,int currPage,int jruser_id);
	
	public int selcountorders(int jruser_id);
	
	//��������
	public void alertsale(int g_id,int gwccount);
	
	//������֤
	public Orders xfyz(String xfm);
	
	//�޸�Ϊ2
	public boolean alertstatu(int orders_id);
	
	//��������
	public boolean addcomment(Comment co);
	
	//��ѯ���� ��ҳ
	public List<Comment> selcomment(int pageCount,int currPage,int gid);
	
	public int selcommentcount(int gid);
	
	//��ѯ�Ƿ���������Ʒ
	public boolean shifougm(int jruser_id,int g_id);
	
	//ͨ��jruser_id��ѯuname
	public JRuser seljruserpinglun(int jruser_id);

	
}
