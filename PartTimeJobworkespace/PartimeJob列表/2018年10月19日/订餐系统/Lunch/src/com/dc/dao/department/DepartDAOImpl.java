package com.dc.dao.department;
import java.util.*;
import com.dc.entity.PageEntity;
import com.dc.util.*;

public class DepartDAOImpl implements DepartDAO {
	/**
	 * 校验部门名是否重复
	 */
	public boolean checkDepart(String departname,String departid) {
		String sql="select * from depart where depart_name=?";
		//accountid涓嶄负绌猴紝浠ｈ〃鎴戞槸淇敼涓嶆槸鏂板
		if(departid!=null&&!departid.equals("")){
			sql=sql+" and depart_id!="+departid;
		}
		BaseDAO base=new BaseDAO();
		// TODO Auto-generated method stub
		List list=null;
		try {
			list = base.selectInfo(sql, new Object[]{departname});
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
	 * 新增部门
	 * @param empname
	 * @param username
	 * @param pwd
	 */
	public void insertDepart(String departname,String departdesc,String accountid,String empuser){
		
		BaseDAO base=new BaseDAO();
		try {
			String sql="insert into depart(depart_name,depart_desc,account_id,emp_user,account_date,state)values(?,?,?,?,now(),0)";
			Object[]obj={departname,departdesc,accountid,empuser};
			base.insertSql(sql, obj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除一个部门
	 * @param empname
	 * @param username
	 * @param pwd
	 */
	public void deleteById(String departid){
		
		BaseDAO base=new BaseDAO();
		try {			
			String sql="delete  FROM customer where depart_id=?";
			base.updateSql(sql, new Object[]{departid});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 更改部门
	 * @param empname
	 * @param username
	 * @param pwd
	 */
	public void updateDepart(String departid,String departname,String departdesc,String accountid,String empuser){
		
		BaseDAO base=new BaseDAO();
		try {
			
			String sql2="update depart set depart_name=?,depart_desc=?,account_id=?,emp_user=?,account_date=now() where depart_id=?";
			base.updateSql(sql2, new Object[]{departname,departdesc,accountid,empuser,departid});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	/**
	 * 通过id查询一个部门
	 * @return
	 */
	public Map findDepartById(String departid){
		StringBuffer sql=new StringBuffer("");
		sql.append("select * from depart where depart_id=?");
	
		BaseDAO base=new BaseDAO();
		try {
			List<HashMap> list=base.selectInfo(sql.toString(), new Object[]{departid});
			if(list!=null&&list.size()>0)
				return list.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询所有部门
	 * @return
	 */
	public List findDepart(PageEntity page,String departname){
		StringBuffer sql=new StringBuffer("");
		sql.append("select * from depart");
		sql.append(" where 1=1 ");
		if(StringUtil.checkNotNull(departname)){
			sql.append(" and depart_name like '%"+departname+"%' ");
			
		}
		sql.append(" order by account_date desc ");
		 PageUtil pageutil=new PageUtil();
		 pageutil.setpageinfo(sql, page);
		 return page.getPagelist();
	}
	/**
	 * 查询所有部门员工
	 * @return
	 */
	public List findDepartEmp(String departid,PageEntity page){
		StringBuffer sql=new StringBuffer();
		sql.append(" select B.*,A.depart_name,C.duty_name from emp B ");
		sql.append(" join depart A  on A.depart_id=B.depart_id " );
		sql.append(" join  duty C on C.duty_id=B.duty_id  ");
		sql.append(" where A.depart_id="+departid );
		PageUtil pageutil=new PageUtil();
		 pageutil.setpageinfo(sql, page);
		 return page.getPagelist();		
	}
	/**
	 * 查询部门是否有员工
	 */
	public List findDepartEmployee(String departid){
		StringBuffer sql=new StringBuffer();
		sql.append(" select B.*,A.depart_name,C.duty_name from emp B ");
		sql.append(" join depart A  on A.depart_id=B.depart_id " );
		sql.append(" join  duty C on C.duty_id=B.duty_id  ");
		sql.append(" where A.depart_id="+departid );
		BaseDAO base=new BaseDAO();
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
	 * 部门禁用
	 * @return
	 */
	public void close(String departid){
		String sql="update depart set  state=1 where depart_id=?";
		Object[]obj={departid};
		BaseDAO b=new BaseDAO();
		try {
			b.updateSql(sql, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 部门启用
	 * @return
	 */
	public void open(String departid){
		String sql="update depart set  state=0 where depart_id=?";
		Object[]obj={departid};
		BaseDAO b=new BaseDAO();
		try {
			b.updateSql(sql, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
