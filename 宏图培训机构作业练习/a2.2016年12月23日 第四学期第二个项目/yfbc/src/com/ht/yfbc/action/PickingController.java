package com.ht.yfbc.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ht.yfbc.pojo.OutStorage;
import com.ht.yfbc.pojo.Picking;
import com.ht.yfbc.service.OutStorageService;
import com.ht.yfbc.service.PickingService;

/**
 * 拣货单控制层
 * day 2016-12-27
 * @author 刘建杰
 *
 */

@Controller
@RequestMapping("picking")
public class PickingController {
	@Resource
	private PickingService pickingservice;
	
	@RequestMapping("list")
	private String list(){
		List<Picking> list = pickingservice.selPicking();
		System.out.println(list.size());
		System.out.println(list.get(0).getDamagedreason());
		return null;
	}
}
