package com.camera.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.camera.service.impl.SelectTimeImp;

@Controller
public class SelectTimeController {
	
	@Resource
	SelectTimeImp selecttimp;
	
	@RequestMapping(value="/selectByAjax")
	@ResponseBody
	public String selectByAjax(String datetime) {
		System.out.println(datetime);
		boolean bln = selecttimp.selctTimeIsWork(datetime);
//		return bln ? "working" :"noworking";
		return bln ? "在工作" :"不在工作";
	}
}
