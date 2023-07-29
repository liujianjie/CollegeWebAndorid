package com.jlgouwu.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jlgouwu.pojo.Bottom;
import com.jlgouwu.pojo.Mold;
import com.jlgouwu.service.MoldService;
@Controller
@RequestMapping("mold")
public class MoldController {
	@Resource
	MoldService ss;
	
	@RequestMapping("htlist")
	private String htlist(Model model,HttpServletRequest request){
		List<Mold> list=ss.selmold();
		request.setAttribute("list", list);
//		request.getRequestDispatcher("houtai_caozuo/Moldlist.jsp").forward(request, response);
		return "houtai_caozuo/Moldlist";
	}
	@RequestMapping("qtlist")
	private String qtlist(Model model,HttpServletRequest request){
		List<Mold> list=ss.selmold();
		request.setAttribute("list", list);
//		request.getRequestDispatcher("qiantai_main/left.jsp").forward(request, response);
		return "qiantai_main/left";
	}
}
