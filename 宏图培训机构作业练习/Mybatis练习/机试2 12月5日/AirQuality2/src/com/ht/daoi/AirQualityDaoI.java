package com.ht.daoi;

import java.util.List;
import java.util.Map;

import com.ht.bean.AirQualityBean;

public interface AirQualityDaoI {
	//ȫ������
	public int selcount();
	
	public List<AirQualityBean> selairlist(Map<String,Object> map);
	//����
	public List<AirQualityBean> selairlistofdid(Map<String,Object> map);
	//��������
	public int selcountofid(Integer id);
	//���
	public int addair(AirQualityBean air);
	//����
	public AirQualityBean airxq(Integer id);
	//�޸�
	public int alertair(AirQualityBean airs);
	//ɾ��
	public int delair(Integer id);
}
