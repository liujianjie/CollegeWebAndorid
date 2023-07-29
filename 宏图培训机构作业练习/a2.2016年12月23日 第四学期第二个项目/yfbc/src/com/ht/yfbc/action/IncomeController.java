package com.ht.yfbc.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ht.yfbc.pojo.Income;
import com.ht.yfbc.service.IncomeService;

@Controller
@RequestMapping("income")
public class IncomeController {

	@Resource
	private IncomeService incService;

	@RequestMapping("incomelist")
	private String selIncomelist(@RequestParam(value = "pageCount", required = false) Integer pageCount,
			@RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "v", required = false) String version, Model model) {

		int totalRow = incService.selCount();
		System.out.println("数据总行数totalRow = "+totalRow);
		System.out.println("每页行数pageCount = "+pageCount);
		System.out.println("当前页码currPage = "+currPage);
		int totalPage = (totalRow + pageCount - 1) / pageCount;
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > totalPage) {
			currPage = totalPage;
		}
		System.out.println(pageCount + "currPage" + currPage);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageCount", pageCount);
		map.put("currPage", currPage);

		List<Income> incomes = incService.findIncomeList(map);
		model.addAttribute("incomes", incomes);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("currPage", currPage);
		return "chenhao/incomelist";
	}

	@RequestMapping("toaddincome")
	private String toaddIncome(Model model) {
		List<Income> inc = incService.selIncomeList();
		model.addAttribute("inc", inc);
		return "chenhao/incomeadd";
	}

	@RequestMapping("addincome")
	private String addIncome(Income income) {
		System.out.println(income.getMoney()+"---vvvvv");
		incService.addIncome(income);
		return "redirect:/income/incomelist.do?pageCount=9&currPage=1&v=0";
	}

	@RequestMapping("del")
	public String delIncome(@RequestParam(value = "id", required = false) String id) {
		incService.delIncome(id);

		return "redirect:/income/incomelist.do?pageCount=9&currPage=1&v=0";

	}

	@RequestMapping("toupdincome")
	public String toupd(@RequestParam(value = "id", required = false) String id, Model model) {
		Income income = incService.selIncomeById(id);
		model.addAttribute("income", income);
		return "chenhao/incomeupd";
	}

	@RequestMapping("updincome")
	public String upd(Income income) {
		incService.updIncome(income);
		System.out.println(income.getTypes());
		return "redirect:/income/incomelist.do?pageCount=9&currPage=1&v=0";
	}
}
