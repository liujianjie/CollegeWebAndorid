package com.dc.dao.goods;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
/**
 * �ֿ����
 * ��ΰ
 * */
public interface CaterialDao {
	/**
	 * �������в��ϵ�����
	 * */
	public List findCaterial(Map map,PageEntity page);
	/**
	 * ��������
	 * */
	public int insertCaterial(String empid,String caterialname,String unit,String demand);
	/**
	 * �޸Ĳ���
	 * */
	public void updateCaterial(String caterialid,String demand);
	/**
	 * ��ѯ����
	 * */
	public Map fCaterial(String caterialid);
	//�޸Ĳ���״̬
	public boolean updatecaterial(String caterialname);
	
	/**
	 * ɾ������
	 * */
	public int deleteCarterial(String caterialid);
	/**
	 * Ψһ��У�����
	 */
	public boolean checkUserName2(String caterialid, String caterialname);
	/**
	 * ��ѯ���ϵ�λ������
	 * */
	public List selectUnit();

}
