package com.ht.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.pojo.Bankcard;
import com.ht.pojo.Ttzbank;
import com.ht.pojo.Ttzuser;
import com.ht.service.BankcardService;
import com.ht.service.TtzbanlService;


@Controller
@RequestMapping("bank")
public class TtzbankController {
	@Resource
	private BankcardService bankService;
	
	@Resource
	private TtzbanlService ttzBankService;

	@RequestMapping("add")
	@ResponseBody
	public Map<String, Object> addTtzuser(@RequestParam(value = "pcard", required = false) String pcard,
			@RequestParam(value = "bankcard", required = false) String bankcard,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Bankcard tbank = bankService.selbybkseltwo(bankcard, pcard);
		if(tbank != null){
			map.put("boolean", true);
			Ttzuser user = (Ttzuser) request.getSession().getAttribute("user");
			Ttzbank bank = new Ttzbank("", user.getUserid(), user.getUsername(), bankcard, tbank.getBktype(),pcard);
			ttzBankService.addTtzbank(bank);
		}else{
			map.put("boolean", false);
		}
		
		return map;
	}
	
	@RequestMapping("selbank")
	public String selBankList(Model model,HttpServletRequest request){
		Ttzuser user = (Ttzuser) request.getSession().getAttribute("user");
		List<Ttzbank> list = ttzBankService.seluserBank(user.getUserid());
		model.addAttribute("banklist",list);
		return "../foregroundSystem/personal_bankcard.jsp";
		
	}
}
