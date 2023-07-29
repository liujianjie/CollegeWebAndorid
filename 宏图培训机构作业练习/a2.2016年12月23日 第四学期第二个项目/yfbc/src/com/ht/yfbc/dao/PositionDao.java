package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Position;

public interface PositionDao {
	public List<Position> selPositionList();
	public String selPositionNameById(String id);
	public String selPositionIdByName(String pname);
	public List<Position> selCars_posiPage(Map<String, Object> map); 
	public int selCount();
	public int addposi(Position posi);
	public int delposi(String id);
}
