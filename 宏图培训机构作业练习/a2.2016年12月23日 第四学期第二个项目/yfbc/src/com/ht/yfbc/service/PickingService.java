package com.ht.yfbc.service;

import java.util.List;

import com.ht.yfbc.pojo.OutStorage;
import com.ht.yfbc.pojo.Picking;
import com.ht.yfbc.pojo.PickingList;

public interface PickingService {
	public List<Picking> selPicking();
	public int addPicking(Picking picking);
}
