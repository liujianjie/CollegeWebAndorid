package com.ht.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.pojo.Bankcard;
import com.ht.pojo.Borrowmoney;
import com.ht.pojo.MoneyRecord;
import com.ht.pojo.TenderRecord;
import com.ht.pojo.Ttzbank;
import com.ht.pojo.Ttzuser;
import com.ht.service.BorrowmoneyService;
import com.ht.service.FactorageService;
import com.ht.service.MoneyRecordService;
import com.ht.service.TenderRecordService;
import com.ht.service.TtzbanlService;
import com.ht.service.TtzuserService;
import com.ht.util.PoiWriter;
import com.ht.util.SystemContant;

@Controller
@RequestMapping("/")
public class FactorageController {

	@Resource
	private FactorageService facservice;

	@Resource
	private TtzuserService ttuservice;

	@Resource
	private MoneyRecordService mrService;

	@Resource
	private TenderRecordService trService;

	@Resource
	private BorrowmoneyService borrowService;

	@Resource
	private TtzbanlService ttzBankService;

	// 前台
	@RequestMapping("mr_list")
	public String mrList(@RequestParam(value = "sel_time", required = false) String sel_time,
			@RequestParam(value = "cPage", required = false) String cPage, Model model) {
		int currPage = 1;
		int pageCount = 5;
		int totalRow = 0;// 总行
		int totalPage = 0;// 总页

		if (cPage != null && !"".equals(cPage)) {
			currPage = Integer.parseInt(cPage);
		}

		Map<String, Object> map2 = new HashMap<String, Object>();
		if (sel_time != null && !sel_time.equals("")) {
			map2.put("m_happentime", sel_time);
		}
		map2.put("p_userid", SystemContant.tuser.getUserid() + "");
		totalRow = mrService.count(map2).size();
		totalPage = (totalRow + pageCount - 1) / pageCount;
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > totalPage) {
			currPage = totalPage;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageCount", pageCount);
		map.put("currPage", currPage);
		if (sel_time != null && !sel_time.equals("")) {
			map.put("m_happentime", sel_time);
		}
		map.put("p_userid", SystemContant.tuser.getUserid());
		List<MoneyRecord> list = mrService.list(map);
		model.addAttribute("mr_list", list);
		model.addAttribute("currPage", currPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage", totalPage);
		return "foregroundSystem/personal_zijinjilu.jsp";
	}

	@RequestMapping("createexcel")
	public void createExcel(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		System.out.println("---------------------");
		try {
			Ttzuser ttz = (Ttzuser) request.getSession().getAttribute("user");
			List<MoneyRecord> mrlist = mrService.countrow(ttz.getUserid());
			System.out.println("mrlist.size()=" + mrlist.size());
			String fileName = "奖金记录表";
			String path = session.getServletContext().getRealPath("upload");
			// 保存到服务器
			PoiWriter.savegood(fileName, path, mrlist);

			// 选择目录保存u
			String savePath = path + "\\" + fileName + ".xls";
			// path是指欲下载的文件的路径。
			File file = new File(savePath);
			// 取得文件名。
			String filename = file.getName();
			// 以流的形式下载文件。
			InputStream fis;
			fis = new BufferedInputStream(new FileInputStream(savePath));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition",
					"attachment;filename=" + new String(filename.getBytes("utf-8"), "iso8859-1")); // "iso8859-1"),"utf-8"
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 充值是查询出当前登录用户下绑定的银行卡号码
	@RequestMapping("selBank")
	public String selBankById(HttpServletRequest request, Model model) {
		Ttzuser user = (Ttzuser) request.getSession().getAttribute("user");
		List<Ttzbank> Ttzlist = ttzBankService.selBankcard(user.getUserid());
		System.out.println(Ttzlist.size() + " ddddddddddddd");
		model.addAttribute("ttzlist", Ttzlist);
		return "foregroundSystem/personal_chongzhi_1.jsp";
	}

	@ResponseBody
	@RequestMapping("chongzhi")
	public Map<String, Object> ttzUserById(HttpServletRequest request, Model model,
			@RequestParam(value = "cz_money", required = false) Double cz_money,
			@RequestParam(value = "bank_id", required = false) String bank_id) {

		Map<String, Object> map = new HashMap<String, Object>();
		Ttzuser ttz = (Ttzuser) request.getSession().getAttribute("user");
		System.out.println("++++++++++");
		System.out.println("cz_money = " + cz_money);
		System.out.println("bank_id = " + bank_id);
		System.out.println("p_userid = " + ttz.getUserid());
		System.out.println("----------");

		map.put("p_userid", ttz.getUserid());
		map.put("b_bkmoney", cz_money);
		map.put("b_bkcard", bank_id);

		Bankcard b_bank = mrService.sel_bank(bank_id);

		Map<String, Object> map3 = new HashMap<String, Object>();
		if (cz_money > b_bank.getBkmoney()) {
			map3.put("statu", "银行卡余额不足！");
		} else {
			mrService.cunchu(map);
			map3.put("statu", "充值成功！");
		}
		// 查询用户
		Ttzuser user = ttuservice.Login(SystemContant.tuser.getUsername(), SystemContant.tuser.getPwd());
		request.getSession().setAttribute("user", user);
		return map3;
	}

	// 充值记录
	@RequestMapping("ListFactorage")
	public String ListFactorage(Model model) {
		int count = facservice.CountFactorage();
		List list = facservice.ListFactorage();
		List user = ttuservice.UserList();
		model.addAttribute("list", list);
		model.addAttribute("user", user);
		model.addAttribute("count", count);
		return "backgroundSystem/listfactorage.jsp";
	}

	// 后台
	@RequestMapping("touzhi")
	public String touzhi_list(@RequestParam(value = "statu", required = false) String statu, Model model) {
		System.out.println("//////////////////////");
		System.out.println(statu + " nnnnnnnnnnn");
		List<TenderRecord> tr_list = null;
		Map<String, Object> map = new HashMap<String, Object>();
		if (statu != null && !statu.equals("")) {
			map.put("tender_statu", statu);
		}
		tr_list = trService.sel_tend_list(map);
		List<Ttzuser> user_list = ttuservice.UserList();
		model.addAttribute("tr_list", tr_list);
		model.addAttribute("user_list", user_list);
		return "backgroundSystem/touzhi_list.jsp";
	}

	// 查询借款列表
	@RequestMapping("borrow_list")
	public String sel_borrow(@RequestParam(value = "status", required = false) String status, Model model) {
		System.out.println("11111111111111");

		Map<String, Object> map = new HashMap<String, Object>();

		if (status != null && !status.equals("")) {
			map.put("statu", status);
		}

		List<Borrowmoney> borr_list = borrowService.sel_borrow_statu(map);
		System.out.println(borr_list.size());
		model.addAttribute("borr_list", borr_list);

		return "backgroundSystem/borrow_list.jsp";
	}

}
