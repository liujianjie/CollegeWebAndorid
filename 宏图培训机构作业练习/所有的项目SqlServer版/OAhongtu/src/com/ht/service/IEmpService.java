package com.ht.service;

import java.util.List;

import com.ht.vo.Education;
import com.ht.vo.Emp;
import com.ht.vo.Family;
import com.ht.vo.Jobs;
import com.ht.vo.Userroot;

public interface IEmpService {
	public List emplist();
	public List toaddemp();
	public Emp getemp(long id);
	public boolean empadd(Emp emp);
	public boolean empupd(Emp emp);
	public boolean empdel(Emp emp);
	
	public List edulist(long id);
	public boolean eduadd(Education edu);
	public boolean eduupd(Education edu);
	
	public List famlist(long id);
	public boolean famadd(Family fam);
	public boolean famupd(Family fam);
	
	public List joblist(long id);
	public boolean jobadd(Jobs job);
	public boolean jobupd(Jobs job);
	
	//х╗оч
	public List emprootlist(long id);
	public boolean delemproot(long id);
	public boolean saveemproot(Userroot uroot);
	public List stulist(long id);
	public List getcla(long id);
}
