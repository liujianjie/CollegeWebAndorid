package com.dc.dao.Role;

import java.util.List;
import java.util.Map;

import com.dc.util.BaseDAO;

public class RolefunDAOImpl implements RolefunDAO{
    /**
     * 根据角色id查找该角色所拥有的父级功能权限
     */
	public List Findfunparent(String roleid) {
		// TODO Auto-generated method stub
		BaseDAO base=new BaseDAO();
		StringBuffer sql=new StringBuffer();
		sql.append("select a.*,b.*,case when a.role_id is not null then 1 else 0 end as xz");
		sql.append(" from role a left join functions_role c on a.role_id=c.role_id right join");
		sql.append(" functions b on b.function_id=c.function_id and a.role_id=?");
		sql.append(" where function_parent_id is null");
		sql.append(" and b.state=0");
		try {
			List list=base.selectInfo(sql.toString(), new Object[]{roleid});
			if(list!=null&&!list.isEmpty()){
				for(int i=0;i<list.size();i++){
					Map map=(Map) list.get(i);
					String parentid=map.get("function_id").toString();
					List ll=this.Findfunson(roleid, parentid);
					map.put("son", ll);
				}
				return list;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
     * 根据角色id查找该角色所拥有的子级功能权限
     */
	public List Findfunson(String roleid, String parentid) {
		// TODO Auto-generated method stub
		BaseDAO base=new BaseDAO();
		StringBuffer sql2=new StringBuffer();
		sql2.append("select a.*,b.*,case when a.role_id is not null then 1 else 0 end as xz");
		sql2.append(" from role a left join functions_role c on a.role_id=c.role_id right join");
		sql2.append(" functions b on b.function_id=c.function_id and a.role_id=? ");
		sql2.append(" where function_parent_id=?");
		sql2.append(" and b.state=0");
		try {
			List list=base.selectInfo(sql2.toString(),new Object[]{roleid,parentid});
		    if(list!=null&&!list.isEmpty()){
		    	for(int i=0;i<list.size();i++){
		    		Map map=(Map) list.get(i);
		    		String functionid= map.get("function_id").toString();
		    		List sons=this.Findfunson(roleid, functionid);
		    		map.put("son",sons);
		    	}
		    	return list;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 通过角色ID进行先删除后添加的操作
	 */
	public int updateAllFunction(String roleid, String[] functionid) {
		// TODO Auto-generated method stub
		BaseDAO base=new BaseDAO();
		String sql="delete from functions_role where role_id=?";
		int b=0;
		try {
			base.updateSql(sql, new Object[]{roleid});
			if(functionid!=null&&functionid.length>0){
				for(int i=0;i<functionid.length;i++){
					String fun=functionid[i];
					String sql2="insert into functions_role (role_id,function_id) values(?,?)";
					b+=base.updateSql(sql2, new Object[]{roleid,fun});
				}
				if(b==functionid.length){
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
