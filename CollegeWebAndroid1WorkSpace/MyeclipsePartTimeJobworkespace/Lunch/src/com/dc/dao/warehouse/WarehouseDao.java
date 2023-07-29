package com.dc.dao.warehouse;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface WarehouseDao {
	/**
	 * ȷ������
	 * @param warehouseid
	 */
	public void comfirmOut(String warehouseid);
	/**
	 * �����������鵥
	 * */
	public void insertLibrary(List list);
	/**
	 * ���ݳ���id��ѯ������Ϣ
	 * @param warehouseid
	 * @return
	 */
	public Map findWarehouseById(String warehouseid);
	//��ѯԱ��
	public List findemp();
	/**
	 * ��ѯ������Ϣ
	 * */
	public List selectLibraryMaterials2(String warehouseid);
	public List findWarehouse(Map map,PageEntity page);
	/**
	 * �޸ĳ�����Ϣ
	 * */
	/*public void updateWarehouse(String caterialid,String number);*/
	/**
	 * �������鵥
	 * */
	
	public List selectLibraryMaterials();
	/**
	 * �޸ĳ������鵥
	 * */
	public void updateLibrary(List list,String warehouseid);
	/**
	 * �ڳ������鵥����ʾ������,����ʱ��,������
	 * */
	public List selectList(String empid);
	/**
	 * ��ѯ����Ա����
	 * */
	public List selectWare();
	/**
	 * �������������
	 * @return 
	 * */
	public int insertWare(String empid);
}
