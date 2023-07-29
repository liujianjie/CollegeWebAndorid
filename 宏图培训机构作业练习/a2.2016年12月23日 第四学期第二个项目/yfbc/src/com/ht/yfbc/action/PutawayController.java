package com.ht.yfbc.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ht.yfbc.pojo.Goodtype;
import com.ht.yfbc.pojo.OutStorage;
import com.ht.yfbc.pojo.PickingList;
import com.ht.yfbc.pojo.Putaway;
import com.ht.yfbc.pojo.Stage;
import com.ht.yfbc.pojo.putaway2;
import com.ht.yfbc.service.GoodtypeService;
import com.ht.yfbc.service.OutStorageService;
import com.ht.yfbc.service.PickingListService;
import com.ht.yfbc.service.PutawayService;
import com.ht.yfbc.service.StageService;

/**
 * 摆货单控制层
 * day 2016-12-28
 * @author 刘建杰 
 *
 */

@Controller
@RequestMapping("putaway")
public class PutawayController {
	
	@Resource
	private PutawayService putawayservice;
	
	@Resource
	private GoodtypeService gservice;
	
	@RequestMapping("list")
	private String list(Model model, @RequestParam(value = "currPage", required = false) String currPage){
		Map<String, Object> map = putawayservice.PutawayBypage(Integer.parseInt(currPage));
		model.addAttribute("map", map);
		
		return "putawaylist";
	}
	
	@RequestMapping("toaddputaway")
	public String toAddPutaway(Model model,@RequestParam(value = "pid", required = false) String pid){
		putaway2 put = putawayservice.selPutawayByPid(pid);
		List<Goodtype> goodlist = gservice.seltype();
		model.addAttribute("put", put);
		model.addAttribute("goodlist", goodlist);
		return "addputwawy";
		
		
	}
	
	
	
}
