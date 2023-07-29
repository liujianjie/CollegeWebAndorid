package com.dc.dao.BgLogin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;


public class UserDAOImpl implements UserDAO{
/**
 * 启用用户才可以登入系统
 */
	public Map login(String username, String pwd) {
		String sql="select  * from emp_account WHERE emp_user=? and emp_password=? and state=1 ";
		Object[]obj={username,pwd};
		BaseDAO b=new BaseDAO();
		List<HashMap> list;
		try {
			list = b.selectInfo(sql, obj);
			if(list!=null&&list.size()>0){
				Map map=list.get(0);
				return map;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/**
 * 根据父id找子
 */
public List<HashMap> findAllFunctionByUserId(String accountid) {
		StringBuffer sql=new StringBuffer("");
		sql.append("select distinct c.* from role_account a ");
		sql.append(" join functions_role b on a.role_id=b.role_id");
		sql.append(" join functions c on b.function_id=c.function_id");
		sql.append(" where a.emp_account_id=? and c.function_parent_id is null and state=0");
		BaseDAO base=new BaseDAO();
		try {
			List<HashMap> list =base.selectInfo(sql.toString(), new Object[]{accountid});
			if(list!=null){
				for(int i=0;i<list.size();i++){
					Map map=list.get(i);
					String parentid=map.get("function_id").toString();
					List sons=this.findFunctionByParentId(accountid, parentid);
		    		map.put("sons", sons);	
				}


				//System.out.println(list);

				return list;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
/**
 * 查找用户所属功能
 * @param accountid
 * @param parentid
 * @return
 */
	public List<HashMap> findFunctionByParentId(String accountid, String parentid) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("");
		sql.append("select distinct c.* from role_account a ");
		sql.append(" join functions_role b on a.role_id=b.role_id");
		sql.append("  join functions c on b.function_id=c.function_id");
		sql.append(" where a.emp_account_id=? and c.function_parent_id =? and state=0");
		BaseDAO base=new BaseDAO();	
		
			List<HashMap> list;
			try {
				list = base.selectInfo(sql.toString(), new Object[]{accountid,parentid});
				if(list!=null){
					for(int i=0;i<list.size();i++){
						Map map=list.get(i);
						String ff=map.get("function_id").toString();
			    		List sons=this.findFunctionByParentId(accountid, ff);
			    		map.put("sons", sons);
					}
					
					return list;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//此处为递归查询子 
			return null;
	}
	/**
	 * 检查用户，分页
	 */
	public List<HashMap> selectEmpBycheck(Map map, PageEntity page) {
		BaseDAO base= new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("select DISTINCT a.emp_id,a.district,a.address,a.age,");
		sql.append(" a.duty_id,a.emp_name,a.hiredate,a.phone,a.province,a.sex,");
		sql.append(" b.emp_account_id,b.emp_user,b.emp_password,b.state,c.duty_name");
		sql.append(" from emp a");
		sql.append(" left join emp_account b on a.emp_id=b.emp_id ");
		sql.append(" left join duty c on c.duty_id=a.duty_id ");
		sql.append(" left join role_account e on e.emp_account_id=b.emp_account_id");
		sql.append(" where 1=1");
		if(StringUtil.checkNotNull(map.get("empname"))){
			String empname=map.get("empname").toString();
			sql.append(" and a.emp_name like '%"+empname+"%'");
		}
		if(StringUtil.checkNotNull(map.get("empuser"))){
			String empuser=map.get("empuser").toString();
			sql.append(" and b.emp_user like '%"+empuser+"%'");
		}
		sql.append(" order by a.date desc");
		//sql.append(" limit "+(page.getNowpage()-1)*page.getPagecount()+","+page.getPagecount());
		PageUtil pageutil=new PageUtil();
		pageutil.setpageinfo(sql, page);
		return page.getPagelist();
	}
	/**
	 * 查询id的员工信息
	 * @param empid
	 * @return
	 */
		public List<HashMap> selectallUserById(String empid) {
			BaseDAO base= new BaseDAO();
			String sql="select a.emp_id,a.emp_name,a.phone,b.emp_user,b.emp_password,b.emp_account_id " +
					   "  from emp a"
	                  +" left join emp_account b on a.emp_id=b.emp_id where a.emp_id=?";
			try {
				List<HashMap> list=base.selectInfo(sql, new Object[]{empid});
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
		 * 通过员工编号修改其状态，相当于该员工不能操作了
		 */
		public int changeEmpAccountState(String empid) {
			BaseDAO base=new BaseDAO();
			try {
				String sql0 = "select state from emp_account where emp_id=?";
				List<HashMap> list = base.selectInfo(sql0,
						new Object[] { empid });
				Map map = new HashMap();
				if (list != null && list.size() > 0) {
					map = list.get(0);
					//System.out.println(map+"账号表");
				}
				int state = Integer.parseInt(map.get("state").toString());
				String sql = "update emp_account set state= ? where emp_id=?";
				if (state == 0) {
					base.updateSql(sql, new Object[] { 1, empid });
				}
				else{
					 base.updateSql(sql, new Object[] { 0, empid });
				}
				return state;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return -1;
		}

}
