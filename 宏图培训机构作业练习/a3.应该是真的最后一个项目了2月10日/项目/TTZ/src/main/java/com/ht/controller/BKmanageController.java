package com.ht.controller;

import java.io.UnsupportedEncodingException;
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
import com.ht.service.TtzbanlService;
import com.ht.service.TtzuserService;
/**
 * ���п�����
 * **/
@Controller
@RequestMapping("bankcardmanage")
public class BKmanageController {
	@Resource
	private TtzuserService ttzService;
	@Resource
	private TtzbanlService bankService;
	//���ּ�¼
		@RequestMapping("bkList")
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
			totalRow = ttzService.UserList().size();
			System.out.println("��ҳ��"+totalRow);
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
			
			List<Ttzuser> userlist = ttzService.UsrtlistPage(map);
			
			map.put("userlist", userlist);
			
			return map;
		}
		//��ѯ���û��󶨵����п�
		@RequestMapping("selBankcard")
		@ResponseBody
		public Map<String, Object> selUserBank(
				@RequestParam(value="userid",required=false) String userid) throws Exception{
			List<Ttzbank> Ttzlist=bankService.selBankcard(userid);
			System.out.println(userid);
			System.out.println(Ttzlist.size());
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("Ttzlist", Ttzlist);
			return map;
		}
		//����󶨵����п�
		@RequestMapping("delTtzbank")
		@ResponseBody
		public String delInbound(@RequestParam(value="tbid",required=false)String tbid){
			System.out.println("del");
			bankService.delbankcard(tbid);
			System.out.println(tbid);
			return "redirect:../backgroundSystem/bankcardManage.jsp";
		}
		//ģ����ѯ
		@RequestMapping("selUserForbank")
		@ResponseBody
		public Map<String,Object> selUserForbank(@RequestParam(value="username",required=false)String username){
			try {
				username=new String(username.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("�û���"+username);
			List<Ttzuser> Ttzlist=ttzService.selUserForbank(username);
			
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("Ttzuserlist", Ttzlist);
			return map;
		}
}
