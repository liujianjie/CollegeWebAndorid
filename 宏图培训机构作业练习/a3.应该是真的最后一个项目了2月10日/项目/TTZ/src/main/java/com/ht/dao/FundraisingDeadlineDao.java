package com.ht.dao;

import java.util.List;

import com.ht.pojo.FundraisingDeadline;

public interface FundraisingDeadlineDao {
	
	public List<FundraisingDeadline> FundraisingDeadlinelist();
	
	public int addFun(FundraisingDeadline f);
	
	public FundraisingDeadline toupdFun(String fid);
	
	public int updFun(FundraisingDeadline f);
	
	public int delFun(String fid);
}
