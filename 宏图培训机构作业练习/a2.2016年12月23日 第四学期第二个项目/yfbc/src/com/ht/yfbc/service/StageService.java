package com.ht.yfbc.service;

import java.util.List;

import com.ht.yfbc.pojo.Picking;
import com.ht.yfbc.pojo.Stage;

public interface StageService {
	public List<Stage> selStage();
	public int addStage(Stage stage);

}
