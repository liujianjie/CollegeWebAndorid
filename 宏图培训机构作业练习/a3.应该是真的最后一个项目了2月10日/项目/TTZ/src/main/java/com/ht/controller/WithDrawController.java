package com.ht.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.pojo.MoneyRecord;
import com.ht.pojo.Ttzbank;
import com.ht.pojo.Ttzuser;
import com.ht.service.MoneyRecordService;
import com.ht.service.TtzbanlService;
@Controller
@RequestMapping("WithDraw")
public class WithDrawController {
	@Resource
	private TtzbanlService ttzService;
	@Resource
	private MoneyRecordService mrService;
	//查询出用户绑定的银行卡
	@RequestMapping("selUserBank")
	@ResponseBody
	public Map<String, Object> selUserBank(HttpServletRequest request) throws Exception{
		Ttzuser user = (Ttzuser) request.getSession().getAttribute("user");
		List<Ttzbank> Ttzlist=ttzService.selBankcard(user.getUserid());
		System.out.println(Ttzlist.size());
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("Ttzlist", Ttzlist);
		return map;
	}
	//提现
	@RequestMapping("bankWithDraw")
	@ResponseBody
	public Map<String, Object> withDraw(HttpServletRequest request,
			@RequestParam(value="userid",required=false)String userid,
			@RequestParam(value="bankcard",required=false)String bankcard,
			@RequestParam(value="takeMoney",required=false)Double takeMoney) throws Exception{
		
		Map<String, Object> map=new HashMap<String, Object>();
		Ttzuser user = (Ttzuser) request.getSession().getAttribute("user");
		request.getSession().removeAttribute("user");
//		Double actualMoney = user.getMoney();
		//手续费
		Double shouxufei = takeMoney*0.001;
		Double shangxian = mrService.yxmoney(user.getUserid());//每日提取金额上限
		System.out.println("上限"+shangxian);
		if(takeMoney > 0&&shouxufei<=2){
			user.setMoney(user.getMoney()-takeMoney-2);
			request.getSession().setAttribute("user",user);
		}else if(shouxufei>2&&shouxufei<100){
			user.setMoney(user.getMoney()-takeMoney-shouxufei);
			request.getSession().setAttribute("user",user);
		}else if(shouxufei>100){
			user.setMoney(user.getMoney()-takeMoney-100);
			request.getSession().setAttribute("user",user);
		}
		if(takeMoney+shangxian>1000000){//如果当日取的钱加上当前取的钱>1000000
			
			Double kequyue  = 1000000-shangxian;
			String warm = "每日最多可提现1000000！你当天还可提现"+kequyue+"元";
			map.put("warm", warm);
			System.out.println("每日最多可提现1000000！你当天还可提现"+kequyue+"元");
		}else if(shangxian>1000000){//如果当日取的钱>1000000
			String warm = "您已经达到当日提取上限！请明日再来！";
			map.put("warm", warm);
		}else if(takeMoney>user.getMoney()){//提取的钱大于余额
			String warm = "余额不足！当前可用余额为"+user.getMoney()+"元";
			map.put("warm", warm);
			System.out.println("余额不足！当前可用余额为"+user.getMoney()+"元");
		}else{
			ttzService.withDraw(userid, bankcard, takeMoney);
			System.out.println(userid+" "+bankcard+" "+takeMoney);
			String warm = "提现成功！您的金额将在两小时内到账";
			map.put("warm", warm);
			map.put("money", user.getMoney());
			System.out.println("提现成功！您的金额将在两小时内到账");
		}
		
				
				
		return map;
	}
}
