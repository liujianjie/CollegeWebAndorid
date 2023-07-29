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
	//��ѯ���û��󶨵����п�
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
	//����
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
		//������
		Double shouxufei = takeMoney*0.001;
		Double shangxian = mrService.yxmoney(user.getUserid());//ÿ����ȡ�������
		System.out.println("����"+shangxian);
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
		if(takeMoney+shangxian>1000000){//�������ȡ��Ǯ���ϵ�ǰȡ��Ǯ>1000000
			
			Double kequyue  = 1000000-shangxian;
			String warm = "ÿ����������1000000���㵱�컹������"+kequyue+"Ԫ";
			map.put("warm", warm);
			System.out.println("ÿ����������1000000���㵱�컹������"+kequyue+"Ԫ");
		}else if(shangxian>1000000){//�������ȡ��Ǯ>1000000
			String warm = "���Ѿ��ﵽ������ȡ���ޣ�������������";
			map.put("warm", warm);
		}else if(takeMoney>user.getMoney()){//��ȡ��Ǯ�������
			String warm = "���㣡��ǰ�������Ϊ"+user.getMoney()+"Ԫ";
			map.put("warm", warm);
			System.out.println("���㣡��ǰ�������Ϊ"+user.getMoney()+"Ԫ");
		}else{
			ttzService.withDraw(userid, bankcard, takeMoney);
			System.out.println(userid+" "+bankcard+" "+takeMoney);
			String warm = "���ֳɹ������Ľ�����Сʱ�ڵ���";
			map.put("warm", warm);
			map.put("money", user.getMoney());
			System.out.println("���ֳɹ������Ľ�����Сʱ�ڵ���");
		}
		
				
				
		return map;
	}
}
