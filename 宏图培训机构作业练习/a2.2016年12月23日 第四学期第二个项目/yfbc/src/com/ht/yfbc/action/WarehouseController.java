package com.ht.yfbc.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.yfbc.dao.CityDao;
import com.ht.yfbc.pojo.City;
import com.ht.yfbc.pojo.Goodtype;
import com.ht.yfbc.pojo.Province;
import com.ht.yfbc.pojo.Rack;
import com.ht.yfbc.pojo.Rack2;
import com.ht.yfbc.pojo.Users;
import com.ht.yfbc.pojo.Warehouse;
import com.ht.yfbc.pojo.Warehouse2;
import com.ht.yfbc.pojo.putaway2;
import com.ht.yfbc.service.CityService;
import com.ht.yfbc.service.GoodtypeService;
import com.ht.yfbc.service.ProvinceService;
import com.ht.yfbc.service.PutawayService;
import com.ht.yfbc.service.RackService;
import com.ht.yfbc.service.UsersService;
import com.ht.yfbc.service.WarehouseService;

/**
 * 仓库控制层
 * 
 * day 2016-12-27
 * 
 * @author 魏海明
 *
 */
@Controller
@RequestMapping("Warehouse")
public class WarehouseController {
	@Resource
	private WarehouseService warService;

	@Resource
	private ProvinceService pService;

	@Resource
	private UsersService userService;

	@Resource
	private CityService cService;

	@Resource
	private RackService rService;

	@Resource
	private GoodtypeService gService;

	@Resource
	private PutawayService wService;

	@RequestMapping("list")
	public String WarehouseList(Model model, @RequestParam(value = "currPage", required = false) String currPage) {

		Map<String, Object> map = warService.selWarehouse(Integer.parseInt(currPage));
		model.addAttribute("list", map);
		return "Warehouselist";

	}
	
	@RequestMapping("list2")
	public String WarehouseList2(Model model, HttpServletRequest request) {
		HttpSession session  = request.getSession();
		Users user = (Users) session.getAttribute("user");
		Warehouse2 war = warService.selWarByUserId2(user.getId());
		model.addAttribute("war", war);
		
		return "Warehouselist2";

	}

	@RequestMapping("toadd")
	public String WarehouseAdd(Model model) {
		List<Users> users = userService.selUserList();
		model.addAttribute("users", users);
		List<Province> list = pService.selProvince();
		model.addAttribute("province", list);
		return "addWarehouse";

	}

	@ResponseBody
	@RequestMapping("city")
	public Map<String, Object> selCity(Model model,
			@RequestParam(value = "provinceid", required = false) String provinceid, HttpServletResponse response) {

		List<City> list = cService.selbypid(Integer.parseInt(provinceid));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("citys", list);
		return map;
	}

	@RequestMapping("add")
	public String addWarehouse(Warehouse war, @RequestParam(value = "cityids", required = false) String cityid,
			@RequestParam(value = "whvolumes", required = false) String whvolume,
			@RequestParam(value = "whistates", required = false) String whistate) {
		war.setCityid(Integer.parseInt(cityid));
		war.setWhistate(Integer.parseInt(whistate));
		war.setWhvolume(Integer.parseInt(whvolume));
		warService.addWarehouse(war);

		return "redirect:/Warehouse/list.do?currPage=1";

	}

	@RequestMapping("delwar")
	public String delWar(Model model, @RequestParam(value = "whid", required = false) String whid) {
		warService.delwar(whid);

		return "redirect:/Warehouse/list.do?currPage=1";
	}

	@RequestMapping("toupdwar")
	public String toupdateWar(Model model, @RequestParam(value = "whid", required = false) String whid) {
		Warehouse2 war = warService.selWarById(whid);
		List<Users> users = userService.selUserList();
		model.addAttribute("users", users);
		List<Province> list = pService.selProvince();
		model.addAttribute("province", list);
		model.addAttribute("war", war);
		return "updateWarehouse";
	}

	@RequestMapping("udpwar")
	public String updateWar(Warehouse war, @RequestParam(value = "whvolumes", required = false) String whvolume,
			@RequestParam(value = "whistates", required = false) String whistate) {
		war.setWhvolume(Integer.parseInt(whvolume));
		war.setWhistate(Integer.parseInt(whistate));
		warService.update(war);

		return "redirect:/Warehouse/list.do?currPage=1";

	}

	@RequestMapping("torack")
	public String rack(Model model, @RequestParam(value = "whid", required = false) String whid) {
		List<Rack2> list = rService.selRack(whid);

		model.addAttribute("list", list);
		model.addAttribute("whid", whid);
		return "rack";

	}

	@RequestMapping("toaddrack")
	public String toaddrack(Model model, @RequestParam(value = "whid", required = false) String whid) {
		List<Goodtype> list = gService.seltype();
		model.addAttribute("list", list);
		model.addAttribute("whid", whid);
		return "addrack";

	}

	@RequestMapping("addrack")
	public String addrack(Model model, Rack rack, @RequestParam(value = "rsize", required = false) String rsize) {
		System.out.println(rack.getUnit());
		rack.setRsize(Integer.parseInt(rsize));
		rack.setRsurplus(Integer.parseInt(rsize));
		rService.insert(rack);
		return "redirect:/Warehouse/torack.do?whid=" + rack.getWhid();

	}

	@RequestMapping("rackgoods")
	public String rackGoods(Model model, @RequestParam(value = "pid", required = false) String pid) {
		List<putaway2> list = wService.selPutawayByid(pid);
		System.out.println(list.size() + "rackgoods" + "\t" + pid);
		model.addAttribute("list", list);
		return "rackgoods";
	}

	@RequestMapping("rackgoodall")
	public String rackGoodAll(Model model, @RequestParam(value = "whid", required = false) String whid,
			@RequestParam(value = "currPage", required = false) String currPage) {
		System.out.println("currPage" +currPage);
		Map<String, Object> map = wService.selPutawayBywhid(whid, Integer.parseInt(currPage));
		model.addAttribute("map", map);
		model.addAttribute("whidid", whid);
		return "rackgoodsall";
	}

	@RequestMapping("text")
	public String text() {
		List<Goodtype> list = gService.seltype();
		for (Goodtype goodtype : list) {
			System.out.println(goodtype.getTname());
		}
		return null;
	}
}
