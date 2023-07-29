package com.jlgouwu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jlgouwu.pojo.Bottom;
import com.jlgouwu.pojo.Mold;
import com.jlgouwu.service.BottomService;
import com.jlgouwu.service.GoodsService;

@Controller
@RequestMapping("bottom")
public class BottomController{
	@Resource
	BottomService ss;
	
	@Resource
	GoodsService gs;
	
	@RequestMapping("list")
	private String list(Model model){
		List<Bottom> list=ss.selbottom();
		
		model.addAttribute("list", list);
		return "houtai_caozuo/Bottomlist";
	}
	@RequestMapping("del")
	private String del(String id){
		boolean bln1 = gs.delGoodsByBid(Integer.parseInt(id));
		
		boolean bln=ss.delbottom(Integer.parseInt(id));
		
		if(bln && bln1){
			return "redirect:/bottom/list";
		}else {
			return "";
		}
	}
	@RequestMapping("toadd")
	private String toadd(Model model){
		List<Mold> list=ss.selMold();
		
		model.addAttribute("list", list);
		
		return "houtai_caozuo/Bottomadd";
	}
	@RequestMapping("add")
	private String add(Model model, String uname, String select){
		Bottom bot=new Bottom();
		bot.setBottom(uname);
		bot.setMold_id(Integer.parseInt(select));
		ss.addbottom(bot);
		return "redirect:/bottom/list";
	}
	@RequestMapping("goalert")
	private String goalert(Model model, String id){
		Bottom bot=ss.selhang(Integer.parseInt(id));
		model.addAttribute("bot", bot);
		List<Mold> list=ss.selMold();
		model.addAttribute("list", list);
		
		return "houtai_caozuo/alertBottom";
	}
	@RequestMapping("alert")
	private String alert(Model model, String id, String uname, String select){
		int id1=Integer.parseInt(id);
		int select1=Integer.parseInt(select);

		Bottom bot=new Bottom();
		bot.setBottom_id(id1);
		bot.setBottom(uname);
		bot.setMold_id(select1);
		
		boolean bln=ss.alerthang(bot);
		
		return "redirect:/bottom/list";
	}
}
