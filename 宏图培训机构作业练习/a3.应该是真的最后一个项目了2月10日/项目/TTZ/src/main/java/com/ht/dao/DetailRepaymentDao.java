package com.ht.dao;

import java.util.List;

import com.ht.pojo.DetailRepayment;

public interface DetailRepaymentDao {
	public int insertReplayJH(DetailRepayment det);

	public Double selDetailMoney();

	// �鿴�ñʽ��Ļ���ƻ�
	public List<DetailRepayment> SeeMyDetailRepayment(String b_id);
}
