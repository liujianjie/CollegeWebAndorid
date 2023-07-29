package com.ht.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.DetailRepaymentDao;
import com.ht.pojo.DetailRepayment;
import com.ht.service.DetailRepaymentService;

@Service
public class DetailRepaymentServiceImpl implements DetailRepaymentService {
	@Resource
	private DetailRepaymentDao DrDao;

	@Override
	public int insertReplayJH(DetailRepayment det) {
		// TODO Auto-generated method stub
		return DrDao.insertReplayJH(det);
	}

	@Override
	public Double selDetailMoney() {
		// TODO Auto-generated method stub
		return DrDao.selDetailMoney();
	}

	// 查看该笔借款的还款计划
	@Override
	public List<DetailRepayment> SeeMyDetailRepayment(String b_id) {
		// TODO Auto-generated method stub
		return DrDao.SeeMyDetailRepayment(b_id);
	}
}
