package com.dc.controller.Role;

import com.dc.dao.Role.UserDAO;
import com.dc.dao.Role.UserDAOImpl;
import com.dc.entity.Message;
import com.dc.util.BaseAction;

public class CheckRole extends BaseAction{
      private String rolename;
      private String roleid;
      //唯一性校验
      public void Checkrole(){
    	  UserDAO  user=new UserDAOImpl();
    	  boolean result=user.checkrole(rolename, roleid);
  		  Message mess=new Message();
  		  mess.setState(result);
 		  if(result){
 			mess.setMessage("该角色名已存在请重新输入");
 		  }else{
 			mess.setMessage("该角色名可以使用");  
 		  }
 		  this.getOut().print(com.dc.util.StringUtil.transObjectToJson(mess));
      }
      
      
      
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
      
}
