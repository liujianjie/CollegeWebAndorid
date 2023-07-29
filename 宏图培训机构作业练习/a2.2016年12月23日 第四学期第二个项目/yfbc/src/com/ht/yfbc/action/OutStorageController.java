package com.ht.yfbc.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ht.yfbc.pojo.OutStorage;
import com.ht.yfbc.pojo.Users;
import com.ht.yfbc.pojo.putaway2;
import com.ht.yfbc.service.OutStorageService;
import com.ht.yfbc.service.PutawayService;

/**
 * 出货计划单控制层 day 2016-12-27
 * 
 * @author 刘建杰
 *
 */

@Controller
@RequestMapping("outstorage")
public class OutStorageController {

	@Resource
	private OutStorageService outstorageservice;

	@Resource
	private PutawayService pService;

	
	
	@RequestMapping("addout")
	private String Addout(Model model, @RequestParam(value = "ptid", required = false) String pid,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "yueku", required = false) String yueku) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(pid + "\t" + date);
		Date d;
		try {
			d = format.parse(date);
			putaway2 put = pService.selPutawayByPid(pid);
			OutStorage out = new OutStorage("", put.getIns().getProductname(), put.getIns().getSku(),
					put.getIns().getPurchaseqty(), put.getIns().getUnit() + "", put.getIns().getSupplier(),
					put.getIns().getSupplierno(), put.getIns().getReceivename(), put.getIns().getReceiveno(), d,
					put.getWar().getWhid(),yueku,put.getIns().getInno(),"");
			outstorageservice.addOutStorage(out);
			pService.updatePtbln(pid);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "putawaylist";
	}
	
	
	@RequestMapping("addouts")
	private String Addouts(Model model, @RequestParam(value = "ptid", required = false) String[] pid,
			@RequestParam(value = "dates", required = false) String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(pid + "\t" + date);
		Date d;
		for (String string : pid) {
			try {
				d = format.parse(date);
				putaway2 put = pService.selPutawayByPid(string);
				OutStorage out = new OutStorage("", put.getIns().getProductname(), put.getIns().getSku(),
						put.getIns().getPurchaseqty(), put.getIns().getUnit() + "", put.getIns().getSupplier(),
						put.getIns().getSupplierno(), put.getIns().getReceivename(), put.getIns().getReceiveno(), d,
						put.getWar().getWhid(),"1",put.getIns().getInno(),"");
				outstorageservice.addOutStorage(out);
				pService.updatePtbln(string);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		return "putawaylist";
	}
	
	
	
	@RequestMapping("list")
	public String OutList(Model model, @RequestParam(value = "currPage", required = false) String currPage){
		Map<String, Object> map = outstorageservice.selOutStoragePage(Integer.parseInt(currPage));
		model.addAttribute("map", map);
		
		return "putawaylist";
		
		
	}
	
	@RequestMapping("list2")
	public String OutList2(Model model, @RequestParam(value = "currPage", required = false) String currPage,HttpServletRequest request){
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		
		Map<String, Object> map = outstorageservice.selOutStoragePage2(Integer.parseInt(currPage),user.getWarehouseid());
		
		model.addAttribute("map", map);
		
		return "putawaylist2";
		
		
	}
	
	
	@RequestMapping("todelivery")
	public String toDelivery(Model model, @RequestParam(value = "outid", required = false) String outid){
		OutStorage out = outstorageservice.selOutByid(outid);
		model.addAttribute("out", out);
		return "adddelivery";
		
		
	}
}
