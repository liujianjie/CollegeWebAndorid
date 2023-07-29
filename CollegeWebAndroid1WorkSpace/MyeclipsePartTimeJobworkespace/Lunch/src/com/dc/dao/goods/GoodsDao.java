package com.dc.dao.goods;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
/**
 * 菜品管理
 * 马方伟
 **/
public interface GoodsDao {
	/**
	 * 查询所有商品
	 * */
	public List AllGoods(Map map,PageEntity page);
	/**
	 * 新增商品
	 * */
	public void insertAllGoods(String mealtype,String mealname,String mealbudget,String mealprice,String mealdesc,String mealimage);
	/**
	 * 唯一性校验代码
	 */
	public boolean checkUserName(String mealname,String mealid);
	/**
	 * 修改所有商品
	 * */
	public void updateAllGoods(String mealid, String mealtype, String mealname,String mealbudget,String mealprice, String mealdesc,String mealimage);
	/**
	 * 查询商品
	 * */
	public Map findGoods(String mealid);
	/**
	 * 删除商品信息
	 * */
	public int deleteGoods(String mealid);
	/**
	 * 查询菜品类型
	 * @return
	 */
	public List selectType();
	/**
	 * 查询菜品的所有材料
	 * */
	public List finCai(String mealid);
	/**
	 * 通过材料ID进行先删除后添加的操作
	 */
	public int updateAllCai(String mealid, String[] caterialid);
	
	/**
	 * 查询所有材料
	 * */
	public List fCaterial();
	/**
	 * 通过材料ID对材料进行先删除后添加的操作
	 */
	public int updateFindCaterial(String mealid, String[] caterialid);
}