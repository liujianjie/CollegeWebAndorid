package com.dc.dao.purchaseOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;



public class PurchaseOrderDaoImpl implements PurchaseOrderDao{
	/**
	 * ��ѯ������Ϣ
	 * */
	public List findPurchase(PageEntity page){
		BaseDAO base=new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT * from (");
		sql.append(" select a.emp_user,(b.listid+NOW()) as listidinfo,b.* from emp_account a right join purchaseorder b on a.emp_id=b.emp_id )a");
		PageUtil pageUtil=new PageUtil();
		pageUtil.setpageinfo(sql, page);
		return page.getPagelist();
	}
	
	/**
	 * ���ݳ���id��ѯ������Ϣ
	 * @param poid
	 * @return
	 */
	public Map findPurchaseById(String poid){
		StringBuffer sql=new StringBuffer();
		sql.append("select a.emp_user,b.poid,a.emp_id,date_format(b.date,'%Y-%m-%d') as date,(listid+NOW()) as listid " +
				" from purchaseorder b left join emp_account a on a.emp_id=b.emp_id " +
				" where b.poid=?");
		BaseDAO base=new BaseDAO();
		try {
			List list=base.selectInfo(sql.toString(), new Object[]{poid});
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
	public List selectPurchase(){
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
	/**
	 * ��������2
	 * */
	public List selectPurchase2(String poid){
		BaseDAO base=new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("select a.caterial_id,a.caterial_name,a.demand,a.unit,a.number,univalent,(demand*univalent) as total,b.ck_num from caterial a " +
				" left join purchaseorder_enter b on a.caterial_id=b.caterial_id where 1=1 and b.poid=? ");
		
		try {
			List list=base.selectInfo(sql.toString(), new Object[]{poid});
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
			int poid=0;
			//ִ�п�汣��ǰ,��ɾ��
			String sqlString="delete from purchaseorder_enter where poid=?";
 			base.updateSql(sqlString, new Object[]{poid});
      			for(int i=0;i<list.size();i++){
				Map map=(Map)list.get(i);
				String poids=map.get("poid").toString();
				String demands=map.get("demand").toString();
				String cknum=map.get("cknum").toString();
				//���û��¼����Ϣ�Ĳ�ִ�г���
				if(StringUtil.checkNotNull(cknum)&&StringUtil.changeObjectToInt(cknum)>0){
					String sqlInsert="insert into purchaseorder_enter(poid,ck_num,kc_num,caterial_id)values(?,?,?,?)";
					base.updateSql(sqlInsert, new Object[]{poid,cknum,demands,poids});
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * �޸Ľ������鵥
	 * */
	public void updateLibrary(List list,String poid){
		BaseDAO base=new BaseDAO();
		
		try {
			//��������Ϣ:����˵��ȡ��,��ȡʱ���update���µ�warehouse
			//ִ�п�汣��ǰ,��ɾ��
			String sqlString="delete from purchaseorder_enter where poid=?";
			base.updateSql(sqlString, new Object[]{poid});
			for(int i=0;i<list.size();i++){
				Map map=(Map)list.get(i);
				String poids=map.get("poid").toString();
				String demands=map.get("demand").toString();
				String cknum=map.get("cknum").toString();
				//���û��¼����Ϣ�Ĳ�ִ�г���
				if(StringUtil.checkNotNull(cknum)&&StringUtil.changeObjectToInt(cknum)>0){
					String sqlInsert="insert into purchaseorder_enter(poid,ck_num,kc_num,caterial_id)values(?,?,?,?)";
					base.updateSql(sqlInsert, new Object[]{poid,cknum,demands,poids});
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
	public void comfirmOut(String poid){
		BaseDAO base=new BaseDAO();
		
		String sql2=" select * from purchaseorder_enter where poid=?";
		try {
			List<HashMap> list=base.selectInfo(sql2, new Object[]{poid});
			if(list!=null&&list.size()>0){
				for(Map map:list){
					String caterialids=map.get("caterial_id").toString();
					String cknum=map.get("ck_num").toString();
					String sql3="update caterial a set a.demand=a.demand+? where a.caterial_id=?";
					base.updateSql(sql3, new Object[]{cknum,caterialids});
				}
			}
			String sqlString="update purchaseorder set outstate=1 where poid=?";
			base.updateSql(sqlString, new Object[]{poid});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * �ڽ������鵥����ʾ������,����ʱ��,������
	 * */
	public List selectList(String empid){
		BaseDAO base=new BaseDAO();
		String sql="select a.emp_id,a.emp_user,b.date,b.listid from emp_account a left join purchaseorder b on a.emp_id=b.emp_id where 1=1 and a.emp_id=?";
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
		String sql="insert into purchaseorder (emp_id,date,listid,outstate) values (?,NOW(),NOW()+11,0)";
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

