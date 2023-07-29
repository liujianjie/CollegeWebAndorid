package com.ht.service.impl;

import java.util.List;

import com.ht.common.Hibernate_Dao;
import com.ht.service.IEmpService;
import com.ht.vo.Education;
import com.ht.vo.Emp;
import com.ht.vo.Family;
import com.ht.vo.Jobs;
import com.ht.vo.Userroot;

public class EmpServiceimpl extends Hibernate_Dao implements IEmpService{

	public List emplist() {
		// TODO Auto-generated method stub
		return list("from Emp");
	}
	
	public boolean empadd(Emp emp) {
		// TODO Auto-generated method stub
		return addObj(emp);
	}

	public boolean eduadd(Education edu) {
		// TODO Auto-generated method stub
		return addObj(edu);
	}

	public boolean famadd(Family fam) {
		// TODO Auto-generated method stub
		return addObj(fam);
	}

	public boolean jobadd(Jobs job) {
		// TODO Auto-generated method stub
		return addObj(job);
	}

	public List edulist(long id) {
		// TODO Auto-generated method stub
		return listbysql("select * from education where eid="+id);
	}

	public List famlist(long id) {
		// TODO Auto-generated method stub
		return listbysql("select * from family where eid="+id);
	}

	public Emp getemp(long id) {
		// TODO Auto-generated method stub
		return (Emp)getObj(Emp.class, id);
	}

	public List joblist(long id) {
		// TODO Auto-generated method stub
		return listbysql("select * from jobs where eid="+id);
	}

	public boolean empdel(Emp emp) {
		// TODO Auto-generated method stub
		return delObj(emp);
	}

	public boolean empupd(Emp emp) {
		// TODO Auto-generated method stub
		return updObj(emp);
	}

	public boolean eduupd(Education edu) {
		// TODO Auto-generated method stub
		return updObj(edu);
	}

	public boolean famupd(Family fam) {
		// TODO Auto-generated method stub
		return updObj(fam);
	}

	public boolean jobupd(Jobs job) {
		// TODO Auto-generated method stub
		return updObj(job);
	}

	public List toaddemp() {
		// TODO Auto-generated method stub
		return list("from Dept");
	}

	public List emprootlist(long id) {
		// TODO Auto-generated method stub
		return list("select mid from Userroot where userid="+id);
	}

	public boolean delemproot(long id) {
		// TODO Auto-generated method stub
		return executesql("delete from userroot where userid="+id);
	}

	public boolean saveemproot(Userroot uroot) {
		// TODO Auto-generated method stub
		return addObj(uroot);
	}

	public List stulist(long id) {
		// TODO Auto-generated method stub
		return listbysql("select * from student where classid="+id);
	}

	public List getcla(long id) {
		// TODO Auto-generated method stub
		return listbysql("select * from classes where empteaches="+id);
	}



}
