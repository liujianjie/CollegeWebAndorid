package com.ht.service.impl;

import java.sql.PreparedStatement;
import java.util.List;

import com.ht.common.Hibernate_Dao;
import com.ht.service.IApplyservice;
import com.ht.vo3.Applystudent;
import com.ht.vo3.Applystudent2;


public class ApplyServiceImpl extends Hibernate_Dao implements IApplyservice{

	  public List appList(){
	      return  list("from Applystudent");
	 }

	public boolean updStatus1(Long id) {
		// TODO Auto-generated method stub
		return executesql("update applystudent set intenstatus='сп' where intenid="+id);
	}

	public boolean updStatus2(Long id) {
		// TODO Auto-generated method stub
		return executesql("update applystudent set intenstatus='нч' where intenid="+id);
	}

	public List appList2() {
		// TODO Auto-generated method stub
		return list("from Applystudent2");
	}

	public Applystudent getStuInfoById(Long id) {
		// TODO Auto-generated method stub
		return (Applystudent)getObj(Applystudent.class, id);
	}

	public boolean addStuInfo(Applystudent2 stu2) {
		// TODO Auto-generated method stub
		return addObj(stu2);
	}

	public boolean addStu(Applystudent st) {
		// TODO Auto-generated method stub
		return addObj(st);
	}

	
	public List check(int id) {
		// TODO Auto-generated method stub
		return listbysql("select intenstatus from applystudent where intenid="+id);
	}

}
