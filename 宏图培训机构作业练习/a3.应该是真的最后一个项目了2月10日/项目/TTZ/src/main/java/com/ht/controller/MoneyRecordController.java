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
 * �û��ʽ��׼�¼ ���Ʋ�
 */
@Controller
@RequestMapping("moneyrecord")
public class MoneyRecordController {
	@Resource
	private MoneyRecordService moneyservice;
	
	@Resource
	private TtzuserService ttuservice;
	
	//��ֵ��¼
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
	
	//���׼�¼
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
	
	//������ѯ
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
	//���ּ�¼
	@RequestMapping("WithdrawList")
	@ResponseBody
	public Map<String, Object> inbListPage(@RequestParam(value="cPage",required=false) String cPage) throws Exception{
		int currPage = 1;// ��ǰҳ��
		int pageCount = 5;// ÿҳ����
		int totalRow = 0;// ������
		int totalPage = 0;// ��ҳ��
		
		//�ڶ��ν���
		if (cPage != null && !"".equals(cPage)) {
			currPage=Integer.parseInt(cPage);			
		}
		// �������Ļ�ȡ����
		totalRow = moneyservice.withdrawList().size();
		// ������ҳ��
		totalPage = (totalRow + pageCount - 1) / pageCount;
		// �жϵ�ǰҳ�Ƿ�С��1
				if (currPage < 1) {
					currPage = 1;
				}

				// �����ǰҳ������ҳ��
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
	//ʱ��ɸѡ
	@RequestMapping("selforTime")
	@ResponseBody
	public Map<String, Object> selforTime(@RequestParam(value="seltime",required=false) Integer seltime) throws Exception{
		System.out.println("coming");
		
		Map<String, Object> map=new HashMap<String, Object>();
		List<Ttzuser> tuserlist = ttuservice.UserList();
		map.put("tuserlist", tuserlist);
		if(seltime==0){
			List<MoneyRecord> todaylist = moneyservice.todayList();//����
			map.put("todaylist", todaylist);
			System.out.println("����"+todaylist.size());
		}else if(seltime==1){
			List<MoneyRecord> weeklist = moneyservice.weekList();//����
			map.put("weeklist", weeklist);
			System.out.println("����");
		}else if(seltime==2){
			List<MoneyRecord> monthlist = moneyservice.monthList();//����
			map.put("monthlist", monthlist);
			System.out.println("����");
		}else if(seltime==3){
			List<MoneyRecord> lastdaylist = moneyservice.lastdayList();//����
			map.put("lastdaylist", lastdaylist);
			System.out.println("����");
		}else if(seltime==4){
			List<MoneyRecord> lastweeklist = moneyservice.lastweekList();//����
			map.put("lastweeklist", lastweeklist);
			System.out.println("����");
		}else if(seltime==5){
			List<MoneyRecord> lastmonthlist = moneyservice.lastmonthList();//�ϸ���
			map.put("lastmonthlist", lastmonthlist);
			System.out.println("����");
		}else {
			System.out.println("δѡ");
		}
		
		return map;
	}
}
