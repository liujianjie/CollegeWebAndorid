package com.ht.dao;

import java.util.List;

import com.ht.pojo.DetailRepayment;

public interface DetailRepaymentDao {
	public int insertReplayJH(DetailRepayment det);

	public Double selDetailMoney();

	// 查看该笔借款的还款计划
	public List<DetailRepayment> SeeMyDetailRepayment(String b_id);
}
