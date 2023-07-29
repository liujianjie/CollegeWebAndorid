package com.ht.controller;



import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.pojo.MoneyRecord;
import com.ht.pojo.Ttzuser;
import com.ht.service.MoneyRecordService;
import com.ht.service.TtzuserService;

/**
 * 用户资金交易记录 控制层
 */
@Controller
@RequestMapping("moneyrecord")
public class MoneyRecordController {
	@Resource
	private MoneyRecordService moneyservice;
	
	@Resource
	private TtzuserService ttuservice;
	
	//充值记录
	@RequestMapping("TopupMoner")
	public String TopupMoner(Model model){
		int count = moneyservice.TopupCount();
	 	List list = moneyservice.TopupMoner();
	 	List user = ttuservice.UserList();
	 	model.addAttribute("list", list);
	 	model.addAttribute("user", user);
	 	model.addAttribute("count", count);
		return "../backgroundSystem/topupmoney.jsp";
	}
	
	//交易记录
	@RequestMapping("TradingRecord")
	public String TradingRecord(Model model){
		int count = moneyservice.TradingCount();
	 	List list = moneyservice.TradingRecord();
	 	List user = ttuservice.UserList();
	 	model.addAttribute("list", list);
	 	model.addAttribute("user", user);
	 	model.addAttribute("count", count);
		return "../backgroundSystem/tradingrecord.jsp";
	}
	
	//条件查询
	@RequestMapping("ConditionQuery")
	public String ConditionQuery(@RequestParam(value = "m_date", required = false) String m_date,Model model){
		Map<String, Object> map = new HashMap<String, Object>();
	 	List user = ttuservice.UserList();
		if(m_date != null && !m_date.equals("")){
			map.put("m_happentime", m_date);
		}
		List list = moneyservice.ConditionQuery(map);
	 	model.addAttribute("user", user);
	 	model.addAttribute("list", list);
		return "../backgroundSystem/tradingrecord.jsp";
	}
	//提现记录
	@RequestMapping("WithdrawList")
	@ResponseBody
	public Map<String, Object> inbListPage(@RequestParam(value="cPage",required=false) String cPage) throws Exception{
		int currPage = 1;// 当前页数
		int pageCount = 5;// 每页行数
		int totalRow = 0;// 总行数
		int totalPage = 0;// 总页数
		
		//第二次进来
		if (cPage != null && !"".equals(cPage)) {
			currPage=Integer.parseInt(cPage);			
		}
		// 总行数的获取方法
		totalRow = moneyservice.withdrawList().size();
		// 计算总页数
		totalPage = (totalRow + pageCount - 1) / pageCount;
		// 判断当前页是否小于1
				if (currPage < 1) {
					currPage = 1;
				}

				// 如果当前页大于总页数
				if (currPage > totalPage) {
					currPage = totalPage;
				}
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("currPage", currPage);
		map.put("pageCount", pageCount);
		map.put("totalRow", totalRow);
		map.put("totalPage", totalPage);
		map.put("cPage", cPage);
		List<MoneyRecord> wdlist = moneyservice.wdListPage(map);
		List<Ttzuser> tuserlist = ttuservice.UserList();

		map.put("wdlist", wdlist);
		map.put("tuserlist", tuserlist);

		return map;
	}
	//时间筛选
	@RequestMapping("selforTime")
	@ResponseBody
	public Map<String, Object> selforTime(@RequestParam(value="seltime",required=false) Integer seltime) throws Exception{
		System.out.println("coming");
		
		Map<String, Object> map=new HashMap<String, Object>();
		List<Ttzuser> tuserlist = ttuservice.UserList();
		map.put("tuserlist", tuserlist);
		if(seltime==0){
			List<MoneyRecord> todaylist = moneyservice.todayList();//当天
			map.put("todaylist", todaylist);
			System.out.println("当天"+todaylist.size());
		}else if(seltime==1){
			List<MoneyRecord> weeklist = moneyservice.weekList();//本周
			map.put("weeklist", weeklist);
			System.out.println("本周");
		}else if(seltime==2){
			List<MoneyRecord> monthlist = moneyservice.monthList();//本月
			map.put("monthlist", monthlist);
			System.out.println("本月");
		}else if(seltime==3){
			List<MoneyRecord> lastdaylist = moneyservice.lastdayList();//昨天
			map.put("lastdaylist", lastdaylist);
			System.out.println("昨天");
		}else if(seltime==4){
			List<MoneyRecord> lastweeklist = moneyservice.lastweekList();//上周
			map.put("lastweeklist", lastweeklist);
			System.out.println("上周");
		}else if(seltime==5){
			List<MoneyRecord> lastmonthlist = moneyservice.lastmonthList();//上个月
			map.put("lastmonthlist", lastmonthlist);
			System.out.println("上月");
		}else {
			System.out.println("未选");
		}
		
		return map;
	}
}
