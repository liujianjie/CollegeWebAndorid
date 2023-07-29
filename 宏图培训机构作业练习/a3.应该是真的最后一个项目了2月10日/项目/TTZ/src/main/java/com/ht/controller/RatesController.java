package com.ht.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.pojo.Rates;
import com.ht.service.RatesServiceI;

/**
 * rates 为费率控制层
 */

@Controller
@RequestMapping("rates")
public class RatesController {
	
	@Resource
	RatesServiceI ratesservice;
	
	@RequestMapping("selrateslist")
	public String selrateslist(Model model){
		List<Rates> rates = ratesservice.selrateslist();
		model.addAttribute("rlist", rates);
		return "../backgroundSystem/rateslist.jsp";
	}
	@RequestMapping("add")
	public String add(Model model,Rates rates){
		ratesservice.add(rates);
		return "redirect:../rates/selrateslist.action";
	}
	@ResponseBody
	@RequestMapping("toalert")
	public Map<String,Object> toalert(Model model,@RequestParam(value = "id")String id){
		Map<String,Object> map = new HashMap<String, Object>();
		Rates rates = ratesservice.get(id);
		if(rates!=null){
			map.put("rates", rates);
			map.put("result",1);
		}else{
			map.put("result",0);
		}
		return map;
	}
	@RequestMapping("alert")
	public String alert(Model model,Rates rates){
		ratesservice.upd(rates);
		return "redirect:../rates/selrateslist.action";
	}
	@RequestMapping("del")
	public String del(Model model,@RequestParam(value = "id")String id){
		ratesservice.del(id);
		
		return "redirect:../rates/selrateslist.action";
	}
}
