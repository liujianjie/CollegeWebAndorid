package com.ht.yfbc.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.yfbc.pojo.Cars_attendance;
import com.ht.yfbc.pojo.Cars_attendanceVo;
import com.ht.yfbc.pojo.Cars_change;
import com.ht.yfbc.pojo.Cars_changeVo;
import com.ht.yfbc.pojo.Cars_distribution;
import com.ht.yfbc.pojo.Cars_distributionVo;
import com.ht.yfbc.pojo.Cars_info;
import com.ht.yfbc.pojo.Cars_repairs;
import com.ht.yfbc.pojo.Cars_repairsVo;
import com.ht.yfbc.pojo.OutStorage;
import com.ht.yfbc.pojo.Position;
import com.ht.yfbc.pojo.Users;
import com.ht.yfbc.pojo.Warehouse2;
import com.ht.yfbc.service.Cars_attendanceService;
import com.ht.yfbc.service.Cars_changeService;
import com.ht.yfbc.service.Cars_distributionService;
import com.ht.yfbc.service.Cars_infoService;
import com.ht.yfbc.service.Cars_repairsService;
import com.ht.yfbc.service.DeliveryService;
import com.ht.yfbc.service.OutStorageService;
import com.ht.yfbc.service.PositionService;
import com.ht.yfbc.service.UsersService;
import com.ht.yfbc.service.WarehouseService;

/**
 * 
 * @author hjx 车辆管理
 * <p>Controller控制层</p>
 *
 */
 

@Controller
@RequestMapping("hjx")
public class HuangJianXiuController {
	@RequestMapping("hello")
	private String hello() {
		System.out.println("hello");
		return "hello";
	}
	/**
	 * Cars_infoService 车辆信息Service
	 */
	@Resource
	private Cars_infoService cars_infoService;
	/**
	 * WarehouseService 仓库管理Service
	 */
	@Resource
	private WarehouseService warehouseService;
	//@Resource
	//private Cars_diliverymanService cars_diliverymanService;
	/**
	 * Cars_distributionService 车辆分配Service
	 */
	@Resource
	private Cars_distributionService cars_disService;
	/**
	 * UsersService 用户管理Service
	 */
	@Resource
	private UsersService usersService;
	/**
	 * Cars_attendanceService 车辆出勤Service
	 */
	@Resource
	private Cars_attendanceService cars_attService;
	/**
	 * Cars_changeService 车辆变更Service
	 */
	@Resource
	private Cars_changeService cars_changeService;
	/**
	 * DeliveryService 出库单Service
	 */
	@Resource
	private DeliveryService deService;
	
	/**
	 * PositionService 岗位表Service
	 */
	@Resource
	private PositionService positionService;
	/**
	 * OutStorageService 出库计划表Service
	 */
	@Resource
	private OutStorageService outStorageService;
	/**
	 * Cars_repairsService 车辆报修Service
	 */
	@Resource 
	private Cars_repairsService cars_repService;
	/**
	 *  车辆信息查询控制层 
	 * @param pageCount 每页行数
	 * @param currPage 当前页数
	 * @param version
	 * @param model
	 * @return
	 */
	/*
	 * @RequestMapping("selcars") private String selcars(Model model) {
	 * List<Cars_info> cars_infos = cars_infoService.selCars_info(); for
	 * (Cars_info cars_info : cars_infos) { //
	 * System.out.println(cars_info.getCarsname()); }
	 * model.addAttribute("cars_infos", cars_infos); List<Warehouse2> warehouses
	 * = warehouseService.selWarehouseAll(); model.addAttribute("warehouses",
	 * warehouses); return "huangjianxiu/cars_info/selcars"; }
	 */

