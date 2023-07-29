package com.experiment.service;

import java.util.List;

import com.experiment.bean.SystemUserBean;

public interface SystemUserServiceI {
	public boolean userregister(SystemUserBean user);//注册
	public int checkuser(SystemUserBean user);//检查是否有这个用户返回userid
	public List<SystemUserBean> seluserlist();//用户列表
	public void updatesystemuser(SystemUserBean user);//修改单个用户
	public boolean deletesystemuser(int userid);//删除单个用户
	public SystemUserBean getOneSystemUser(int userid);//获取单个用户
}
