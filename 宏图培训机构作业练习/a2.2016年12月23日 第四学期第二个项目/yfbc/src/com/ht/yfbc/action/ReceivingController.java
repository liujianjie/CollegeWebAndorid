package com.ht.yfbc.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ht.yfbc.dao.RackDao;
import com.ht.yfbc.dao.WarehouseDao;
import com.ht.yfbc.pojo.Goodtype;
import com.ht.yfbc.pojo.InStorage;
import com.ht.yfbc.pojo.Putaway;
import com.ht.yfbc.pojo.Rack;
import com.ht.yfbc.pojo.Rack2;
import com.ht.yfbc.pojo.Receiving;
import com.ht.yfbc.pojo.Users;
import com.ht.yfbc.pojo.Warehouse2;
import com.ht.yfbc.service.GoodtypeService;
import com.ht.yfbc.service.InStorageService;
import com.ht.yfbc.service.PutawayService;
import com.ht.yfbc.service.RackService;
import com.ht.yfbc.service.ReceivingService;

/**
 * 收货单控制层
 * day 2016-12-28
 * @author 刘建杰
 *
 */

@Controller
@RequestMapping("receiving")
public class ReceivingController {
	
	@Resource
	private ReceivingService receivingservice;
	
	@Resource
	private InStorageService instorageservice;
	
	@Resource
	private GoodtypeService goodservice;
	
	@Resource
	private WarehouseDao wardao;
	
	@Resource
	private RackService rackservice;
	
	@Resource
	private PutawayService putawayservice;
	
	@RequestMapping("list")
	private String list(Model model,
			@RequestParam(value = "cpage")Integer cpage){
		Map<String, Object> maps = receivingservice.selReceiving(cpage,null,null,null);
		model.addAttribute("maps", maps);
		
		return "liujianjie/Receivinglist";
	}
	@RequestMapping("listofwhere")
	private String listofwhere(Model model,
			@RequestParam(value = "cpage")Integer cpage,
			@RequestParam(value = "unit")Integer unit,
			@RequestParam(value = "sku")String sku,
			@RequestParam(value = "whid")String whid){
		if(unit==999){//没有选的时候
			unit=null;
		}if(sku.equals("999")){
			sku=null;
		}if(whid.equals("999")){
			whid=null;
		}
		Map<String, Object> maps = receivingservice.selReceiving(cpage,whid,unit,sku);
		model.addAttribute("maps", maps);
		
		return "liujianjie/Receivinglist";
	}
	@RequestMapping("list2")
	private String list2(Model model,
			HttpServletRequest request,
			@RequestParam(value = "cpage")Integer cpage){
		System.out.println("list2"+cpage);
		HttpSession session  = request.getSession();
		Users user = (Users) session.getAttribute("user");
		Map<String, Object> maps = receivingservice.selReceiving2(cpage,user.getWarehouseid(),null,null);
		model.addAttribute("maps", maps);
		
		return "liujianjie/Receivinglist2";
	}
	@RequestMapping("list2ofwhere")
	private String list2ofwhere(Model model,
			HttpServletRequest request,
			@RequestParam(value = "cpage")Integer cpage,
			@RequestParam(value = "unit")Integer unit,
			@RequestParam(value = "sku")String sku){
		if(unit==999){//没有选的时候
			unit=null;
		}if(sku.equals("999")){
			sku=null;
		}
		HttpSession session  = request.getSession();
		Users user = (Users) session.getAttribute("user");
		Map<String, Object> maps = receivingservice.selReceiving2(cpage,user.getWarehouseid(),unit,sku);
		model.addAttribute("maps", maps);
		
		return "liujianjie/Receivinglist2";
	}
	@RequestMapping("toadd")
	private String toadd(Model model,
			HttpServletRequest request,
			@RequestParam(value = "id")String ids){
		InStorage ins = instorageservice.selInStorage(ids);
		model.addAttribute("ins", ins);
		//仓库 货物类型
		List<Goodtype> goodslist = goodservice.seltype();
		List<Warehouse2> warelist = wardao.selWarehouseAll();
		model.addAttribute("goodslist", goodslist);
		model.addAttribute("warelist", warelist);
		HttpSession session  = request.getSession();
		Users user = (Users) session.getAttribute("user");
		model.addAttribute("whid", user.getWarehouseid());
		return "liujianjie/Receivingadd";
	}
	
	@RequestMapping("add")
	private String add(Model model,Receiving rece,
			@RequestParam(value = "dates")String dates,@RequestParam(value = "time")String time){
		String da = dates+" "+time;
		SimpleDateFormat simper = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = simper.parse(da);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		rece.setReceivedate(date);
		if(rece.getPartflag()==1){
			rece.setShortqty(0);
		}
		receivingservice.addReceiving(rece);
		
		//添加成功修改 入库计划单的状态
		return "redirect:/receiving/list2.do?cpage=1";
	}
	
	//获取货架
	@ResponseBody
	@RequestMapping("racklist")
	private Map<String, Object> racklist(@RequestParam(value = "whid", required = false)String whid,
			@RequestParam(value = "unit", required = false)String unit,
			@RequestParam(value = "sku", required = false)String sku){
		System.out.println("进来了racklist");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("whid", whid);
		System.out.println(whid);
		map.put("unit", unit);
		map.put("sku", sku);
		map.put("statu", 0);//是
		List<Rack2> racklist = rackservice.selRackforputway(map);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("racklist", racklist);
		return map2;
	}
	//添加摆货数据 修改收货单数据为已摆货 修改rack货架剩余大小
	@ResponseBody
	@RequestMapping("addputaway")
	private Map<String, Object> addputaway(Putaway put,
			@RequestParam(value = "size", required = false)Integer size){
//		System.out.println(put.getReid()+" "+put.getInid()+" "+put.getSheid());
		//添加putaway 在addputaway方法中也要个
		int i = putawayservice.addPutaway(put);
		//修改剩余大小
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("size", size);
		map.put("rid", put.getSheid());
		int b = rackservice.updaterackrsurplus(map);
		Map<String, Object> map2 = new HashMap<String, Object>();
		if(i>0&&b>0){//成功
			System.out.println(i+" "+b);
			map2.put("bln", 1);
		}else{
			map2.put("bln", 2);
		}
		return map2;
	}
}

