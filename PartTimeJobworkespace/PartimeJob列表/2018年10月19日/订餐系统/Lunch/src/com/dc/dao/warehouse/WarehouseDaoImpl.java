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
	 * ��ѯ������Ϣ
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
	 * ���ݳ���id��ѯ������Ϣ
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
	 * ���������
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
	 * �����������鵥
	 * */
	public void insertLibrary(List list){
		BaseDAO base=new BaseDAO();
		try {
			//��������Ϣ:����˵��ȡ��,��ȡʱ���������warehourse����������
			int warehouseid=0;
			//ִ�п�汣��ǰ,��ɾ��
			String sqlString="delete from warehouse_detail where warehouse_id=?";
 			base.updateSql(sqlString, new Object[]{warehouseid});
      			for(int i=0;i<list.size();i++){
				Map map=(Map)list.get(i);
				String caterialids=map.get("caterialid").toString();
				String demands=map.get("demand").toString();
				String cknum=map.get("cknum").toString();
				//���û��¼����Ϣ�Ĳ�ִ�г���
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
	 * �޸ĳ������鵥
	 * */
	public void updateLibrary(List list,String warehouseid){
		BaseDAO base=new BaseDAO();
		
		try {
			//��������Ϣ:����˵��ȡ��,��ȡʱ���update���µ�warehouse
			//ִ�п�汣��ǰ,��ɾ��
			String sqlString="delete from warehouse_detail where warehouse_id=?";
			base.updateSql(sqlString, new Object[]{warehouseid});
			for(int i=0;i<list.size();i++){
				Map map=(Map)list.get(i);
				String caterialids=map.get("caterialid").toString();
				String demands=map.get("demand").toString();
				String cknum=map.get("cknum").toString();
				//���û��¼����Ϣ�Ĳ�ִ�г���
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
	 * ȷ������
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
	 * �ڳ������鵥����ʾ������,����ʱ��,������
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
	 * ��ѯ����Ա����
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
	 * �������������
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
	 * ��ѯԱ������
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
