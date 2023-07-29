package com.ht.yfbc.dao;

import java.util.List;

import com.ht.yfbc.pojo.Picking;
import com.ht.yfbc.pojo.Stage;

/**
 * stage区操作(stage)
 * day 2016-12-28
 * @author 刘建杰
 *
 */
public interface StageDao {
	public List<Stage> selStage();
	public int addStage(Stage stage);

}
