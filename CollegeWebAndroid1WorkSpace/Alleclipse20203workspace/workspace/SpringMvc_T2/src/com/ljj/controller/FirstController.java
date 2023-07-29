package com.ljj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class FirstController{

	@RequestMapping(value="/firstController")
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		model.addAttribute("msg", "µÚ¶þ¸ömvc");
		return "first";
	}

}
