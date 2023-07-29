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
 * ����
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
	//����
	@RequestMapping("getnoticeone")
	public String getnoticeone(@RequestParam(value = "id")String id,Model model){
		Notice notices = noticeservice.getnoticeone(id);
		model.addAttribute("notice", notices);
		model.addAttribute("one", 1);
		return "../foregroundSystem/meiti.jsp";
	}
	//���� ǰ̨
	@RequestMapping("selnoticelist")
	public String selnoticelist(Model model,@RequestParam(value = "cpage")Integer cpage){
		Map<String,Object> map = noticeservice.selnoticelist(cpage);
		model.addAttribute("map", map);
		model.addAttribute("one", 0);
		return "../foregroundSystem/meiti.jsp";
	}
	
	
	
	//���� ��̨ �Զ���ҳ
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
			model.addAttribute("msg", "����ʧ��,���ܱ���������������ַ�����!");
			return "../backgroundSystem/noticeadd.jsp";
		}
	}
	@RequestMapping("noticedelete")
	public String noticedelete(@RequestParam(value = "id")String id){
		int	i=noticedao.delnotice(id);
		return "redirect:/notice/selnoticelistback.action";
	}
	//ȥ�޸�
	@RequestMapping("noticetoalert")
	public String noticetoalert(@RequestParam(value = "id")String id,Model model){
		Notice notices = noticeservice.getnoticeone(id);
		model.addAttribute("notice", notices);
		return "../backgroundSystem/noticealert.jsp";
	}
	//�޸�
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
			model.addAttribute("msg", "�޸�ʧ��,�����ַ���������Ϊ��");
			return "../backgroundSystem/noticealert.jsp";
		}
	}
}
