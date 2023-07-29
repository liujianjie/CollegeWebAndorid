package com.ht.yfbc.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ht.yfbc.pojo.OutStorage;
import com.ht.yfbc.pojo.PickingList;
import com.ht.yfbc.pojo.Stage;
import com.ht.yfbc.service.OutStorageService;
import com.ht.yfbc.service.PickingListService;
import com.ht.yfbc.service.StageService;

/**
 * stage区控制层
 * day 2016-12-28
 * @author 刘建杰 
 *
 */

@Controller
@RequestMapping("stage")
public class StageController {
	
	@Resource
	private StageService stageservice;
	
	@RequestMapping("list")
	private String list(){
		List<Stage> list = stageservice.selStage();
		System.out.println(list.get(0).getReid());
		return null;
	}
}
