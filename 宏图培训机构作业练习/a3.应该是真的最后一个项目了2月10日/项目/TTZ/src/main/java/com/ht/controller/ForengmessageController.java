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
		int currPage = 1;// ��ǰҳ��
		int pageCount = 5;// ÿҳ����
		int totalRow = 0;// ������
		int totalPage = 0;// ��ҳ��
		
		//�ڶ��ν���
		if (cPage != null && !"".equals(cPage)) {
			currPage=Integer.parseInt(cPage);			
		}
		// �������Ļ�ȡ����
		totalRow = frgService.countAllMsg(SystemContant.tuser.getUserid()+"");
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
		map.put("m_userid", SystemContant.tuser.getUserid()+"");
		List<Forengmessage> frmlist = frgService.selectAllMsg(map);
		
		map.put("frmlist", frmlist);
		
		return map;
	}
}
