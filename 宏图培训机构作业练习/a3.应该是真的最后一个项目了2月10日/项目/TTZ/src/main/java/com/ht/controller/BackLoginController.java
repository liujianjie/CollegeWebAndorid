package com.ht.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.pojo.BackGroundUser;
import com.ht.pojo.Permission;
import com.ht.service.BackgroundUserService;
import com.ht.service.DetailRepaymentService;
import com.ht.service.PermissionService;
import com.ht.service.TenderRecordService;
import com.ht.service.TtzuserService;
import com.ht.util.SystemContant;

/**
 * ��̨��¼ ���Ʋ�
 */

@Controller
@RequestMapping("backlogin")
public class BackLoginController {

	@Resource
	BackgroundUserService backservice;

	@Resource
	PermissionService perservice;

	@Resource
	private TenderRecordService tenderService;

	@Resource
	private DetailRepaymentService detailService;

	@Resource
	private TtzuserService ttzService;

	@ResponseBody
	@RequestMapping("login")
	public Map<String, Object> login(@RequestParam(value = "username") String username,
			@RequestParam(value = "pwd") String pwd, HttpSession session) {
		System.out.println(username + pwd);
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("username", username);
		map1.put("pwd", pwd);
		BackGroundUser back = backservice.getBackGroudUser(map1);
		Map<String, Object> map2 = new HashMap<String, Object>();
		if (back != null) {
			// ��ȡȨ���б�
			List<Integer> list = perservice.selectlistbybid(back.getB_id());
			session.setAttribute("qxlist", list);
			sumMoney(session);
			// ��ת����ҳ��
			map2.put("statu", 1);
			// ���浱ǰ��½��Ϣ
			session.setAttribute("backuser", back);
			SystemContant.buser = back;
			// ���浱ǰ��½���Ǻ�̨ϵͳ
			session.setAttribute("system", "��̨ϵͳ");
			SystemContant.System = SystemContant.BackgroundSystem;
		} else {
			map2.put("statu", 0);
		}
		return map2;
	}

	public void sumMoney(HttpSession session) {
		Double TenderMoney = tenderService.selTenderSumMoney();
		session.setAttribute("sumTenderMoney", TenderMoney);

		Double DetailMoney = detailService.selDetailMoney();
		session.setAttribute("sumDetailMoney", DetailMoney);

		int UserMoney = ttzService.selUserMoney();
		session.setAttribute("sumUserMoney", UserMoney);

		int UserCount = ttzService.selUserCount();
		session.setAttribute("UserCount", UserCount);
	}

	@RequestMapping("exitLogin")
	public String exitLogin(HttpSession session) {
		session.removeAttribute("qxlist");
		session.removeAttribute("backuser");
		session.removeAttribute("system");
		return "redirect:../backgroundSystem/login.jsp";
	}
}
