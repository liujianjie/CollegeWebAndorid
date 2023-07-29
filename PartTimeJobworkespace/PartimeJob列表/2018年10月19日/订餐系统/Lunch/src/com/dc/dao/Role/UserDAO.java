package com.dc.dao.Role;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface UserDAO {
	
   public List findRole(Map map,PageEntity page);
   
   public Map findRoleByid(String roleid);
   
   public boolean insertRole(String rolename,String rolelevel,String rolestate,String userid,String username);
   
   public boolean updateRole(String rolename,String rolelevel,String roleid,String rolestate,String userid,String username);
   
   public void deleteRole(String roleid);
   
   public boolean upOrDown(String state,String roleid);
   
   public boolean checkrole(String rolename,String roleid);
   
   public List selectAllState();
   
   public List selectAllRolelevel();
}
