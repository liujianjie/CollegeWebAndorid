package com.ht.service;

import java.util.List;

import com.ht.pojo.DetailRepayment;

public interface DetailRepaymentService {
	public int insertReplayJH(DetailRepayment det);

	public Double selDetailMoney();

	// �鿴�ñʽ��Ļ���ƻ�
	public List<DetailRepayment> SeeMyDetailRepayment(String b_id);
}
