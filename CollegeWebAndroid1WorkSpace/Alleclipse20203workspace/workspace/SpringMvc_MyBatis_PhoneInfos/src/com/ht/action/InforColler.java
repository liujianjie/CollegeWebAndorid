package com.ht.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import com.ht.bean.Informations;
import com.ht.bean.Replies;
import com.ht.service.InformationsI;
import com.ht.service.RepliesI;

@Controller
@RequestMapping("/")
public class InforColler {
	//使用注解完成依赖对象的实例
	@Resource 
	private InformationsI ss;
	
	@Resource
	private RepliesI ss2;

	@RequestMapping("inforlist")
	public String selinfor(Model model){
		List<Informations> list = ss.selinforlist();
		model.addAttribute("inforlist",list);
		return "inforlist";
	} 
	@RequestMapping("selxq")
	public String selxq(@RequestParam(value="inforid")int inforid,Model model){
		Informations infor = ss.getinfor((long)inforid);
		model.addAttribute("infor", infor);
		return "replies";
	}
	@RequestMapping("adds")
	public String adds(Replies re){
		ss2.add(re);
		return "redirect:/selxq.do?inforid="+re.getInInforid();
	}
	
	

}
