package com.dc.dao.purchaseOrder;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;



public interface PurchaseOrderDao {
	/**
	 * ��ѯ������Ϣ
	 * */
	public List findPurchase(PageEntity page);
	/**
	 * ���ݳ���id��ѯ������Ϣ
	 * @param warehouseid
	 * @return
	 */
	public Map findPurchaseById(String poid);
	/**
	 * ���������
	 * */
	public List selectPurchase();
	/**
	 * ��������2
	 * */
	public List selectPurchase2(String poid);
	/**
	 * �����������鵥
	 * */
	public void insertLibrary(List list);
	/**
	 * �޸Ľ������鵥
	 * */
	public void updateLibrary(List list,String poid);
	/**
	 * ȷ������
	 * @param warehouseid
	 */
	public void comfirmOut(String poid);
	/**
	 * �ڽ������鵥����ʾ������,����ʱ��,������
	 * */
	public List selectList(String empid);
	/**
	 * ��ѯ����Ա����
	 * */
	public List selectWare();
	/**
	 * �������������
	 * */

	public int insertWare(String empid);
	/**
	 * ��ѯԱ������
	 * */
	public List findemp();
}
