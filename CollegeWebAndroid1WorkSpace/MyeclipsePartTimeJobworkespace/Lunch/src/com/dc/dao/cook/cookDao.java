package com.dc.dao.cook;

import java.util.*;

import com.dc.entity.PageEntity;

public interface cookDao {
	public List selectLianDish();
	public void finishDishLian(String orderdetailid,String state);
	public List selectFinishDish();
	public List usFood();
	public void finishRe(String state,String cookid);
	public List dishFewPeople();
}
