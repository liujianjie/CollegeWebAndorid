package com.ht.dao;

import java.util.List;
import java.util.Map;

import com.ht.pojo.Borrowmoney;
import com.ht.pojo.Borrowmoney2;
import com.ht.pojo.TenderRecord;

public interface BorrowmoneyDao {
	public List<Borrowmoney> selBorrow(String id);

	public List<Borrowmoney> selAllBorrow();

	public Borrowmoney selBorrowByid(String id);

	public int Insertborrow(Borrowmoney bro);

	public int updBorrowStatu(Map map);

	// ����ʱ��ε�ʱ���ѯ
	public List<Borrowmoney2> selBorrowMoneySomeList(Map<String, Object> map);

	// ������д Ϊ�˲�ѯ�����Ϣ��2��23�� -���н����Ϣ���б��������ֶΣ������������ֶ� ��������Ͱ� Ҫ��ҳ
	public List<Borrowmoney> selMoreBorrowMoneySomeList(Map<String, Object> map);

	public int selBorrowListsize();// size

	// ������ѯ
	public List<Borrowmoney> selMoreBorrowMoneySomeListWhere(Map<String, Object> map);

	public int selBorrowListWheresize(Map<String, Object> map);// ������ѯ��С

	public Borrowmoney getBorrowMoney(String id);

	// ���Ľ���Ͷ���ܶ� ��Ͷ�� �����ʽ��¼ ��Ͷ�ʼ�¼������ ���ô洢����
	public int goBorrowmoneyTZ(Map<String, Object> map);

	// ���Ľ��� ��������
	public int updateBorrowmoneyTJ(Map<String, Object> map);

	// ��ѯ����Ľ��
	public List selBorrowMoneymb();

	// ���ݽ��id���Ҹñʽ�������Ͷ��
	public List<TenderRecord> selectTenderRecordForT_ID(String t_id);

	public List<Borrowmoney> sel_borrow();// �б�

	// ����
	public int Tohuankuang(Map<String, Object> map);

	// ���� ��Ͷ��������
	public int TohuankuangSY(Map<String, Object> map);

	// vip����Ϣ����
	public int InsertVipborrow(Borrowmoney bro);

	// �����Ͳ��ҽ��(vip��)
	public List<Borrowmoney> selectBorrowMoneyVip(Map<String, Object> map);

	// ����vip�ŵ�״̬(10 ���� 11����)
	public int updateVipBorrowmoney(Map<String, Object> map);

	// ���ҷ����е�ɢ��
	public List<Borrowmoney> selectBorrowMoneyOnStatu2();

	// vip��Ͷ��
	public int goBorrowmoneyVipTZ(Map<String, Object> map);
	
	//��ҳͳ��ͼ
	public List<Borrowmoney> selTongji();

	// ����ծȨת����Ϣ
	public int InsertZaiQuanborrow(Borrowmoney bro);

	// ���ҷ����ŵ�ծȨ��Ѻ��� 12ծȨ��Ѻ��
	public List<Borrowmoney> selectBorrowMoneyZaiQuanstatu12();
	
	//����ծȨ
	public int goBorrowmoneyZaiquan(Map<String, Object> map);
	
	//������ѯ�����Ϣ
	public List<Borrowmoney> sel_borrow_statu(Map<String, Object> map);

}
