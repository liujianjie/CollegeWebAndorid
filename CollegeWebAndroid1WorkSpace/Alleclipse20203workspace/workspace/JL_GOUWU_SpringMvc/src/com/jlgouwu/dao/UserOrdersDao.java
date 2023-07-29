package com.jlgouwu.dao;

import java.util.List;

import com.jlgouwu.pojo.Comment;
import com.jlgouwu.pojo.JRuser;
import com.jlgouwu.pojo.Orders;


public interface UserOrdersDao {
	//新建用户
	public int zhuce(JRuser jr); 
	
	//登录验证
	public int denglu(String uname,String pwd);
	
	//是否存在uname
	public int cunzaiuname(String uname);
	
	//通过用户名查询用户
	public JRuser seljruser(String uname);
	
	//下单
	public int addorders(Orders order);
	
	//订单信息 分页
	public List<Orders> selorders(int pageCount,int currPage,int jruser_id);
	
	public int selcountorders(int jruser_id);
	
	//增加销量
	public void alertsale(int g_id,int gwccount);
	
	//消费验证
	public Orders xfyz(String xfm);
	
	//修改为2
	public int alertstatu(int orders_id);
	
	//新增评论
	public int addcomment(Comment co);
	
	//查询评论 分页
	public List<Comment> selcomment(int pageCount,int currPage,int gid);
	
	public int selcommentcount(int g_id);
	
	//查询是否买过这个商品
	public int shifougm(int jruser_id,int g_id);
	
	//通过jruser_id查询uname
	public JRuser seljruserpinglun(int jruser_id);

	
}
