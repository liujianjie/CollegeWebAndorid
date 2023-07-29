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

import com.ht.dao.NoticeDao;
import com.ht.pojo.Notice;
import com.ht.service.NoticeService;


/**
 * 公告
 * */
@Controller
@RequestMapping("notice")
public class NoticeController {
	
	@Resource
	NoticeService noticeservice;
	
	@Resource
	NoticeDao noticedao;
	
	@ResponseBody
	@RequestMapping("selnoitcelistindex")
	public Map<String,Object> selnoitcelistindex(){
		Map<String,Object> map = new HashMap<String, Object>();
		List<Notice> list = noticeservice.selnoticelistindex();
		map.put("list", list);
		return map;
	}
	//单个
	@RequestMapping("getnoticeone")
	public String getnoticeone(@RequestParam(value = "id")String id,Model model){
		Notice notices = noticeservice.getnoticeone(id);
		model.addAttribute("notice", notices);
		model.addAttribute("one", 1);
		return "../foregroundSystem/meiti.jsp";
	}
	//所有 前台
	@RequestMapping("selnoticelist")
	public String selnoticelist(Model model,@RequestParam(value = "cpage")Integer cpage){
		Map<String,Object> map = noticeservice.selnoticelist(cpage);
		model.addAttribute("map", map);
		model.addAttribute("one", 0);
		return "../foregroundSystem/meiti.jsp";
	}
	
	
	
	//所有 后台 自动分页
	@RequestMapping("selnoticelistback")
	public String selnoticelistback(Model model){
		List<Notice> list = noticeservice.selnoticelistback();
		model.addAttribute("list", list);
		return "../backgroundSystem/noticelist.jsp";
	}
	
	@RequestMapping("noticeadd")
	public String noticeadd(Notice notice,Model model){
		int i = 0;
		try {
			i=noticedao.addnotice(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(i!=0){
			return "redirect:/notice/selnoticelistback.action";
		}else{
			model.addAttribute("msg", "公布失败,可能标题或者主题内容字符过长!");
			return "../backgroundSystem/noticeadd.jsp";
		}
	}
	@RequestMapping("noticedelete")
	public String noticedelete(@RequestParam(value = "id")String id){
		int	i=noticedao.delnotice(id);
		return "redirect:/notice/selnoticelistback.action";
	}
	//去修改
	@RequestMapping("noticetoalert")
	public String noticetoalert(@RequestParam(value = "id")String id,Model model){
		Notice notices = noticeservice.getnoticeone(id);
		model.addAttribute("notice", notices);
		return "../backgroundSystem/noticealert.jsp";
	}
	//修改
	@RequestMapping("noticealert")
	public String noticealert(Model model,Notice notice){
		int i = 0;
		try {
			i=noticedao.updnotice(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(i!=0){
			return "redirect:/notice/selnoticelistback.action";
		}else{
			Notice notices = noticeservice.getnoticeone(notice.getN_id());
			model.addAttribute("notice", notices);
			model.addAttribute("msg", "修改失败,内容字符过长或者为空");
			return "../backgroundSystem/noticealert.jsp";
		}
	}
}
