package com.experiment.service;

import java.util.List;

import com.experiment.bean.SystemUserBean;

public interface SystemUserServiceI {
	public boolean userregister(SystemUserBean user);//ע��
	public int checkuser(SystemUserBean user);//����Ƿ�������û�����userid
	public List<SystemUserBean> seluserlist();//�û��б�
	public void updatesystemuser(SystemUserBean user);//�޸ĵ����û�
	public boolean deletesystemuser(int userid);//ɾ�������û�
	public SystemUserBean getOneSystemUser(int userid);//��ȡ�����û�
}
