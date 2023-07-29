package com.ht.yfbc.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.yfbc.dao.Cars_infoDao;
import com.ht.yfbc.dao.RackDao;
import com.ht.yfbc.dao.WarehouseDao;
import com.ht.yfbc.pojo.Cars_info;
import com.ht.yfbc.pojo.Goodtype;
import com.ht.yfbc.pojo.MoveStorage;
import com.ht.yfbc.pojo.Putaway;
import com.ht.yfbc.pojo.Rack2;
import com.ht.yfbc.pojo.Warehouse;
import com.ht.yfbc.pojo.Warehouse2;
import com.ht.yfbc.pojo.putaway2;
import com.ht.yfbc.pojo.putaway3;
import com.ht.yfbc.service.GoodtypeService;
import com.ht.yfbc.service.MoveStorageService;
import com.ht.yfbc.service.PutawayService;
import com.ht.yfbc.service.RackService;
import com.ht.yfbc.service.WarehouseService;

@Controller
@RequestMapping("movestorage")
public class MoveStorageController {
	
	@Resource
	private WarehouseDao warDao;
	
	@Resource
	private RackService rackService;
	
	@Resource
	private PutawayService putawayService;
	
	@Resource
	private Cars_infoDao carsinfodao;
	
	@Resource 
	private MoveStorageService moveservice;
	
	@Resource
	private RuntimeService runtimeService;
	
	@Resource
	private TaskService taskService;
	
	@Resource
	private RackService rackservice;
	
	@Resource
	private PutawayService putawayservice;
	
	@Resource
	private GoodtypeService goodservice;

	//查询登录用户拥有的货物 查询货架
	@RequestMapping("goodslist")
	private String goodslist(Model model,@RequestParam(value = "userid")String uid){
		//首先查询用户所管理的仓库
		Warehouse warehouse = warDao.selWarByUserId(uid);
		model.addAttribute("whiname", warehouse.getWhiname());
		//货架列表
		Map<String,Object> maps = rackService.selRackofMoveStorage(warehouse.getWhid(),warehouse.getWhid());
		model.addAttribute("maps", maps);
		  
		return "liujianjie/MoveStorageRacklist";
	}
	
	//获取各个货架的货物
	@ResponseBody
	@RequestMapping("getgoodslist")
	private Map<String, Object> getgoodslist(@RequestParam(value = "rid", required = false)String rid){
		System.out.println("进来了getgoodslist");
		List<putaway3> list = putawayService.selPutawayByid3(rid);
		//仓库 货物类型
		List<Goodtype> goodslist = goodservice.seltype();
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("list", list);
		map2.put("goodslist", goodslist);
		return map2;
	}
	//添加movestorage数据
	@ResponseBody
	@RequestMapping("add")
	private Map<String, Object> add(MoveStorage movestorage){
		System.out.println("进来了add");
		//未提交
		movestorage.setMostate(0);
		movestorage.setProcessInstanceId("");
		int i = moveservice.addMoveStorage(movestorage);
		Map<String, Object> map2 = new HashMap<String, Object>();
		if(i>0){
			map2.put("bln", 1);
			//车辆修改为 途中
			Cars_info car = carsinfodao.selCars_infobyid(movestorage.getCarsid());
			car.setCarsisvacancy(1);
			carsinfodao.updCars_info(car);
		}else{
			map2.put("bln", 0);
		}
		return map2;
	}
	
