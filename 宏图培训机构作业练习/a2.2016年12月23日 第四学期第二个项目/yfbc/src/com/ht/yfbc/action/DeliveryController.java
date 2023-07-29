package com.ht.yfbc.action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ht.yfbc.pojo.Delivery;
import com.ht.yfbc.pojo.OutStorage;
import com.ht.yfbc.pojo.Users;
import com.ht.yfbc.service.DeliveryService;
import com.ht.yfbc.service.OutStorageService;

/**
 * 出库单业务控制层 day 2017-1-05
 * 
 * @author 魏海明
 *
 */
@Controller
@RequestMapping("Delivery")
public class DeliveryController {
	@Resource
	private OutStorageService outService;
	
	@Resource
	private DeliveryService deService;

	@RequestMapping("add")
	public String addDelivery(Model model, @RequestParam(value = "danjia", required = false) String danjia,
			@RequestParam(value = "price", required = false) String price,
			@RequestParam(value = "outid", required = false) String outid) {
		
		OutStorage put = outService.selOutByid(outid);
		outService.updateState(outid);
		Float d = Float.parseFloat(danjia);
		Float p = d*put.getPurchaseqty();
		System.out.println(p);
		Delivery de = new Delivery("", put.getProductname(), put.getSku(),
				put.getPurchaseqty(), put.getUnit(), put.getSupplier(),
				put.getSupplierno(), put.getReceivename(), put.getReceiveno(),
				put.getWhid(),put.getInno(),"",d,p);
		deService.insert(de);
		
		return "redirect:/outstorage/list.do?currPage=1";
	}
	
	@RequestMapping("list")
	public String List(Model model,@RequestParam(value = "currPage",required = false)String currPage){
		Map<String, Object> map = deService.seldeBypage(Integer.parseInt(currPage));
		model.addAttribute("map", map);
		return "deliverylist";
		
	}
	
	@RequestMapping("list2")
	public String List2(Model model,@RequestParam(value = "currPage",required = false)String currPage,HttpServletRequest request){
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		
		
		Map<String, Object> map = deService.seldeBypage2(Integer.parseInt(currPage),user.getWarehouseid());
		model.addAttribute("map", map);
		return "deliverylist2";
		
	}
}
