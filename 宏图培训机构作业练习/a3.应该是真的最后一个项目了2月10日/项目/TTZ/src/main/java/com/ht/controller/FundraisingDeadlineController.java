package com.ht.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ht.pojo.FundraisingDeadline;
import com.ht.service.FundraisingDeadlineService;

@Controller
@RequestMapping("/")
public class FundraisingDeadlineController {

	@Resource
	FundraisingDeadlineService fs;

	@RequestMapping("FundraisingDeadlinelist")
	public String FundraisingDeadlinelist(Model model) {
		List flist = fs.FundraisingDeadlinelist();
		model.addAttribute("flist", flist);
		return "backgroundSystem/FundraisingDeadlinelist.jsp";
	}

	@RequestMapping("addFun")
	public String addFun(FundraisingDeadline f) {
		fs.addFun(f);
		return "redirect:FundraisingDeadlinelist.action";
	}

	@RequestMapping("updFun")
	public String updFun(FundraisingDeadline f) {
		fs.updFun(f);
		return "redirect:FundraisingDeadlinelist.action";
	}

	@RequestMapping("delFun")
	public String delFun(@RequestParam(value = "fid", required = false) String fid) {
		fs.delFun(fid);
		return "redirect:FundraisingDeadlinelist.action";
	}
}
