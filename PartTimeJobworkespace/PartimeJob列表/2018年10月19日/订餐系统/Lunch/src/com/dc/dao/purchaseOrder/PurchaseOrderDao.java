package com.dc.dao.purchaseOrder;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;



public interface PurchaseOrderDao {
	/**
	 * 查询进库信息
	 * */
	public List findPurchase(PageEntity page);
	/**
	 * 根据出库id查询进库信息
	 * @param warehouseid
	 * @return
	 */
	public Map findPurchaseById(String poid);
	/**
	 * 进库详情表
	 * */
	public List selectPurchase();
	/**
	 * 进库详情2
	 * */
	public List selectPurchase2(String poid);
	/**
	 * 新增进库详情单
	 * */
	public void insertLibrary(List list);
	/**
	 * 修改进库详情单
	 * */
	public void updateLibrary(List list,String poid);
	/**
	 * 确定进库
	 * @param warehouseid
	 */
	public void comfirmOut(String poid);
	/**
	 * 在进库详情单中显示进库人,进库时间,进库编号
	 * */
	public List selectList(String empid);
	/**
	 * 查询所有员工表
	 * */
	public List selectWare();
	/**
	 * 新增出库详情表
	 * */

	public int insertWare(String empid);
	/**
	 * 查询员工姓名
	 * */
	public List findemp();
}
