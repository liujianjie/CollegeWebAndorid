package com.jlgouwu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jlgouwu.service.UserOrdersService;
import com.jlgouwu.dao.UserOrdersDao;
import com.jlgouwu.pojo.Comment;
import com.jlgouwu.pojo.JRuser;
import com.jlgouwu.pojo.Orders;
@Service
public class UserOrdersImp implements UserOrdersService{
	
	@Resource
	UserOrdersDao userOrdersDao;
	public boolean zhuce(JRuser jr) {
		return userOrdersDao.zhuce(jr) > 0 ? true : false;
	}

	public boolean denglu(String uname, String pwd) {
		return userOrdersDao.denglu(uname, pwd) > 0 ? true : false;
	}

	public JRuser seljruser(String uname) {
		return userOrdersDao.seljruser(uname);
	}

	public boolean addorders(Orders order) {
		return userOrdersDao.addorders(order) > 0 ? true : false;
	}

	public List selorders(int pagecount,int currpage,int jruser_id) {
		int zero = (currpage - 1) * pagecount;
		int first = pagecount;
		int second = jruser_id;
		return userOrdersDao.selorders(zero, first, second);
	}

	public void alertsale(int g_id, int gwccount) {
		userOrdersDao.alertsale(g_id, gwccount);
	}

	public Orders xfyz(String xfm) {
		return userOrdersDao.xfyz(xfm);
	}

	public boolean alertstatu(int orders_id) {
		return userOrdersDao.alertstatu(orders_id) > 0 ? true : false;
	}

	public boolean addcomment(Comment co) {

		return userOrdersDao.addcomment(co) > 0 ? true : false;
	}

	public List selcomment(int pagecount,int currpage,int gid) {
		int zero = (currpage - 1) * pagecount;
		int first = pagecount;
		int second = gid;
		return userOrdersDao.selcomment(zero, first, second);
	}

	public int selcommentcount(int gid) {
		return userOrdersDao.selcommentcount(gid);
	}

	public JRuser seljruserpinglun(int jruser_id) {
		return userOrdersDao.seljruserpinglun(jruser_id);
	}

	public boolean cunzaiuname(String uname) {
		return userOrdersDao.cunzaiuname(uname) > 0 ? true : false;
	}

	public boolean shifougm(int jruser_id, int g_id) {
		return userOrdersDao.shifougm(jruser_id, g_id) > 0 ? true : false;
	}

	public int selcountorders(int jruser_id) {
		return userOrdersDao.selcountorders(jruser_id);
	}

}
