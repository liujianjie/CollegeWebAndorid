package com.dc.dao.repertory;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface RepertoryDao {
	/**
	 * ԭ���̵��ѯ
	 * */
	public List findcaterial(Map map,PageEntity page);
}
