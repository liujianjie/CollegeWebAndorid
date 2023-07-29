package com.ht.yfbc.service;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Position;
/**
 * selPositionList:查询所有岗位表信息<br/>
 * selPositionNameById:根据id查询对应的岗位名称
 * @author 刘宗龙
 *
 */
public interface PositionService {
	public List<Position> selPositionList();
	public String selPositionNameById(String id);
	public String selPositionIdByName(String pname);
	public List<Position> selCars_posiPage(Map<String, Object> map); 
	public int selCount();
	public int addposi(Position posi);
	public int delposi(String id);
}
