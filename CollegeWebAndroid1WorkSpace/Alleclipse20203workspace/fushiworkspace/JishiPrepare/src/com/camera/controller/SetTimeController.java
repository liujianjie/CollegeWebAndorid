package com.camera.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camera.pojo.WorkTime;
import com.camera.service.impl.SetTimeImp;

@Controller
public class SetTimeController {
	
	@Resource
	SetTimeImp settimeimp;
	
	@RequestMapping("setWorkAndNoWorkTime")
	public String setWorkAndNoWorkTime(WorkTime workt) {
		System.out.println(workt);
		
		// ²åÈë
		int i = settimeimp.insertWorkTime(workt);
		if(i > 0) {
			return "success";
		}else {
			return "error";
		}
	}
}
