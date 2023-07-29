package com.dc.dao.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;
/**
 * 菜品管理
 * 马方伟
 **/
public class GoodsDaoImpl implements GoodsDao{
	/**
	 * 查询所有菜品
	 * */
	public List AllGoods(Map map,PageEntity page){
		BaseDAO base=new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("select a.meal_id,a.meal_type,a.meal_name,a.meal_price,a.meal_desc,a.meal_image,");
		sql.append(" case when c.meal_id is not null then '没有了' when b.meal_id is not null then '不足'  else '盈余' end as state");
		sql.append(" from meal a");
		sql.append(" left join(");
		sql.append(" select b.meal_id  from  meal_caterial b");
		sql.append(" join caterial c on b.caterial_id=c.caterial_id");
		sql.append(" where c.caterial_state=1");
		sql.append(" group by b.meal_id");
		sql.append(" )b on a.meal_id=b.meal_id ");
		sql.append(" left join(");
		sql.append(" select b.meal_id  from  meal_caterial b");
		sql.append(" join caterial c on b.caterial_id=c.caterial_id");
		sql.append(" where c.caterial_state=2");
		sql.append(" group by b.meal_id");
		sql.append(" )c on a.meal_id=c.meal_id");
		sql.append(" where 1=1");
		if(StringUtil.checkNotNull(map.get("mealname"))){
			String mealname=map.get("mealname").toString();
			sql.append(" and meal_name like '%"+mealname+"%'");
		}
		if(StringUtil.checkNotNull(map.get("mealprice"))){
			String mealprice=map.get("mealprice").toString();
			sql.append(" and meal_price like '%"+mealprice+"%' ");
		}
		PageUtil pageUtil=new PageUtil();
		pageUtil.setpageinfo(sql, page);
		return page.getPagelist();
	}
	/**
	 * 新增所有商品
	 * */
	public void insertAllGoods(String mealtype,String mealname,String mealbudget,String mealprice,String mealdesc,String mealimage){
		BaseDAO base=new BaseDAO();
		String sql="insert into meal (meal_type,meal_name,meal_budget,meal_price,meal_desc,meal_image) values (?,?,?,?,?,?)";
		try {
			int list=base.updateSql(sql, new Object[]{mealtype,mealname,mealbudget,mealprice,mealdesc,mealimage});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 唯一性校验代码
	 */
	public boolean checkUserName(String mealname,String mealid) {
		String sql="select * from meal where meal_name=?";
		//accountid不为空，代表我是修改不是新增
		/*if(mealid!=null&&!mealid.equals("")){
			sql=sql+" and meal_id!="+mealid;
		}*/
		BaseDAO base=new BaseDAO();
		// TODO Auto-generated method stub
		
		List list=null;
		try {
			list = base.selectInfo(sql, new Object[]{mealname});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list!=null&&list.size()>0){
			return true;
		}
		return false;
	}
	/**
	 * 修改所有商品
	 * */
	public void updateAllGoods(String mealid, String mealtype, String mealname,String mealbudget,String mealprice, String mealdesc,String mealimage){
		BaseDAO base=new BaseDAO();
		String sql="update meal set meal_type=?,meal_name=?,meal_budget=?,meal_price=?,meal_desc=?,meal_image=? where meal_id=?";
		try {
			int i=base.updateSql(sql, new Object[]{mealtype,mealname,mealbudget,mealprice,mealdesc,mealimage,mealid});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询商品信息
	 * */
	public Map findGoods(String mealid){
		BaseDAO base=new BaseDAO();
		String sql="select * from meal where meal_id=?";
		try {
			List<HashMap> list = base.selectInfo(sql, new Object[]{mealid});
			if(list!=null&&list.size()>0){
				return list.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * 查询菜品类型下拉框
	 * @return
	 */
	public List selectType(){
		String sql="select DISTINCT meal_type from meal";
		BaseDAO base=new BaseDAO();
		try {
			List list=base.selectInfo(sql, null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 删除商品信息
	 * */
	public int deleteGoods(String mealid){
		BaseDAO base=new BaseDAO();
		String sql="delete from meal where meal_id=?";
		try {
			int i=base.updateSql(sql, new Object[]{mealid});
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 查询菜品的所有材料
	 * */
	public List finCai(String mealid){
		BaseDAO base=new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("select a.*,c.*,case when a.meal_id is not null then 1 else 0 end as xz from meal a left join");
		sql.append(" meal_caterial b on a.meal_id=b.meal_id");
		sql.append(" join caterial c on b.caterial_id=c.caterial_id");
		sql.append(" and a.meal_id=?");
		try {
			List list=base.selectInfo(sql.toString(), new Object[]{mealid});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 通过材料ID进行先删除后添加的操作
	 */
	public int updateAllCai(String mealid, String[] caterialid) {
		System.out.println(mealid);
		BaseDAO base=new BaseDAO();
		String sql="delete from meal_caterial where meal_id=?";
		int b=0;
		try {
			base.updateSql(sql, new Object[]{mealid});
			if(caterialid!=null&&caterialid.length>0){
				for(int i=0;i<caterialid.length;i++){
					String fun=caterialid[i];
					String sql2="insert into meal_caterial (meal_id,caterial_id) values(?,?)";
					b+=base.updateSql(sql2, new Object[]{mealid,fun});
				}
				if(b==caterialid.length){
					return 1;
				}
			}else{
				return 0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	/**
	 * 查询所有材料
	 * */
	public List fCaterial(){
		BaseDAO base=new BaseDAO();
		String sql="select case when caterial_id is not null then 1 else 0 end as xz,caterial_name,caterial_id from caterial";
		try {
			List list=base.selectInfo(sql.toString(), null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 通过材料ID对材料进行先删除后添加的操作
	 */
	public int updateFindCaterial(String mealid, String[] caterialid) {
		BaseDAO base=new BaseDAO();
		String sql="insert into meal_caterial (meal_id,caterial_id) values(?,?)";
		int b=0;
		try {
			/*base.updateSql(sql, new Object[]{mealid});*/
			if(caterialid!=null&&caterialid.length>0){
				for(int i=0;i<caterialid.length;i++){
					String fun=caterialid[i];
					b+=base.updateSql(sql, new Object[]{mealid,fun});
				}
				if(b==caterialid.length){
					return 1;
				}
			}else{
				return 0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}

