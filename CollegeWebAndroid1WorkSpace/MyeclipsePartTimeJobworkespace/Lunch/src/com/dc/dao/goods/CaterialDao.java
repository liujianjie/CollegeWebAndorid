package com.dc.dao.goods;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
/**
 * 仓库材料
 * 马方伟
 * */
public interface CaterialDao {
	/**
	 * 查修所有材料的数量
	 * */
	public List findCaterial(Map map,PageEntity page);
	/**
	 * 新增材料
	 * */
	public int insertCaterial(String empid,String caterialname,String unit,String demand);
	/**
	 * 修改材料
	 * */
	public void updateCaterial(String caterialid,String demand);
	/**
	 * 查询材料
	 * */
	public Map fCaterial(String caterialid);
	//修改材料状态
	public boolean updatecaterial(String caterialname);
	
	/**
	 * 删除材料
	 * */
	public int deleteCarterial(String caterialid);
	/**
	 * 唯一性校验代码
	 */
	public boolean checkUserName2(String caterialid, String caterialname);
	/**
	 * 查询材料单位下拉框
	 * */
	public List selectUnit();

}
