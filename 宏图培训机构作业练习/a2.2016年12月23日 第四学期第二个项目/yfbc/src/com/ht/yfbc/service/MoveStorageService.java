package com.ht.yfbc.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ht.yfbc.pojo.MoveStorage;
import com.ht.yfbc.pojo.Picking;
import com.ht.yfbc.pojo.Putaway;
import com.ht.yfbc.pojo.Stage;
import com.ht.yfbc.pojo.putaway2;

/**
 * 移库操作(MoveStorage)
 * day 2016-1-4
 * @author 刘建杰
 *
 */

public interface MoveStorageService {
	public Map<String,Object> selMoveStorage(String userid,String whid,Integer cpage);
	public int addMoveStorage(MoveStorage movestorage);
	//查询单个流程数据
	public MoveStorage getOneMoveStorage(String moid);
	//修改单个数据
	public int updateMoveStorage(MoveStorage move);
	//查询touser是我的列表
	public Map<String,Object> selMoveStorageByTouser(String touser);
	//查询代办任务数量
	public int getMoveStorageCount(String userid);
	//1月17
	public Map<String,Object> selAllMoveStorage(Integer cpage,String mowhiname,String towhiname);
}
