package com.dc.dao.goods;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
/**
 * ��Ʒ����
 * ��ΰ
 **/
public interface GoodsDao {
	/**
	 * ��ѯ������Ʒ
	 * */
	public List AllGoods(Map map,PageEntity page);
	/**
	 * ������Ʒ
	 * */
	public void insertAllGoods(String mealtype,String mealname,String mealbudget,String mealprice,String mealdesc,String mealimage);
	/**
	 * Ψһ��У�����
	 */
	public boolean checkUserName(String mealname,String mealid);
	/**
	 * �޸�������Ʒ
	 * */
	public void updateAllGoods(String mealid, String mealtype, String mealname,String mealbudget,String mealprice, String mealdesc,String mealimage);
	/**
	 * ��ѯ��Ʒ
	 * */
	public Map findGoods(String mealid);
	/**
	 * ɾ����Ʒ��Ϣ
	 * */
	public int deleteGoods(String mealid);
	/**
	 * ��ѯ��Ʒ����
	 * @return
	 */
	public List selectType();
	/**
	 * ��ѯ��Ʒ�����в���
	 * */
	public List finCai(String mealid);
	/**
	 * ͨ������ID������ɾ������ӵĲ���
	 */
	public int updateAllCai(String mealid, String[] caterialid);
	
	/**
	 * ��ѯ���в���
	 * */
	public List fCaterial();
	/**
	 * ͨ������ID�Բ��Ͻ�����ɾ������ӵĲ���
	 */
	public int updateFindCaterial(String mealid, String[] caterialid);
}