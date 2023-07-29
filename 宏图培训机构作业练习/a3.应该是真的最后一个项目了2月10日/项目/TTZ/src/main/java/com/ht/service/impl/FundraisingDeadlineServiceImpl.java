package com.ht.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.FundraisingDeadlineDao;
import com.ht.pojo.FundraisingDeadline;
import com.ht.service.FundraisingDeadlineService;

@Service
public class FundraisingDeadlineServiceImpl implements FundraisingDeadlineService{

	@Resource
	FundraisingDeadlineDao fd;
	
	public List<FundraisingDeadline> FundraisingDeadlinelist() {
		return fd.FundraisingDeadlinelist();
	}

	public int addFun(FundraisingDeadline f) {
		return fd.addFun(f);
	}

	public FundraisingDeadline toupdFun(String fid) {
		return fd.toupdFun(fid);
	}

	public int updFun(FundraisingDeadline f) {
		return fd.updFun(f);
	}

	public int delFun(String fid) {
		return fd.delFun(fid);
	}
}
