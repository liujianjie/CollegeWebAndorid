package com.dc.controller.Role;

import com.dc.dao.Role.UserDAO;
import com.dc.dao.Role.UserDAOImpl;
import com.dc.entity.Message;
import com.dc.util.BaseAction;

public class CheckRole extends BaseAction{
      private String rolename;
      private String roleid;
      //Ψһ��У��
      public void Checkrole(){
    	  UserDAO  user=new UserDAOImpl();
    	  boolean result=user.checkrole(rolename, roleid);
  		  Message mess=new Message();
  		  mess.setState(result);
 		  if(result){
 			mess.setMessage("�ý�ɫ���Ѵ�������������");
 		  }else{
 			mess.setMessage("�ý�ɫ������ʹ��");  
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
