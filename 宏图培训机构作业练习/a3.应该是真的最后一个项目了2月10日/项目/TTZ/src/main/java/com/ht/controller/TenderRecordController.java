package com.ht.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.pojo.Borrowmoney;
import com.ht.pojo.MoneyRecord;
import com.ht.pojo.TenderRecord;
import com.ht.pojo.Tenderaward;
import com.ht.service.BorrowmoneyService;
import com.ht.service.TenderRecordService;
import com.ht.util.SystemContant;

@Controller
@RequestMapping("/")
public class TenderRecordController {

	@Resource
	TenderRecordService ts;
	@Resource
	BorrowmoneyService bs;

	@RequestMapping("TenderRecordList")
	public Object TenderRecordList(Model model, HttpSession session,
			@RequestParam(value = "currPage", required = false) Integer currPage) {

		int pageCount = 2; // 每页行数
		int totalRow = 0; // 总行数
		int totalPage = 0; // 总页数

		if (currPage != null && !"".equals(currPage)) {
			currPage = currPage;
		} else {
			currPage = 1;
		}

		Map<String, Object> map1 = new HashMap<String, Object>();
		totalRow = ts.SelTenderRecord(map1);
		totalPage = (totalRow + pageCount - 1) / pageCount;

		if (currPage < 1) {
			currPage = 1;
		}

		if (currPage > totalPage) {
			currPage = totalPage;
		}

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("currPage", currPage);
		map2.put("pageCount", pageCount);

		List<TenderRecord> list = ts.TenderRecordList(map2);
		model.addAttribute("list", list);
		model.addAttribute("currPage", currPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage", totalPage);

		int money = ts.TenderRecoreAmount();
		session.putValue("money", money);
		int earnings = ts.TenderRecordEarnings();
		session.putValue("earnings", earnings);
		int poundage = ts.TenderRecordPoundage();
		session.putValue("poundage", poundage);
		return "foregroundSystem/personal_touzijilu.jsp";
	}

	@RequestMapping("TenderRecordCompleted")
	public String TenderRecordCompleted(Model model, HttpSession session,
			@RequestParam(value = "currPage", required = false) Integer currPage) {

		int pageCount = 5; // 每页行数
		int totalRow = 0; // 总行数
		int totalPage = 0; // 总页数

		if (currPage != null && !"".equals(currPage)) {
			currPage = currPage;
		} else {
			currPage = 1;
		}
		Map<String, Object> map1 = new HashMap<String, Object>();
		totalRow = ts.SelTenderRecordCompleted(map1);
		totalPage = (totalRow + pageCount - 1) / pageCount;

		if (currPage < 1) {
			currPage = 1;
		}

		if (currPage > totalPage) {
			currPage = totalPage;
		}

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("currPage", currPage);
		map2.put("pageCount", pageCount);
		List<Tenderaward> list = ts.TenderRecordCompleted(map2);
		model.addAttribute("list", list);
		model.addAttribute("currPage", currPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage", totalPage);

		int zhong = ts.TenderRecordZhong();
		session.putValue("zhong", zhong);
		int sum = ts.TenderRecordSum();
		session.putValue("sum", sum);
		return "foregroundSystem/personal_touzijilu2.jsp";
	}

	@RequestMapping("SelHuiKuan")
	public String SelHuiKuan(@RequestParam(value = "currPage", required = false) Integer currPage, Model model,
			HttpSession session) {
		int pageCount = 5; // 每页行数
		int totalRow = 0; // 总行数
		int totalPage = 0; // 总页数

		if (currPage != null && !"".equals(currPage)) {
			currPage = currPage;
		} else {
			currPage = 1;
		}

		Map<String, Object> map1 = new HashMap<String, Object>();
		totalRow = ts.SelHuiKuanCount(map1);
		totalPage = (totalRow + pageCount - 1) / pageCount;

		if (currPage < 1) {
			currPage = 1;
		}

		if (currPage > totalPage) {
			currPage = totalPage;
		}

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("currPage", currPage);
		map2.put("pageCount", pageCount);
		List<Tenderaward> list = ts.SelHuiKuan(map2);
		List<Borrowmoney> listb = bs.selAllBorrow();
		// for (Borrowmoney borrowmoney : listb) {
		// System.out.println(borrowmoney.getBorrow_yt() + " 3333");
		// }
		model.addAttribute("listb", listb);
		model.addAttribute("list", list);
		model.addAttribute("currPage", currPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("statu", 1);
		return "foregroundSystem/pesonal_index.jsp";
	}

	@RequestMapping("MoHuSelTenderRecord")
	public String MoHuSelTenderRecord(@RequestParam(value = "tender_time", required = false) String tender_time) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (tender_time != null && tender_time.equals("")) {
			map.put("tender_time", tender_time);
		}
		List list = ts.MoHuSelTenderRecord(map);
		return "redirect:TenderRecordList.action";
	}

	@RequestMapping("SelMoneyRecord")
	public String SelMoneyRecord(@RequestParam(value = "currPage", required = false) Integer currPage, Model model) {

		int pageCount = 5; // 每页行数
		int totalRow = 0; // 总行数
		int totalPage = 0; // 总页数

		if (currPage != null && !"".equals(currPage)) {
			currPage = currPage;
		} else {
			currPage = 1;
		}

		Map<String, Object> map1 = new HashMap<String, Object>();
		totalRow = ts.SelMoneyRecordCount(map1);
		totalPage = (totalRow + pageCount - 1) / pageCount;

		if (currPage < 1) {
			currPage = 1;
		}

		if (currPage > totalPage) {
			currPage = totalPage;
		}

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("currPage", currPage);
		map2.put("pageCount", pageCount);
		List<MoneyRecord> mlist = ts.SelMoneyRecord(map2);
		model.addAttribute("mlist", mlist);
		model.addAttribute("currPage", currPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("statu", 2);
		return "foregroundSystem/pesonal_index.jsp";
	}

	@RequestMapping("TouZiJilu")
	public String TouZiJiluCount(@RequestParam(value = "currPage", required = false) Integer currPage, Model model) {
		int pageCount = 5; // 每页行数
		int totalRow = 0; // 总行数
		int totalPage = 0; // 总页数

		if (currPage != null && !"".equals(currPage)) {
			currPage = currPage;
		} else {
			currPage = 1;
		}

		Map<String, Object> map1 = new HashMap<String, Object>();
		totalRow = ts.TouZiJiluCount(map1);
		totalPage = (totalRow + pageCount - 1) / pageCount;

		if (currPage < 1) {
			currPage = 1;
		}

		if (currPage > totalPage) {
			currPage = totalPage;
		}

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("currPage", currPage);
		map2.put("pageCount", pageCount);
		List<MoneyRecord> tlist = ts.TouZiJilu(map2);
		model.addAttribute("tlist", tlist);
		model.addAttribute("currPage", currPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("statu", 3);
		return "foregroundSystem/pesonal_index.jsp";
	}

	@RequestMapping("SelMoneyRecordByID")
	public String SelMoneyRecordByID(@RequestParam(value = "p_userid", required = false) String p_userid, Model model,
			HttpSession session) {
		List ls = ts.SelMoneyRecordByID(p_userid);
		int SumMoney = ts.SumMoney();
		model.addAttribute("SumMoney", SumMoney);
		model.addAttribute("ls", ls);
		return "foregroundSystem/personal_touzijilu3.jsp";
	}

	@RequestMapping("TenderRecordCompletedStatuON0")
	public String TenderRecordCompletedStatuON0(@RequestParam(value = "currPage", required = false) Integer currPage,
			Model model) {
		int pageCount = 5; // 每页行数
		int totalRow = 0; // 总行数
		int totalPage = 0; // 总页数
		if (currPage != null && !"".equals(currPage)) {
			currPage = currPage;
		} else {
			currPage = 1;
		}
		totalRow = ts.selectTenderRecordstatu0Count(SystemContant.tuser.getUserid());
		totalPage = (totalRow + pageCount - 1) / pageCount;

		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > totalPage) {
			currPage = totalPage;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currPage", currPage);
		map.put("pageCount", pageCount);
		map.put("userid", SystemContant.tuser.getUserid());
		List<TenderRecord> tender = ts.selectTenderRecordstatu0(map);
		Double SumMoney = 0.00;
		for (TenderRecord tenderRecord : tender) {
			SumMoney += tenderRecord.getTender_money();
		}
		model.addAttribute("ls", tender);
		model.addAttribute("currPage", currPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("SumMoney", SumMoney);
		return "foregroundSystem/personal_touzijilu4.jsp";
	}

	@ResponseBody
	@RequestMapping("SumlistMoney")
	public Map<String, Object> SumlistMoney() {
		Map<String, Object> map = new HashMap<String, Object>();
		List sumlistmoney = ts.SumlistMoney();
		System.out.println(sumlistmoney.size());
		map.put("sumlistmoney", sumlistmoney);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("SumInterest")
	public Map<String, Object> SumInterest() {
		Map<String, Object> map = new HashMap<String, Object>();
		List suminterest = ts.SumInterest();
		System.out.println(suminterest.size());
		map.put("suminterest", suminterest);
		return map;
	}
}
