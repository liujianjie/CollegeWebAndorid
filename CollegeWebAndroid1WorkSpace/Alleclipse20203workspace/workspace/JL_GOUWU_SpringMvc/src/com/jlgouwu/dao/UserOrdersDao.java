package com.jlgouwu.dao;

import java.util.List;

import com.jlgouwu.pojo.Comment;
import com.jlgouwu.pojo.JRuser;
import com.jlgouwu.pojo.Orders;


public interface UserOrdersDao {
	//�½��û�
	public int zhuce(JRuser jr); 
	
	//��¼��֤
	public int denglu(String uname,String pwd);
	
	//�Ƿ����uname
	public int cunzaiuname(String uname);
	
	//ͨ���û�����ѯ�û�
	public JRuser seljruser(String uname);
	
	//�µ�
	public int addorders(Orders order);
	
	//������Ϣ ��ҳ
	public List<Orders> selorders(int pageCount,int currPage,int jruser_id);
	
	public int selcountorders(int jruser_id);
	
	//��������
	public void alertsale(int g_id,int gwccount);
	
	//������֤
	public Orders xfyz(String xfm);
	
	//�޸�Ϊ2
	public int alertstatu(int orders_id);
	
	//��������
	public int addcomment(Comment co);
	
	//��ѯ���� ��ҳ
	public List<Comment> selcomment(int pageCount,int currPage,int gid);
	
	public int selcommentcount(int g_id);
	
	//��ѯ�Ƿ���������Ʒ
	public int shifougm(int jruser_id,int g_id);
	
	//ͨ��jruser_id��ѯuname
	public JRuser seljruserpinglun(int jruser_id);

	
}
