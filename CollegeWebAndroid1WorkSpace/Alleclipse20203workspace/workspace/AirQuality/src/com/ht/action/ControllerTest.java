package com.ht.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ht.bean.AirQualityBean;
import com.ht.service.AirQualityI;
import com.ht.service.DistricI;

@Controller
@RequestMapping("/")
public class ControllerTest {
	@Resource
	private AirQualityI air;
	
	@Resource
	private DistricI dis;
	
	@RequestMapping("hello")
	public String hello(){
		System.out.println("hello world");
		return null;
	}
}
