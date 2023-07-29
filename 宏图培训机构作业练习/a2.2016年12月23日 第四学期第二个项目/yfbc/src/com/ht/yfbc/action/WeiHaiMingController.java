package com.ht.yfbc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("weihaiming")
public class WeiHaiMingController {
	@RequestMapping("hello")
	private String hello(){
		System.out.println("hello");
		return null;
	}
}
