package com.dc.dao.Bgorder;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface BgROrderDAO {

	public List SelectAllRO(Map map, PageEntity page0);

	public int changeOrState(String orderid, String empid);

	public List SelectAllDrink();

	public int changeDrinkState(String detailid);

	public Map checkOrshowTotal(Map map, PageEntity page0);

}