	@RequestMapping("selcars")
	private String selcars(@RequestParam(value = "pageCount", required = false) Integer pageCount,
			@RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "v", required = false) String version, Model model) {

		int totalRow = cars_infoService.selCount();
		int totalPage = (totalRow + pageCount - 1) / pageCount;
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > totalPage) {
			currPage = totalPage;
		}
		System.out.println(pageCount + "currPage" + currPage);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageCount", pageCount);
		map.put("currPage", currPage);

		List<Cars_info> cars_infos = cars_infoService.selCars_infoPage(map);
		model.addAttribute("cars_infos", cars_infos);
		List<Warehouse2> warehouses = warehouseService.selWarehouseAll();
		model.addAttribute("warehouses", warehouses);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("currPage", currPage);
		return "huangjianxiu/cars_info/selcars";
	}

	/** 车辆信息去添加 */
	@RequestMapping("toaddcars")
	private String toaddcars(Model model) {
		List<Warehouse2> warehouses = warehouseService.selWarehouseAll();
		model.addAttribute("warehouses", warehouses);
		return "huangjianxiu/cars_info/addcars";
	}

	/**
	 *  车辆信息添加 
	 * @param cars 车辆信息对象
	 * @return
	 */
	@RequestMapping("addcars")
	private String addcars(Cars_info cars) {
		cars_infoService.addCars_info(cars);
		System.err.println(cars.getCarsname());
		return "redirect:/hjx/selcars.do?pageCount=9&currPage=1&v=0";
	}
	/**
	 * 根据id查看车辆信息详情
	 * @param model
	 * @param id 车辆信息id
	 * @return
	 */
	@RequestMapping("toupdcars")
	public String toupdcars(Model model,@RequestParam(value = "id", required = false) String id){
		Cars_info cars = (Cars_info) cars_infoService.selCars_infobyid(id);
		model.addAttribute("cars", cars);
		List<Warehouse2> warehouses = warehouseService.selWarehouseAll(); 
		model.addAttribute("warehouses", warehouses);
		return "huangjianxiu/cars_info/updcars";
	}

	/**
	 * 修改车辆信息
	 * @param cars 车辆信息对象
	 * @return
	 */
	@RequestMapping("updcars")
	private String updcars(Cars_info cars) {
		cars_infoService.updCars_info(cars);
		System.err.println(cars.getCarsname());
		return "redirect:/hjx/selcars.do?pageCount=9&currPage=1&v=0";
	}
	/**
	 * 查看车辆信息详情
	 * @param model
	 * @param id 车辆信息id
	 * @return
	 */
	@RequestMapping("to_cars_info")
	public String to_cars_info(Model model,@RequestParam(value = "id", required = false) String id){
		Cars_info cars = (Cars_info) cars_infoService.selCars_infobyid(id);
		model.addAttribute("cars", cars);
		List<Warehouse2> warehouses = warehouseService.selWarehouseAll(); 
		model.addAttribute("warehouses", warehouses);
		return "huangjianxiu/cars_info/cars_infos";
	}
	/**
	 * 车辆信息删除
	 * 
	 * @param id 车辆信息id
	 * @return
	 */
	@RequestMapping("delcars")
	public String delcars(@RequestParam(value = "id", required = false) String id) {
		cars_infoService.delcars(id);

		return "redirect:/hjx/selcars.do?pageCount=9&currPage=1&v=0";

	}

	/**
	 *  车辆分配查询控制层
	 * @param pageCount 每页行数
	 * @param currPage 当前页数
	 * @param version
	 * @param model
	 * @return
	 */
	
	/*
	 * @RequestMapping("selcars_dis") private String selcars_dis(Model model) {
	 * List<Cars_distribution> cars_dises = cars_disService.selCars_dis();
	 * model.addAttribute("cars_dises", cars_dises); List<Cars_info> cars_infos
	 * = cars_infoService.selCars_info(); model.addAttribute("cars_infos",
	 * cars_infos); List<Users> users = usersService.selUserList();
	 * model.addAttribute("users", users); List<Warehouse2> warehouses =
	 * warehouseService.selWarehouseAll(); model.addAttribute("warehouses",
	 * warehouses); return "huangjianxiu/cars_dis/selcars_dis"; }
	 */

	@RequestMapping("selcars_dis")
	private String selcars_dis(@RequestParam(value = "pageCount", required = false) Integer pageCount,
			@RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "v", required = false) String version, Model model) {

		int totalRow = cars_disService.selCount();
		int totalPage = (totalRow + pageCount - 1) / pageCount;
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > totalPage) {
			currPage = totalPage;
		}
		System.out.println(pageCount + "currPage" + currPage);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageCount", pageCount);
		map.put("currPage", currPage);

		List<Cars_distribution> cars_dises = cars_disService.selCars_disPage(map);
		if (cars_dises != null) {
			int total = cars_dises.size();
			// 新建Cars_distribution的扩展类的list
			List<Cars_distributionVo> cars_disVolist = new ArrayList<Cars_distributionVo>(total);
			for (int i = 0; i < total; i++) {
				Cars_distributionVo cars_disVo = new Cars_distributionVo();
				// 取出cars_distribution
				Cars_distribution cars_dis = cars_dises.get(i);
				cars_disVo.setCars_distribution(cars_dis);
				// 查出车辆名称、司机名称、仓库名称
				String carsname = cars_infoService.selCars_infoNameById(cars_dis.getCarsid());
				String drivername = usersService.selUsernameById(cars_dis.getUserid());
				String whname = warehouseService.selWarehouseNameById(cars_dis.getWarehouseid());
				cars_disVo.setCarsname(carsname);
				cars_disVo.setDrivername(drivername);
				cars_disVo.setWhname(whname);
				// 添加到list
				cars_disVolist.add(cars_disVo);
			}
			model.addAttribute("cars_disVolist", cars_disVolist);
			model.addAttribute("totalRow", totalRow);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("pageCount", pageCount);
			model.addAttribute("currPage", currPage);
			return "huangjianxiu/cars_dis/selcars_dis";
		} else {
			return "500";
		}

	}

	/**
	 * @author hix 车辆分配去添加 控制层
	 */
	@RequestMapping("toaddcars_dis")
	private String toaddcars_dis(Model model) {
		// List<Cars_info> cars_infos=cars_infoService.selCars_info();
		// model.addAttribute("cars_infos", cars_infos);
		List<Users> users = usersService.selUserList();
		model.addAttribute("users", users);
		List<Warehouse2> warehouses = warehouseService.selWarehouseAll();
		model.addAttribute("warehouses", warehouses);
		return "huangjianxiu/cars_dis/addcars_dis";
	}

	/**
	 *  选择仓库可以级联查出仓库所属的车辆 
	 * @param model
	 * @param warehouseid 仓库id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("cars")
	public Map<String, Object> selcars(Model model,
			@RequestParam(value = "warehouseid", required = false) String warehouseid) {
		Map<String, Object> parammap =new HashMap<String, Object>();
		String positionid = positionService.selPositionIdByName("配送员");
		parammap.put("positionid", positionid);
		parammap.put("warehouseid", warehouseid);
		List<Users> userlist = usersService.selUserListByMap(parammap);
		List<Cars_info> carslist = cars_infoService.selCars_infobywhid(warehouseid);
		// System.out.println("warehouseid "+warehouseid+" "+list.size());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userlist", userlist);
		map.put("carslist", carslist);
		return map;
	}

	
	
	/**
	 *  车辆分配添加 控制层
	 * @param cars_dis 车辆分配表对象
	 * @param carsids 车辆信息id
	 * @return
	 */
	 
	@RequestMapping("addcars_dis")
	private String addcars_dis(Cars_distribution cars_dis,
			@RequestParam(value = "carsids", required = false) String carsids) {
		cars_dis.setCarsid(carsids);
		cars_disService.addCars_dis(cars_dis);
		System.err.println(cars_dis.getUserid());
		return "redirect:/hjx/selcars_dis.do?pageCount=9&currPage=1&v=0";
	}

	/**
	 * 车辆分配删除
	 * 
	 * @param id 车辆分配表id
	 * @return
	 */
	@RequestMapping("delcars_dis")
	public String delcars_dis(@RequestParam(value = "id", required = false) String id) {
		cars_disService.delcars_dis(id);

		return "redirect:/hjx/selcars_dis.do?pageCount=9&currPage=1&v=0";

	}
	
	/**
	 * 根据id查看车辆信息详情
	 * @param model
	 * @param id 车辆信息id
	 * @return
	 */
	@RequestMapping("toupdcars_dis")
	public String toupdcars_dis(Model model,@RequestParam(value = "id", required = false) String id){
		Cars_distribution cars_dis =  cars_disService.selCars_disbyid(id);
		String carsname = cars_infoService.selCars_infoNameById(cars_dis.getCarsid());
		String whname = warehouseService.selWarehouseNameById(cars_dis.getWarehouseid());
		Map<String, Object> map=new HashMap<String,Object>();
		//仓库id
		map.put("warehouseid", cars_dis.getWarehouseid());
		//岗位id
		//根据岗位名称查出岗位id
		String positionid=positionService.selPositionIdByName("配送员");
		map.put("positionid", positionid);
		//在根据map查询usrlist
		List<Users> userlist=usersService.selUserListByMap(map);
		model.addAttribute("userlist", userlist);
		model.addAttribute("carsname", carsname);
		model.addAttribute("whname", whname);
		model.addAttribute("cars_dis", cars_dis); 
		return "huangjianxiu/cars_dis/updcars_dis";
	}

	/**
	 * 修改车辆信息
	 * @param cars 车辆信息对象
	 * @return
	 */
	@RequestMapping("updcars_dis")
	private String updcars_dis(Cars_distribution cars_dis) {
		cars_disService.updCars_dis(cars_dis);
	//	System.err.println(cars_dis.getUserid());
	//	System.err.println(cars_dis.getDistributiondate().toLocaleString());
		return "redirect:/hjx/selcars_dis.do?pageCount=9&currPage=1&v=0";
	}
	
	

	/**
	 *  控制层 /t 车辆出勤查询
	 * @param pageCount 每页行数
	 * @param currPage 当前页数
	 * @param version
	 * @param model
	 * @return
	 */
	 

	/*
	 * @RequestMapping("selcars_att") private String selcars_att(Model model) {
	 * List<Cars_attendance> cars_atts = cars_attService.selCars_att();
	 * model.addAttribute("cars_atts", cars_atts); List<Cars_info> cars_infos =
	 * cars_infoService.selCars_info(); model.addAttribute("cars_infos",
	 * cars_infos); List<Users> users = usersService.selUserList();
	 * model.addAttribute("users", users); List<Warehouse2> warehouses =
	 * warehouseService.selWarehouseAll(); model.addAttribute("warehouses",
	 * warehouses); return "huangjianxiu/cars_att/selcars_att"; }
	 */
	@RequestMapping("selcars_att")
	private String selcars_att(@RequestParam(value = "pageCount", required = false) Integer pageCount,
			@RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "v", required = false) String version, Model model) {

		int totalRow = cars_attService.selCount();
		int totalPage = (totalRow + pageCount - 1) / pageCount;
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > totalPage) {
			currPage = totalPage;
		}
		System.out.println(pageCount + "currPage" + currPage);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageCount", pageCount);
		map.put("currPage", currPage);

		List<Cars_attendance> cars_atts = cars_attService.selCars_attPage(map);
		if (cars_atts != null) {
			int total = cars_atts.size();
			// 新建Cars_distribution的扩展类的list
			List<Cars_attendanceVo> cars_attVolist = new ArrayList<Cars_attendanceVo>(total);
			for (int i = 0; i < total; i++) {
				Cars_attendanceVo cars_attVo = new Cars_attendanceVo();
				// 取出cars_distribution
				Cars_attendance cars_att = cars_atts.get(i);
				cars_attVo.setCars_attendance(cars_att);
				// 查出车辆名称、司机名称、仓库名称
				String carname = cars_infoService.selCars_infoNameById(cars_att.getCarsid());
				String drivername = usersService.selUsernameById(cars_att.getUserid());
				String whname = warehouseService.selWarehouseNameById(cars_att.getWarehouseid());
				cars_attVo.setCarname(carname);
				cars_attVo.setDrivername(drivername);
				cars_attVo.setWhname(whname);
				// 添加到list
				cars_attVolist.add(cars_attVo);
			}
			model.addAttribute("cars_attVolist", cars_attVolist);
			model.addAttribute("totalRow", totalRow);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("pageCount", pageCount);
			model.addAttribute("currPage", currPage);
			return "huangjianxiu/cars_att/selcars_att";
		} else {
			return "500";
		}

	}

	/** 
	 *车辆出勤去添加
	 * @param model
	 * @param deid 出库单id
	 * @return
	 */
	@RequestMapping("toaddcars_att")
	private String toaddcars_att(Model model, @RequestParam(value = "deid", required = false) String deid) {
		List<Warehouse2> warehouses = warehouseService.selWarehouseAll();
		model.addAttribute("warehouses", warehouses);
		model.addAttribute("deid", deid);
		List<OutStorage> outinnos= outStorageService.selOutStorage();
		model.addAttribute("outinnos", outinnos);
		return "huangjianxiu/cars_att/addcars_att";
	}

	/**
	 *  选择车辆可以级联查出车辆所配的司机 
	 * @param model
	 * @param carid 车辆信息id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("user")
	public Map<String, Object> seluser(Model model, @RequestParam(value = "carid", required = false) String carid) {
		Map<String, Object> map = new HashMap<String, Object>();
		Users user = cars_attService.selUsersByCarId(carid);
		map.put("user", user);
		// System.out.println(user.getId()+" "+user.getUsername());
		return map;
	}

	/**
	 *  车辆出勤添加 
	 * @param cars_att 出勤表对象
	 * @param warehouseid 仓库id
	 * @param deid 出库单id
	 * @return
	 */
	@RequestMapping("addcars_att")
	private String addcars_att(Cars_attendance cars_att, @RequestParam(value = "warehouseid") String warehouseid,
			@RequestParam(value = "deid", required = false) String deid) {
		System.out.println(cars_att.getWarehouseid() + "   " + warehouseid);
		try {
			cars_att.setWarehouseid(warehouseid);
			cars_attService.addCars_att(cars_att);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(deid != null && !deid.equals("")){
			deService.updateStaut(deid);
			return "redirect:/Delivery/list.do?currPage=1";
		}else{
			return "redirect:/hjx/selcars_att.do?pageCount=9&currPage=1&v=0";
		}
	}
	
	/**
	 * 车辆出勤去修改
	 * @param model
	 * @param id 出勤表id
	 * @return
	 */
	@RequestMapping("toupdcars_att")
	private String toupdcars_att(Model model, @RequestParam(value = "id", required = false) String id) {
		Cars_attendance cars_att = cars_attService.selCars_attbyid(id);
		String carname = cars_infoService.selCars_infoNameById(cars_att.getCarsid());
		String drivername = usersService.selUsernameById(cars_att.getUserid());
		String whname = warehouseService.selWarehouseNameById(cars_att.getWarehouseid());
		model.addAttribute("carname", carname);
		model.addAttribute("drivername", drivername);
		model.addAttribute("whname", whname);
		model.addAttribute("cars_att", cars_att);
		List<OutStorage> outinnos= outStorageService.selOutStorage();
		model.addAttribute("outinnos", outinnos);
		return "huangjianxiu/cars_att/updcars_att";
	}

	/**
	 * 车辆出勤表修改
	 * @param cars_att 出勤表对象
	 * @return
	 */
	@RequestMapping("updcars_att")
	private String updcars_att(Cars_attendance cars_att) {
		cars_attService.updCars_att(cars_att);
		System.err.println(cars_att.getUserid());
		return "redirect:/hjx/selcars_att.do?pageCount=9&currPage=1&v=0";
	}

	/**
	 * 车辆出勤删除
	 * 
	 * @param id 出勤表id
	 * @return
	 */
	@RequestMapping("delcars_att")
	public String delcars_att(@RequestParam(value = "id", required = false) String id) {
		cars_attService.delcars_att(id);

		return "redirect:/hjx/selcars_att.do?pageCount=9&currPage=1&v=0";

	}

	/**
	 * 车辆变更查询
	 * @param pageCount  每页行数
	 * @param currPage 当前页数
	 * @param version 
	 * @param model
	 * @return
	 */
	 
	/*
	 * @RequestMapping("selcars_change") private String selcars_change(Model
	 * model){ List<Cars_change>
	 * cars_changes=cars_changeService.selCars_change();
	 * model.addAttribute("cars_changes", cars_changes); List<Cars_info>
	 * cars_infos = cars_infoService.selCars_info();
	 * model.addAttribute("cars_infos", cars_infos); List<Users> users =
	 * usersService.selUserList(); model.addAttribute("users", users);
	 * List<Warehouse2> warehouses = warehouseService.selWarehouseAll();
	 * model.addAttribute("warehouses", warehouses); return
	 * "huangjianxiu/cars_change/selcars_change"; }
	 */

	@RequestMapping("selcars_change")
	private String selcars_change(@RequestParam(value = "pageCount", required = false) Integer pageCount,
			@RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "v", required = false) String version, Model model) {

		int totalRow = cars_changeService.selCount();
		int totalPage = (totalRow + pageCount - 1) / pageCount;
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > totalPage) {
			currPage = totalPage;
		}
		System.out.println(pageCount + "currPage" + currPage);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageCount", pageCount);
		map.put("currPage", currPage);

		List<Cars_change> cars_changes = cars_changeService.selCars_changePage(map);
		if (cars_changes != null) {
			int total = cars_changes.size();
			// 新建Cars_distribution的扩展类的list
			List<Cars_changeVo> cars_changeVolist = new ArrayList<Cars_changeVo>(total);
			for (int i = 0; i < total; i++) {
				Cars_changeVo cars_changeVo = new Cars_changeVo();
				// 取出cars_distribution
				Cars_change cars_change = cars_changes.get(i);
				cars_changeVo.setCars_change(cars_change);
				// 查出车辆名称、司机名称、仓库名称
				String carsname = cars_infoService.selCars_infoNameById(cars_change.getCarsid());
				String drivername = usersService.selUsernameById(cars_change.getUserid());
				String whname = warehouseService.selWarehouseNameById(cars_change.getWarehouseid());
				cars_changeVo.setCarsname(carsname);
				cars_changeVo.setDrivername(drivername);
				cars_changeVo.setWhname(whname);
				// 添加到list
				cars_changeVolist.add(cars_changeVo);
			}
			model.addAttribute("cars_changeVolist", cars_changeVolist);
			model.addAttribute("totalRow", totalRow);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("pageCount", pageCount);
			model.addAttribute("currPage", currPage);
			return "huangjianxiu/cars_change/selcars_change";
		} else {
			return "500";
		}

	}

	/**
	 * 车辆变更记录删除
	 * 
	 * @param id 车辆变更表id
	 * @return
	 */
	@RequestMapping("delcars_change")
	public String delcars_change(@RequestParam(value = "id", required = false) String id) {
		cars_changeService.delCars_change(id);

		return "redirect:/hjx/selcars_change.do?pageCount=9&currPage=1&v=0";

	}

	/**
	 * @author hix 车辆变更去添加 控制层
	 */
	@RequestMapping("toaddcars_change")
	private String toaddcars_change(Model model) {
		// List<Cars_info> cars_infos=cars_infoService.selCars_info();
		// model.addAttribute("cars_infos", cars_infos);
		List<Users> users = usersService.selUserList();
		model.addAttribute("users", users);
		List<Warehouse2> warehouses = warehouseService.selWarehouseAll();
		model.addAttribute("warehouses", warehouses);
		return "huangjianxiu/cars_change/addcars_change";
	}

	/**
	 *   hjx 车辆变更添加 控制层
	 * @param cars_change 车辆变更表对象
	 * @param carsids 车辆信息id
	 * @return
	 */
	 
	@RequestMapping("addcars_change")
	private String addcars_change(Cars_change cars_change,
			@RequestParam(value = "carsids", required = false) String carsids) {
		cars_change.setCarsid(carsids);
		cars_changeService.addCars_change(cars_change);
		return "redirect:/hjx/selcars_change.do?pageCount=9&currPage=1&v=0";
	}
	
	
	@RequestMapping("selposi")
	private String selposi(@RequestParam(value = "pageCount", required = false) Integer pageCount,
			@RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "v", required = false) String version, Model model) {
		int totalRow = positionService.selCount();
		int totalPage = (totalRow + pageCount - 1) / pageCount;
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > totalPage) {
			currPage = totalPage;
		}
		System.out.println(pageCount + "currPage" + currPage);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageCount", pageCount);
		map.put("currPage", currPage);
		
		List<Position> posis=positionService.selCars_posiPage(map);
		model.addAttribute("posis", posis);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("currPage", currPage);
		return "huangjianxiu/position/selposi";
	}

	
	@RequestMapping("toaddposi")
	private String toaddposi(Model model) {
		
		return "huangjianxiu/position/addposi";
	}

	
	@RequestMapping("addposi")
	private String addposi(Position posi) {
		positionService.addposi(posi);
		return "redirect:/hjx/selposi.do?pageCount=9&currPage=1&v=0";
	}
	
	@RequestMapping("delposi")
	public String delposi(@RequestParam(value = "id", required = false) String id) {
		positionService.delposi(id);
		return "redirect:/hjx/selposi.do?pageCount=9&currPage=1&v=0";

	}
	
	/*........................车辆报修......................*/
	
	@RequestMapping("/selcars_rep")
	public String selcars_rep(Model model,
			@RequestParam(value = "pageCount", required = false) Integer pageCount,
			@RequestParam(value = "currPage", required = false) Integer currPage,
		//	@RequestParam(value = "userid") String userid,
			@RequestParam(value = "v", required = false) String version) throws Exception {
		
		int totalRow = cars_repService.selCount();
		int totalPage = (totalRow + pageCount - 1) / pageCount;
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > totalPage) {
			currPage = totalPage;
		}
		System.out.println(pageCount + "currPage" + currPage);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageCount", pageCount);
		map.put("currPage", currPage);
