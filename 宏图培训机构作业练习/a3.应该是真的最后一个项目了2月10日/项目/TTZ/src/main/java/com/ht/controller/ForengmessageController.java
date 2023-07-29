package com.ht.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.pojo.Forengmessage;
import com.ht.service.ForengmessageService;
import com.ht.util.SystemContant;
@Controller
@RequestMapping("ForengMessage")
public class ForengmessageController {
	@Resource
	private ForengmessageService frgService;
	
	@RequestMapping("FrmList")
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
		totalRow = frgService.countAllMsg(SystemContant.tuser.getUserid()+"");
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
		map.put("m_userid", SystemContant.tuser.getUserid()+"");
		List<Forengmessage> frmlist = frgService.selectAllMsg(map);
		
		map.put("frmlist", frmlist);
		
		return map;
	}
}
