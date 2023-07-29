                                                                                                                                                         package com.dc.dao.warehouse;

import java.sql.SQLClientInfoException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;

public class WarehouseDaoImpl implements WarehouseDao{
	/**
	 * 查询出库信息
	 * */
	
	public List findWarehouse(Map map,PageEntity page){
	BaseDAO base=new BaseDAO();
	StringBuffer sql=new StringBuffer();
	sql.append("select b.*,a.emp_user,(b.listid+NOW()) as listidinfo from emp_account a right join warehouse b on a.emp_id=b.emp_id");
	if(StringUtil.checkNotNull(map.get("empuser"))){
		String empuser=map.get("empuser").toString();
		sql.append(" where emp_user like '%"+empuser+"%'");
	}
	PageUtil pageUtil=new PageUtil();
	pageUtil.setpageinfo(sql, page);
	return page.getPagelist();
   }
	/**
	 * 根据出库id查询出库信息
	 * @param warehouseid
	 * @return
	 */
	public Map findWarehouseById(String warehouseid){
		StringBuffer sql=new StringBuffer();
		sql.append("select a.emp_user,b.warehouse_id,a.emp_id,date_format(b.date,'%Y-%m-%d') as date,(listid+NOW()) as listid " +
				" from warehouse b left join emp_account a on a.emp_id=b.emp_id" +
				" where b.warehouse_id=?");
		BaseDAO base=new BaseDAO();
		try {
			List list=base.selectInfo(sql.toString(), new Object[]{warehouseid});
			if(list!=null&&list.size()>0){
				return (Map) list.get(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HashMap();
	}
	
	
	/**
	 * 出库详情表
	 * */
	public List selectLibraryMaterials(){
		BaseDAO base=new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("select * from(select a.*,(demand*univalent) as total from caterial a)a");
		
		try {
			List list=base.selectInfo(sql.toString(), null);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
	public List selectLibraryMaterials2(String warehouseid){
		BaseDAO base=new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("select a.caterial_id, a.caterial_name,a.demand,a.unit,a.number,univalent,(demand*univalent) as total,b.ck_num from caterial a" +
				" left join warehouse_detail b on a.caterial_id=b.caterial_id  where 1=1 and b.warehouse_id=? ");
		
		try {
			List list=base.selectInfo(sql.toString(), new Object[]{warehouseid});
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 新增出库详情单
	 * */
	public void insertLibrary(List list){
		BaseDAO base=new BaseDAO();
		try {
			//将出库信息:比如说领取人,领取时间等新增到warehourse并返回主键
			int warehouseid=0;
			//执行库存保存前,先删除
			String sqlString="delete from warehouse_detail where warehouse_id=?";
 			base.updateSql(sqlString, new Object[]{warehouseid});
      			for(int i=0;i<list.size();i++){
				Map map=(Map)list.get(i);
				String caterialids=map.get("caterialid").toString();
				String demands=map.get("demand").toString();
				String cknum=map.get("cknum").toString();
				//如果没有录入信息的不执行出库
				if(StringUtil.checkNotNull(cknum)&&StringUtil.changeObjectToInt(cknum)>0){
					String sqlInsert="insert into warehouse_detail(warehouse_id,ck_num,kc_num,caterial_id)values(?,?,?,?)";
					base.updateSql(sqlInsert, new Object[]{warehouseid,cknum,demands,caterialids});
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 修改出库详情单
	 * */
	public void updateLibrary(List list,String warehouseid){
		BaseDAO base=new BaseDAO();
		
		try {
			//将出库信息:比如说领取人,领取时间等update更新到warehouse
			//执行库存保存前,先删除
			String sqlString="delete from warehouse_detail where warehouse_id=?";
			base.updateSql(sqlString, new Object[]{warehouseid});
			for(int i=0;i<list.size();i++){
				Map map=(Map)list.get(i);
				String caterialids=map.get("caterialid").toString();
				String demands=map.get("demand").toString();
				String cknum=map.get("cknum").toString();
				//如果没有录入信息的不执行出库
				if(StringUtil.checkNotNull(cknum)&&StringUtil.changeObjectToInt(cknum)>0){
					String sqlInsert="insert into warehouse_detail(warehouse_id,ck_num,kc_num,caterial_id)values(?,?,?,?)";
					base.updateSql(sqlInsert, new Object[]{warehouseid,cknum,demands,caterialids});
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 确定出库
	 * @param warehouseid
	 */
	public void comfirmOut(String warehouseid){
		BaseDAO base=new BaseDAO();
		
		String sql2=" select * from warehouse_detail where warehouse_id=?";
		try {
			List<HashMap> list=base.selectInfo(sql2, new Object[]{warehouseid});
			if(list!=null&&list.size()>0){
				for(Map map:list){
					String caterialids=map.get("caterial_id").toString();
					String cknum=map.get("ck_num").toString();
					String sql3="update caterial a set a.demand=a.demand-? where a.caterial_id=?";
					base.updateSql(sql3, new Object[]{cknum,caterialids});
				}
			}
			String sqlString="update warehouse set outstate=1 where warehouse_id=?";
			base.updateSql(sqlString, new Object[]{warehouseid});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 在出库详情单中显示出库人,出库时间,出库编号
	 * */
	public List selectList(String empid){
		BaseDAO base=new BaseDAO();
		String sql="select a.emp_id,a.emp_user,b.date,b.listid from emp_account a left join warehouse b on a.emp_id=b.emp_id where 1=1 and a.emp_id=?";
		try {
			List list=base.selectInfo(sql, new Object[]{empid});
			if(list!=null&&list.size()>0){
				return list;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询所有员工表
	 * */
	public List selectWare(){
		BaseDAO base=new BaseDAO();
		String sql="select * from emp_account";
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
	 * 新增出库详情表
	 * */

	public int insertWare(String empid){
		BaseDAO base=new BaseDAO();
		String sql="insert into warehouse (emp_id,date,listid,outstate) values (?,NOW(),NOW()+11,0)";
		try {
			int i=base.insertSql(sql, new Object[]{empid});
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 查询员工姓名
	 * */
	public List findemp() {
		// TODO Auto-generated method stub
		String sql="select emp_id ,emp_name from emp";
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
	
	}