	//movestorage列表
	@RequestMapping("list")
	private String list(@RequestParam(value = "userid")String userid,
			Model model,@RequestParam(value = "cpage")Integer cpage){
		System.out.println(userid);
		//首先查询用户所管理的仓库
		Warehouse warehouse = warDao.selWarByUserId(userid);
		//移库数据列表
		Map<String,Object> maps = moveservice.selMoveStorage(userid,warehouse.getWhid(),cpage);
		model.addAttribute("maps", maps);
		
		return "liujianjie/MoveStoragelist";
	}
	//movestorage列表 超级管理员
	@RequestMapping("list2")
	private String list2(Model model,
			@RequestParam(value = "cpage")Integer cpage){
		//移库数据列表
		Map<String,Object> maps = moveservice.selAllMoveStorage(cpage,null,null);
		model.addAttribute("maps", maps);
		return "liujianjie/MoveStoragelist2";
	}
	//movestorage列表 超级管理员
	@RequestMapping("list2ofwhere")
	private String list2ofwhere(Model model,
			@RequestParam(value = "cpage")Integer cpage,
			@RequestParam(value = "mowhiname")String mowhid,
			@RequestParam(value = "towhiname")String towhid){
		//移库数据列表
		Warehouse2 w2=null;
		Warehouse2 w1=null;
		String towhiname=null;
		String mowhiname=null;
		if(!mowhid.equals("999")){
			w1=warDao.selWarById(mowhid);
			mowhiname=w1.getWhiname();
		}
		if(!towhid.equals("999")){
			w2=warDao.selWarById(towhid);
			towhiname=w2.getWhiname();
		}
		Map<String,Object> maps = moveservice.selAllMoveStorage(cpage,mowhiname,towhiname);
		model.addAttribute("maps", maps);
		return "liujianjie/MoveStoragelist2";
	}
	//修改movestorage数据就是添加流程实例 
	//这里说找不到name是因为我的 bmpn没有写好 要写一个 执行人 变量为 #{user} 判断${user==1? : }
	@RequestMapping("update")
	private String update(@RequestParam(value = "id")String moid){
		System.out.println("进来了add"+moid);
//		Map<String, Object> variables = new HashMap<String, Object>();
//		variables.put("moid", moid);
//		ProcessInstance pi = runtimeService.startProcessInstanceByKey(
//				"myProcess", variables); // 启动流程
//		Task task = taskService.createTaskQuery()
//				.processInstanceId(pi.getProcessInstanceId()).singleResult(); // 根据流程实例Id查询任务
//		taskService.complete(task.getId()); // 完成 开始从源仓库出发
		
		//通过moid获取到数据 然后修改状态 和流程id
		MoveStorage move = moveservice.getOneMoveStorage(moid);
		move.setMostate(1);
		move.setProcessInstanceId("0");
		moveservice.updateMoveStorage(move);
		
		return "redirect:/movestorage/list.do?cpage=1&userid="+move.getMouser();
	}
	//代办任务
	@RequestMapping("listto")
	private String listto(@RequestParam(value = "userid")String userid,
			Model model){
		System.out.println(userid+" userid userid");
		//首先查询用户所管理的仓库
		Warehouse warehouse = warDao.selWarByUserId(userid);
		model.addAttribute("warehouse", warehouse);
		//移库数据列表 根据touser是我
		Map<String,Object> maps = moveservice.selMoveStorageByTouser(userid);
		model.addAttribute("maps", maps);
		
		return "liujianjie/MoveStorageTolist";
	} 
	//收货流程完成 摆货数据 修改状态。。 moid proid
	@ResponseBody
	@RequestMapping("updateto")
	private Map<String, Object> updateto(@RequestParam(value = "moid")String moid,
			@RequestParam(value = "proid")String proid,
			Putaway put,@RequestParam(value = "size", required = false)Integer size){
		System.out.println("111");
		
//		//查询任务 根据proid
//		Task task = taskService.createTaskQuery()
//				.processInstanceId(proid).singleResult(); // 根据流程实例Id查询任务
//		taskService.complete(task.getId()); //完成 目标仓库完成
		
		//通过moid获取到数据 然后修改状态 为同意
		MoveStorage move = moveservice.getOneMoveStorage(moid);
		move.setMostate(2);
		moveservice.updateMoveStorage(move);
		
		int i = putawayservice.addPutaway(put);
		//修改剩余大小
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("size", size);
		map.put("rid", put.getSheid());
		int b = rackservice.updaterackrsurplus(map);
		Map<String, Object> map2 = new HashMap<String, Object>();
		if(i>0&&b>0){//成功
			map2.put("bln", 1);
			//车辆修改为闲置
			Cars_info car = carsinfodao.selCars_infobyid(move.getCarsid());
			car.setCarsisvacancy(0);
			carsinfodao.updCars_info(car);
		}else{
			map2.put("bln", 2);
		}
		
		return map2;
	}
	//代办任务数量
	@ResponseBody
	@RequestMapping("getmovestoragecount")
	private Map<String, Object> updateto(@RequestParam(value = "userid")String userid){
		int i = moveservice.getMoveStorageCount(userid);
		System.out.println(i);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("movestoragecount", i);
		return map2;
	}
}
