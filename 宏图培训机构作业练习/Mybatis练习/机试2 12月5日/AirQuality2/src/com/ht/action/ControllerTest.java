package com.ht.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ht.bean.AirQualityBean;
import com.ht.service.AirQualityI;
import com.ht.service.DistricI;

@Controller
@RequestMapping("/")
public class ControllerTest {
	@Resource
	private AirQualityI air;
	
	@Resource
	private DistricI dis;
	
	@RequestMapping("hello")
	public String hello(){
		System.out.println("hello world");
		return null;
	}
	//ȫ��airlist
	@RequestMapping("sellist")
	public String sellist(Model model,@RequestParam(value = "cpage")int cpage){
		int currpage = 1;
		int pagecount = 3;
		int totalcount = air.selcount();//����
		int totalpage = (totalcount+pagecount-1)/pagecount;//ҳ��
		
		if(cpage!=0){
			currpage = cpage;
		}
		if(cpage>totalpage){
			currpage = totalpage;
		}		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("currpage", currpage);
		map.put("pagecount", pagecount);
		
		model.addAttribute("list", air.selairlist(map));
		model.addAttribute("option",0);
		model.addAttribute("currpage",currpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("id", 1);
		return "alllist";
	}
	//d_id����ɸѡ
	@RequestMapping("sellistofdid")
	public String sellistofdid(@RequestParam(value  = "did")Integer d_id,Model model,
			@RequestParam(value = "cpage")int cpage){
		System.out.println(d_id);
		if(d_id==0){
			return "redirect:/sellist.do?cpage=1";
		}
		
		int currpage = 1;
		int pagecount = 3;
		int totalcount = air.selcountofid(d_id);//����
		int totalpage = (totalcount+pagecount-1)/pagecount;//ҳ��
		
		if(cpage!=0){
			currpage = cpage;
		}
		if(cpage>totalpage){
			currpage = totalpage;
		}		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("currpage", currpage);
		map.put("pagecount", pagecount);
		map.put("id", d_id);
		
		model.addAttribute("list", air.selairlistofdid(map));
		model.addAttribute("option",d_id);
		model.addAttribute("currpage",currpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("id", 2);
		model.addAttribute("dids", d_id);
		return "alllist";
	}
	//���
	@RequestMapping("addair")
	public String addair(AirQualityBean airs){
		System.out.println(airs.getD_id());
		airs.setA_latetime((new Date()).toLocaleString());
		int i=air.addair(airs);
		return "redirect:/sellist.do?cpage=1";
		
	}
	//�鿴����
	@RequestMapping("airxq")
	public String airxq(@RequestParam(value = "id")Integer d_id,Model model){
		AirQualityBean airs = air.airxq(d_id);
		model.addAttribute("air", airs);
		return "alertair";
	}
	//�޸�����
	@RequestMapping("alertair")
	public String alertair(AirQualityBean airs){
		airs.setA_latetime((new Date()).toLocaleString());
		air.alertair(airs);
		return "redirect:/sellist.do?cpage=1";
	}
	//ɾ������
	@RequestMapping("delair")
	public String delair(@RequestParam(value = "id")Integer id){
		System.out.println("ɾ��");
		air.delair(id);
		return "redirect:/sellist.do?cpage=1";
	}
}
