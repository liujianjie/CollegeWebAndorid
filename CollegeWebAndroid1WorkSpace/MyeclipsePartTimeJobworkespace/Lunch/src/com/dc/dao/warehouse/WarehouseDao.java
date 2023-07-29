package com.dc.dao.warehouse;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface WarehouseDao {
	/**
	 * 确定出库
	 * @param warehouseid
	 */
	public void comfirmOut(String warehouseid);
	/**
	 * 新增出库详情单
	 * */
	public void insertLibrary(List list);
	/**
	 * 根据出库id查询出库信息
	 * @param warehouseid
	 * @return
	 */
	public Map findWarehouseById(String warehouseid);
	//查询员工
	public List findemp();
	/**
	 * 查询出库信息
	 * */
	public List selectLibraryMaterials2(String warehouseid);
	public List findWarehouse(Map map,PageEntity page);
	/**
	 * 修改出库信息
	 * */
	/*public void updateWarehouse(String caterialid,String number);*/
	/**
	 * 出库详情单
	 * */
	
	public List selectLibraryMaterials();
	/**
	 * 修改出库详情单
	 * */
	public void updateLibrary(List list,String warehouseid);
	/**
	 * 在出库详情单中显示出库人,出库时间,出库编号
	 * */
	public List selectList(String empid);
	/**
	 * 查询所有员工表
	 * */
	public List selectWare();
	/**
	 * 新增出库详情表
	 * @return 
	 * */
	public int insertWare(String empid);
}
