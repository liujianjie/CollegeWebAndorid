package com.dc.dao.Role;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;
import com.dc.util.BaseDAO;
import com.dc.util.PageUtil;
import com.dc.util.StringUtil;

public class UserDAOImpl implements UserDAO{
	    /**
	     * 查询所有角色
	     */
		public List findRole(Map map,PageEntity page){
		StringBuffer sql=new StringBuffer("");
		sql.append(" select * from role");
		sql.append(" where 1=1");
		if(StringUtil.checkNotNull(map.get("rolename"))){
			String rolename=(String) map.get("rolename");
			sql.append(" and role_name like '%"+rolename+"%' ");
		}
		if(StringUtil.checkNotNull(map.get("rolelevel"))){
			String rolelevel=map.get("rolelevel").toString();
			sql.append(" and role_level like '%"+rolelevel+"%' ");
		}
		sql.append(" ORDER BY date DESC");
	    PageUtil pageutil=new PageUtil();
	    pageutil.setpageinfo(sql, page);
		return page.getPagelist();
		}
		/**
		 * 根据ID查询角色
		 */
		public Map findRoleByid(String roleid){
			String sql="select * from role where role_id=?";
			BaseDAO base=new BaseDAO();
			try {
				List list=base.selectInfo(sql, new Object[]{roleid});
				if(list!=null&&!list.isEmpty()){
					Map map=(Map)list.get(0);
					return map;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		/**
		 * 新增角色
		 */
		public boolean insertRole(String rolename, String rolelevel,String rolestate,String userid ,String username) {
			String sql="insert into role (role_name,role_level,state,date,user_id,user_name) VALUES(?,?,?,now(),?,?)";
			BaseDAO base=new BaseDAO();
			try {
				int a=base.updateSql(sql, new Object[]{rolename,rolelevel,rolestate,userid,username});
				if(a>0){
					return true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
			}
		/**
		 * 修改角色
		 */
		public boolean updateRole(String rolename, String rolelevel,String rolestate,String roleid ,String userid ,String username) {
			String sql="update role set role_name=?,role_level=?,state=?, user_id=?,user_name=?, date=now() where role_id=?";
			BaseDAO base=new BaseDAO();
			try {
				int b=base.updateSql(sql, new Object[]{rolename,rolelevel,rolestate,userid,username,roleid});
				if(b>0){
					return true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		/**
		 * 根据ID删除角色
		 */
		public void deleteRole(String roleid){
			String sql="delete from role where role_id=?";
			BaseDAO base=new BaseDAO();
			try {
				base.updateSql(sql, new Object[]{roleid});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/**
		 * 修改该角色状态
		 * @param state
		 * @param goodsid
		 * @return
		 */
		public boolean upOrDown(String state,String roleid){
			BaseDAO base=new BaseDAO();
			String sql="UPDATE role  SET state=? WHERE role_id=?";
			int A=0;
				try {
					A=base.updateSql(sql, new Object[]{state,roleid});
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(A>0){
					return true;
				}else{
					return false;
				}
		}
		/**
		 * 校验角色名是否重复
		 */
		public boolean checkrole(String rolename,String roleid) {
			String sql="select * from role where role_name=?";
			if(roleid!=null&&!roleid.equals("")){
				sql=sql+" and role_id!="+roleid;
			}
			BaseDAO base=new BaseDAO();
			List list=null;
			try {
				list = base.selectInfo(sql, new Object[]{rolename});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(list!=null&&list.size()>0){
				return true;
			}
			return false;
		}
		/***
		 * 查询角色状态
		 * @return
		 */
		public List selectAllState() {
			// TODO Auto-generated method stub
			String sql="SELECT DISTINCT state from role";
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
		 * 查询角色等级
	    */
		public List selectAllRolelevel() {
			// TODO Auto-generated method stub
			String sql="SELECT DISTINCT role_level from role";
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
