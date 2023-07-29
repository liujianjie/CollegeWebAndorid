package com.dc.dao.customerTotal;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface totalDAO {
	public List select(Map map,PageEntity page);
	public Map find(Map map);
}
