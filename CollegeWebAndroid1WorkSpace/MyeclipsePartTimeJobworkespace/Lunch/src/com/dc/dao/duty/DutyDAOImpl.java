package com.dc.dao.duty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.*;

public class DutyDAOImpl implements DutyDAO {
	/**
	 * 校验职务名是否重复
	 */
	public boolean checkDuty(String dutyname,String dutyid) {
		String sql="select duty_name from duty where duty_name=?";
		//id不为空，代表我是修改不是新增
		if(dutyid!=null&&!dutyid.equals("")){
			sql=sql+" and duty_id!="+dutyid;
		}
		BaseDAO base=new BaseDAO();
		// TODO Auto-generated method stub
		List list=null;
		try {
			list = base.selectInfo(sql, new Object[]{dutyname});
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
	 * 新增职务
	 * @param empname
	 * @param username
	 * @param pwd
	 */
	public void insertDuty(String departname,String dutyname,String accountid,String empuser){
		Map map=this.findDepartId(departname);
		String departid=map.get("depart_id").toString();
		BaseDAO base=new BaseDAO();
		try {
			String sql="insert into duty (duty_name,depart_id,account_id,emp_user,account_date,state) VALUES(?,?,?,?,now(),0)";
			Object[]obj={dutyname,departid,accountid,empuser};
			base.insertSql(sql, obj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除职务
	 * @param empname
	 * @param username
	 * @param pwd
	 */
	public void deleteById(String id){
		
		BaseDAO base=new BaseDAO();
		try {			
			String sql="delete  FROM customer where customer_id=?";
			base.updateSql(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 修改职务
	 * @param empname
	 * @param username
	 * @param pwd
	 */
	public void updateDuty(String departname,String dutyid,String dutyname,String accountid,String empuser){
		Map map=this.findDepartId(departname);
		String departid= map.get("depart_id").toString();
		BaseDAO base=new BaseDAO();
		try {
			
			String sql2="update duty set duty_name=?,depart_id=?,account_id=?,emp_user=?,account_date=now() where duty_id=?";
			base.updateSql(sql2, new Object[]{dutyname,departid,accountid,empuser,dutyid});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询所有部门
	 * @param empname
	 * @param username
	 * @param pwd
	 */

	public List findDepartName(){
		StringBuffer sql=new StringBuffer("");
		sql.append("select * from depart where state=0 ");
	
		BaseDAO base=new BaseDAO();
		try {
			return base.selectInfo(sql.toString(), null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询一个部门id
	 * @return
	 */
	public Map findDepartId(String departname){
		StringBuffer sql=new StringBuffer("");
		sql.append("select * from depart where depart_name=?");
	
		BaseDAO base=new BaseDAO();
		try {
			List<HashMap> list=base.selectInfo(sql.toString(), new Object[]{departname});
			if(list!=null&&list.size()>0)
				return list.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询一个职务
	 * @return
	 */
	public Map findById(String dutyid){
		StringBuffer sql=new StringBuffer("");
		sql.append(" SELECT A.duty_id,A.duty_name,A.depart_id,B.depart_name from duty A");
		sql.append(" LEFT JOIN depart B on a.depart_id=b.depart_id");
		sql.append(" where a.duty_id=?");
	
		BaseDAO base=new BaseDAO();
		try {
			List<HashMap> list=base.selectInfo(sql.toString(), new Object[]{dutyid});
			if(list!=null&&list.size()>0)
				return list.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查询所有职务
	 * @return
	 */
	public List findDuty(Map map,PageEntity page){
		StringBuffer sql=new StringBuffer("");
		sql.append(" SELECT A.*,B.depart_name from duty A ");
		sql.append(" LEFT JOIN depart B on B.depart_id=A.depart_id ");
		sql.append(" where 1=1 ");
		//如果查询条件为空，则查询所有（此条件不过滤）
		if(StringUtil.checkNotNull(map.get("dutyname"))){
			String dutyname=map.get("dutyname").toString();
			sql.append("and a.duty_name like '%"+dutyname+"%'");
		}
		if(StringUtil.checkNotNull(map.get("departname"))){
			String departname=map.get("departname").toString();
			sql.append(" and b.depart_name like '%"+departname+"%'");
		}
		sql.append(" ORDER BY A.account_date DESC ");
		 PageUtil pageutil=new PageUtil();
		 pageutil.setpageinfo(sql, page);
		 return page.getPagelist();
	}
	/**
	 * 职务禁用
	 */
	public void close(String dutyid){
		String sql="update duty set state=1 where duty_id=?";
		Object[]obj={dutyid};
		BaseDAO b=new BaseDAO();
		try {
			b.updateSql(sql, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 职务启用
	 */
	public void open(String dutyid){
		String sql="update duty set state=0 where duty_id=?";
		Object[]obj={dutyid};
		BaseDAO b=new BaseDAO();
		try {
			b.updateSql(sql, obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 查看该职务是否有人
	 */
	public List findemp(String dutyid){
		String sql="select * from emp where duty_id=?";
		Object[]obj={dutyid};
		BaseDAO b=new BaseDAO();
		try {
			List list=b.selectInfo(sql, obj);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
