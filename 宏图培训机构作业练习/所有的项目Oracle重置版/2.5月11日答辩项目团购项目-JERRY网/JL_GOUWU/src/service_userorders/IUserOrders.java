package service_userorders;

import java.util.List;

import bean.JRuserBean;
import bean.OrdersBean;
import bean.CommentBean;

public interface IUserOrders {
	//�½��û�
	public boolean zhuce(JRuserBean jr); 
	
	//��¼��֤
	public boolean denglu(String uname,String pwd);
	
	//�Ƿ����uname
	public boolean cunzaiuname(String uname);
	
	//ͨ���û�����ѯ�û�
	public JRuserBean seljruser(String uname);
	
	//�µ�
	public boolean addorders(OrdersBean order);
	
	//������Ϣ ��ҳ
	public List selorders(int pageCount,int currPage,int jruser_id);
	
	public int selcountorders(int jruser_id);
	
	//��������
	public void alertsale(int g_id,int gwccount);
	
	//������֤
	public OrdersBean xfyz(String xfm);
	
	//�޸�Ϊ2
	public boolean alertstatu(int orders_id);
	
	//��������
	public boolean addcomment(CommentBean co);
	
	//��ѯ���� ��ҳ
	public List selcomment(int pageCount,int currPage,int gid);
	
	public int selcommentcount(int gid);
	
	//��ѯ�Ƿ���������Ʒ
	public boolean shifougm(int jruser_id,int g_id);
	
	//ͨ��jruser_id��ѯuname
	public JRuserBean seljruserpinglun(int jruser_id);

	
}
