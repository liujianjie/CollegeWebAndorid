package service_userorders;

import java.util.List;

import bean.JRuserBean;
import bean.OrdersBean;
import bean.CommentBean;

public interface IUserOrders {
	//新建用户
	public boolean zhuce(JRuserBean jr); 
	
	//登录验证
	public boolean denglu(String uname,String pwd);
	
	//是否存在uname
	public boolean cunzaiuname(String uname);
	
	//通过用户名查询用户
	public JRuserBean seljruser(String uname);
	
	//下单
	public boolean addorders(OrdersBean order);
	
	//订单信息 分页
	public List selorders(int pageCount,int currPage,int jruser_id);
	
	public int selcountorders(int jruser_id);
	
	//增加销量
	public void alertsale(int g_id,int gwccount);
	
	//消费验证
	public OrdersBean xfyz(String xfm);
	
	//修改为2
	public boolean alertstatu(int orders_id);
	
	//新增评论
	public boolean addcomment(CommentBean co);
	
	//查询评论 分页
	public List selcomment(int pageCount,int currPage,int gid);
	
	public int selcommentcount(int gid);
	
	//查询是否买过这个商品
	public boolean shifougm(int jruser_id,int g_id);
	
	//通过jruser_id查询uname
	public JRuserBean seljruserpinglun(int jruser_id);

	
}
