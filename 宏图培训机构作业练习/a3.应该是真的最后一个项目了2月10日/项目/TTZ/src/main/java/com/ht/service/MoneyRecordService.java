package com.ht.service;

import java.util.List;

import java.util.Date;
import java.util.Map;

import com.ht.pojo.Bankcard;
import com.ht.pojo.MoneyRecord;

/**
 * �û��ʽ��׼�¼ service
 */
public interface MoneyRecordService {
	List<MoneyRecord> list(Map<String, Object> map);
	List<MoneyRecord> count(Map<String, Object> map);
	// ��ѯ��ֵ��¼
	public List TopupMoner();

	// ��ѯ��ֵ��¼
	public Integer TopupCount();

	// ��ѯ��������
	public Integer TradingCount();

	// ��ѯ���׼�¼
	public List TradingRecord();
	
	//������ѯ
	public List  ConditionQuery(Map<String, Object> map);

	List<MoneyRecord> countrow(String id);
	
	public void cunchu(Map<String, Object> map);

	public Bankcard sel_bank(String bank_id);
	//�Ӽ�¼��������ܽ��
	Double yxmoney(String p_userid);
	//��ѯ���ּ�¼
	public List<MoneyRecord> withdrawList();
	public List<MoneyRecord> wdListPage(Map<String, Object> map);//��ҳ��ѯ
	//���ҵ������ּ�¼
	public List<MoneyRecord> todayList();
	//���ұ������ּ�¼
	public List<MoneyRecord> weekList();
	//���ұ������ּ�¼
	public List<MoneyRecord> monthList();
	//���ҵ������ּ�¼
	public List<MoneyRecord> lastdayList();
	//���ұ������ּ�¼
	public List<MoneyRecord> lastweekList();
	//���ұ������ּ�¼
	public List<MoneyRecord> lastmonthList();

}
