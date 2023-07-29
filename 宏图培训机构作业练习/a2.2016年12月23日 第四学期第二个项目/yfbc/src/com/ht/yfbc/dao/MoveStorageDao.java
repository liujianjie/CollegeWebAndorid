package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.InStorage;
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
public interface MoveStorageDao {
	//查看自己发起的流程
	public List<MoveStorage> selMoveStorage(Map<String,Object> maps);
	public int addMoveStorage(MoveStorage movestorage);//添加
	//查询单个流程数据
	public MoveStorage getOneMoveStorage(String moid);
	//修改单个数据
	public int updateMoveStorage(MoveStorage move);
	//查询touser是我的列表
	public List<MoveStorage> selMoveStorageByTouser(String touser);
	//查询代办任务数量
	public int getMoveStorageCount(String userid);
	//查询移货数量
	public int getMoveStorageMoCount(String userid);
	//1月17所有流程
	public List<MoveStorage> selAllMoveStorage(Map<String,Object> maps);
	public int getAllMoveStorageCount(Map<String,Object> maps);
}
