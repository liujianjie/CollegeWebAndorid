package com.ht.yfbc.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ht.yfbc.pojo.OutStorage;
import com.ht.yfbc.pojo.PickingList;
import com.ht.yfbc.service.OutStorageService;
import com.ht.yfbc.service.PickingListService;

/**
 * 拣货单列表控制层
 * day 2016-12-27
 * @author 刘建杰 
 *
 */

@Controller
@RequestMapping("pickinglist")
public class PickingListController {
	
	@Resource
	private PickingListService pickinglistservice;
	
	@RequestMapping("list")
	private String list(){
		List<PickingList> list = pickinglistservice.selPickingList();
		System.out.println(list.size());
		System.out.println(list.get(0).getSku());
		return null;
	}
}
