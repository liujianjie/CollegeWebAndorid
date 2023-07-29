package com.dc.dao.pinlun;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface PinLunDAO {
    public List SelAllpinlun(Map map,PageEntity page);
    public boolean deletePinlun(String commentid);
    public Map SelPinlun(String commentid);
    public boolean updatePinlun(String commentreplay,String commentid, String empid);
}