//		map.put("userid", userid); // 用户名
		List<Cars_repairs> cars_reps=cars_repService.selCars_repPage(map);
		if(cars_reps != null){
			int total = cars_reps.size();
			List<Cars_repairsVo> cars_repsVolist = new ArrayList<Cars_repairsVo>(total); 
			for (int i = 0; i < total; i++) {
				Cars_repairsVo cars_repVo = new Cars_repairsVo();
				// 取出cars_distribution
				Cars_repairs cars_rep= cars_reps.get(i);
				cars_repVo.setCars_repairs(cars_rep);
				// 查出车辆名称、司机名称、仓库名称
				String carsname = cars_infoService.selCars_infoNameById(cars_rep.getCarsid());
				String username = usersService.selUsernameById(cars_rep.getUserid());	
				cars_repVo.setCarsname(carsname);
				cars_repVo.setUsername(username);
				// 添加到list
				cars_repsVolist.add(cars_repVo);

		}
		model.addAttribute("cars_repsVolist", cars_repsVolist);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("currPage", currPage);
		return "huangjianxiu/cars_rep/selcars_rep";
	}else {
		return "500";
	}
	}
	
	
	@RequestMapping("toaddcars_rep")
	private String toaddcars_per(Model model) {
		 List<Cars_info> cars_infos=cars_infoService.selCars_info();
		 model.addAttribute("cars_infos", cars_infos);
		List<Users> users = usersService.selUserList();
		model.addAttribute("users", users);
//		List<Warehouse2> warehouses = warehouseService.selWarehouseAll();
//		model.addAttribute("warehouses", warehouses);
		return "huangjianxiu/cars_rep/addcars_rep";
	}

	
	 
	@RequestMapping("addcars_rep")
	private String addcars_rep(Cars_repairs cars_rep,
			@RequestParam(value = "carsids", required = false) String carsids) {
		cars_rep.setCarsid(carsids);
		cars_repService.addCars_rep(cars_rep);
		return "redirect:/hjx/selcars_rep.do?pageCount=9&currPage=1&v=0";
	}
	
}
