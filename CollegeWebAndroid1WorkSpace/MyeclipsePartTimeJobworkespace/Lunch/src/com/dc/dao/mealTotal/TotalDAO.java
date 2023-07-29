package com.dc.dao.mealTotal;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface TotalDAO {
    public List Select(Map map,PageEntity page);
    public Map SelectAll(Map map);
    public List mealTu(Map map);
}
