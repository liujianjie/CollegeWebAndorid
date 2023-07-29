package com.dc.dao.pinlun;

import java.util.List;
import java.util.Map;

public interface QTPinlunDAO {
	public Map findmeal(String mealid);
    public List SelPinlun(String mealid);
    public List FindOrder(String orderid);
    public List FindPinlun(String orderid);
    public boolean InsertPL(String orderid,String commentcontent,String commentgrade,String mealid);
}
