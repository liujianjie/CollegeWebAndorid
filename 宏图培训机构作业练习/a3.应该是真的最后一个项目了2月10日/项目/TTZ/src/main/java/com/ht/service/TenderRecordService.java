package com.ht.service;

import java.util.List;
import java.util.Map;

import com.ht.pojo.MoneyRecord;
import com.ht.pojo.TenderRecord;

public interface TenderRecordService {
	public List TenderRecordList(Map<String, Object> map);// ��ѯ�����еı�

	public int SelTenderRecord(Map<String, Object> map);

	public int TenderRecoreAmount();// ��ѯ������Ͷ�ʽ��

	public List TenderRecordCompleted(Map<String, Object> map);// ��ѯ����ɵı�

	public int SelTenderRecordCompleted(Map<String, Object> map);

	public int TenderRecordEarnings();// ����

	public int TenderRecordPoundage();// ������

	public int TenderRecordZhong(); // �б��� ��Ͷ����

	public int TenderRecordSum();// Ͷ�ʽ��

	public Double selTenderSumMoney();

	public List SelHuiKuan(Map<String, Object> map);// ��ѯ�ؿ��¼

	public int SelHuiKuanCount(Map<String, Object> map);

	public List MoHuSelTenderRecord(Map<String, Object> map);// ģ����ѯ

	public List<TenderRecord> sel_tend_list(Map<String, Object> map);

	public List SelMoneyRecord(Map<String, Object> map);// ��ѯ�ʽ��¼

	public int SelMoneyRecordCount(Map<String, Object> map);// ��ѯ�ʽ��¼����

	public List TouZiJilu(Map<String, Object> map);// ��ѯͶ�ʼ�¼

	public int TouZiJiluCount(Map<String, Object> map);// ��ѯͶ�ʼ�¼����

	public List SelMoneyRecordByID(String p_userid);

	public int SumMoney();

	public List<TenderRecord> selectTenderRecordstatu0(Map<String, Object> map);

	public int selectTenderRecordstatu0Count(String userid);

	// ����Ͷ�ʵ�״̬()ծȨת����
	public int updateTenderRecordstatu5(String tender_id);

	// ծȨת�ú�����µ�Ͷ��
	public int insertTenderRecord(TenderRecord ten);

	// ��ѯ����Ͷ��
	public TenderRecord selectOneTenderRecordForTender_id(String tender_id);

	// ����Ͷ�ʵ�״̬()ծȨת�����
	public int updateTenderRecordstatu6(String tender_id);
	
	//��ѯͶ�ʽ��ǰ����
	public List SumlistMoney();
	
	//��ѯͶ�ʽ��ǰ����
	public List SumInterest();
}
