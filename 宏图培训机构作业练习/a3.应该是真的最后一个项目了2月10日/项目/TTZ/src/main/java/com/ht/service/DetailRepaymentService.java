package com.ht.service;

import java.util.List;

import com.ht.pojo.DetailRepayment;

public interface DetailRepaymentService {
	public int insertReplayJH(DetailRepayment det);

	public Double selDetailMoney();

	// 查看该笔借款的还款计划
	public List<DetailRepayment> SeeMyDetailRepayment(String b_id);
}
