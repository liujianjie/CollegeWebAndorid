package com.ht.yfbc.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ht.yfbc.pojo.Expend;
import com.ht.yfbc.service.ExpendService;

@Controller
@RequestMapping("expend")
public class ExpendController {
	
	@Resource
	private ExpendService expendService;

	@RequestMapping("expendlist")
	private String selExpendlist(@RequestParam(value = "pageCount", required = false) Integer pageCount,
			@RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "v", required = false) String version, Model model) {

		int totalRow = expendService.selCount();
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

		List<Expend> expends = expendService.findExpendList(map);
		model.addAttribute("expends", expends);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("currPage", currPage);
		return "chenhao/expendlist";
	}

	@RequestMapping("toaddexpend")
	private String toaddExpend(Model model) {
		List<Expend> inc = expendService.selExpendList();
		model.addAttribute("inc", inc);
		return "chenhao/expendadd";
	}

	@RequestMapping("addexpend")
	private String addExpend(Expend expend) {
		expendService.addExpend(expend);
		return "redirect:/expend/expendlist.do?pageCount=9&currPage=1&v=0";
	}

	@RequestMapping("del")
	public String delExpend(@RequestParam(value = "id", required = false) String id) {
		expendService.delExpend(id);

		return "redirect:/expend/expendlist.do?pageCount=9&currPage=1&v=0";

	}

	@RequestMapping("toupdexpend")
	public String toupd(@RequestParam(value = "id", required = false) String id, Model model) {
		Expend expend = expendService.selExpendById(id);
		model.addAttribute("expend", expend);
		return "chenhao/expendupd";
	}

	@RequestMapping("updexpend")
	public String upd(Expend expend) {
		expendService.updExpend(expend);
		return "redirect:/expend/expendlist.do?pageCount=9&currPage=1&v=0";
	}
}
