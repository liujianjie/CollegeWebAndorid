package com.ht.yfbc.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ht.yfbc.pojo.Position;
import com.ht.yfbc.pojo.Rewards_penalties;
import com.ht.yfbc.pojo.Rewards_penaltiesVo;
import com.ht.yfbc.pojo.SalaryVo;
import com.ht.yfbc.pojo.Users;
import com.ht.yfbc.pojo.UsersVo;
import com.ht.yfbc.pojo.Warehouse;
import com.ht.yfbc.pojo.Warehouse2;
import com.ht.yfbc.service.PositionService;
import com.ht.yfbc.service.Rewards_penaltiesService;
import com.ht.yfbc.service.UsersService;
import com.ht.yfbc.service.WarehouseService;
@Controller
@RequestMapping("rewards_penalties")
public class Rewards_penaltiesController {
	/**
	 * 仓库相关的service
	 */
	@Resource
	private WarehouseService warehouseService;
	/**
	 * 用户相关的service
	 */
	@Resource
	private UsersService usersService;
	/**
	 * 岗位相关的service
	 */
	@Resource
	private PositionService posService;
	
	/**
	 * 奖惩表相关的service
	 */
	@Resource
	private Rewards_penaltiesService rpService;
	
	@RequestMapping("selrewards_penaltieslist")
	public String selRewards_penaltiesList(@RequestParam(value = "pageCount", required = false) Integer pageCount,
			@RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "warehouseid", required = false) String warehouseid,
			@RequestParam(value = "positionid", required = false) String positionid,
			@RequestParam(value = "year", required = false) String year,
			@RequestParam(value = "month", required = false) String month,
			@RequestParam(value = "v", required = false) String version,
			HttpServletRequest request,Model model){
		Map<String, Object> paramMap=new HashMap<String,Object>();
		String time="";
		if(year==null || year.equals("") || month==null || month.equals("")){
			//当前时间（年，月）
			year=getYear();
			month=getMonth();
		}
		if (Integer.parseInt(month) < 10) {
			month = "0" + month;
		}
		time=year+"-"+month;
		paramMap.put("recordtime", time);
		System.out.println("time"+time);
		//需要根据仓库id，职位id查询出用户id
		if(positionid!=null){
			paramMap.put("positionid", positionid);
		}
		if(warehouseid!=null){
			paramMap.put("warehouseid", warehouseid);
		}
		//每页数据条数
		paramMap.put("pageCount", pageCount);
		int totalRow=rpService.selCount(paramMap);
		int totalPage=(totalRow+pageCount-1)/pageCount;
		if(currPage<1){
			currPage=1;
		}
		if(currPage>totalPage){
			currPage=totalPage;
		}
		//当前页数
		paramMap.put("currPage", currPage);
		
		List<Rewards_penalties> rplist=rpService.selRewards_penaltiesListPage(paramMap);
		
		if(rplist.size()>0){
			List<Rewards_penaltiesVo> rpvolist=new ArrayList<Rewards_penaltiesVo>();
			
			for (Rewards_penalties rewards_penalties : rplist) {
				Rewards_penaltiesVo rpvo=new Rewards_penaltiesVo();
				rpvo.setRp(rewards_penalties);
				String username=usersService.selUsernameById(rewards_penalties.getUserid());
				rpvo.setUsername(username);
				rpvolist.add(rpvo);
			}
			model.addAttribute("rpvolist", rpvolist);
		}

		//岗位列表
		List<Position> posList=posService.selPositionList();
		//仓库列表
		List<Warehouse2> warehouseList=warehouseService.selWarehouseAll();
		
		HttpSession session=request.getSession();
		session.setAttribute("positionid", positionid);
		session.setAttribute("warehouseid", warehouseid);
		session.setAttribute("pageCount", pageCount);
		session.setAttribute("currPage", currPage);
		session.setAttribute("totalRow", totalRow);
		session.setAttribute("totalPage", totalPage);
		
		
		session.setAttribute("year",year);
		session.setAttribute("month",month);
		session.setAttribute("warehouseList", warehouseList);
		session.setAttribute("posList",posList);
		
		return "rewards_penaltieslist";
	}
	@ResponseBody
	@RequestMapping("getjson")
	public Map<String, Object> getRewards_penaltiesListjson(Integer pageCount,Integer currPage,String year,String month,String warehouseid,String positionid,HttpServletRequest request){
		Map<String, Object> map=new HashMap<String ,Object>();
		Map<String , Object> dataMap=getRewards_penaltiesListMap(pageCount, currPage, year, month, warehouseid, positionid);
		List<Rewards_penaltiesVo> rpvolist =(List<Rewards_penaltiesVo>) dataMap.get("rpvolist");
		int totalRow=(int) dataMap.get("totalRow");
		int totalPage=(int) dataMap.get("totalPage");
		map.put("rpvolist", rpvolist);
		request.getSession().setAttribute("pageCount", pageCount);
		request.getSession().setAttribute("currPage", currPage);
		request.getSession().setAttribute("year", year);
		request.getSession().setAttribute("month", month);
		request.getSession().setAttribute("warehouseid", warehouseid);
		request.getSession().setAttribute("positionid", positionid);
		request.getSession().setAttribute("totalRow", totalRow);
		request.getSession().setAttribute("totalPage", totalPage);
		return map;
	}
	public Map<String, Object> getRewards_penaltiesListMap(Integer pageCount,Integer currPage,String year,String month,String warehouseid,String positionid){
		Map<String , Object> dataMap=new HashMap<String,Object>();
		Map<String, Object> paramMap=new HashMap<String,Object>();
		String time="";
		if(year==null || year.equals("") || month==null || month.equals("")){
			//当前时间（年，月）
			year=getYear();
			month=getMonth();
		}
		if (Integer.parseInt(month) < 10) {
			month = "0" + month;
		}
		time=year+"-"+month;
		paramMap.put("recordtime", time);
		System.out.println("time"+time);
		//需要根据仓库id，职位id查询出用户id
		if(positionid!=null){
			paramMap.put("positionid", positionid);
		}
		if(warehouseid!=null){
			paramMap.put("warehouseid", warehouseid);
		}
		//每页数据条数
		paramMap.put("pageCount", pageCount);
		int totalRow=rpService.selCount(paramMap);
		int totalPage=(totalRow+pageCount-1)/pageCount;
		if(currPage<1){
			currPage=1;
		}
		if(currPage>totalPage){
			currPage=totalPage;
		}
		//当前页数
		paramMap.put("currPage", currPage);
		
		List<Rewards_penalties> rplist=rpService.selRewards_penaltiesListPage(paramMap);
		List<Rewards_penaltiesVo> rpvolist=new ArrayList<Rewards_penaltiesVo>();
		if(rplist.size()>0){
			
			
			for (Rewards_penalties rewards_penalties : rplist) {
				Rewards_penaltiesVo rpvo=new Rewards_penaltiesVo();
				rpvo.setRp(rewards_penalties);
				String username=usersService.selUsernameById(rewards_penalties.getUserid());
				rpvo.setUsername(username);
				rpvolist.add(rpvo);
			}
		}
		dataMap.put("rpvolist", rpvolist);
		dataMap.put("totalRow", totalRow);
		dataMap.put("totalPage", totalPage);
		return dataMap;
	}
	/**
	 * 根据岗位id，所属仓库，查询用户
	 * @param positionid 岗位id
	 * @param warehouseid 仓库id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("seluser")
	public Map<String, Object> seluser(@RequestParam(value="positionid") String positionid,@RequestParam(value="warehouseid") String warehouseid){
		Map<String, Object> map=new HashMap<String, Object>();
		//根据岗位id，仓库id查询用户
		Map<String, Object> parammap=new HashMap<String, Object>();
		System.out.println(positionid+"    "+warehouseid);
		parammap.put("positionid", positionid);
		parammap.put("warehouseid", warehouseid);
		List<Users> userList=usersService.selUserListByMap(parammap);
		List<UsersVo> usersvolist=new ArrayList<UsersVo>();
		if(userList.size()>0){
			
			for(int i=0;i<userList.size();i++){
				UsersVo uservo=new UsersVo();
				Users users=userList.get(i);
				System.out.println(users.getId());
				String pname=posService.selPositionNameById(users.getPositionid());
				uservo.setUsers(users);
				uservo.setPname(pname);
				usersvolist.add(uservo);
			}
			
		}
		map.put("uservolist", usersvolist);
		return map;
	}
	/**
	 * 查询出查询目标（用户）所需要的条件，岗位列表，所属仓库
	 * @param model
	 * @return
	 */
	@RequestMapping("tosel")
	public String toselRewards_penalties(Model model){
		//岗位列表
		List<Position> posList=posService.selPositionList();
		//仓库列表
		List<Warehouse2> warehouseList=warehouseService.selWarehouseAll();
		//当前时间（年，月）
		String year=getYear();
		String month=getMonth();
		model.addAttribute("year",year);
		model.addAttribute("month",month);
		model.addAttribute("warehouseList", warehouseList);
		model.addAttribute("posList", posList);
		return "seluser_rewards_penalties";
	}
	/**
	 * 查询添加奖惩记录需要的数据
	 * @param userid
	 * @param model
	 * @return
	 */
	@RequestMapping("toadd")
	public String toaddRewards_penalties(@RequestParam(value="userid") String userid,Model model){
		UsersVo uservo=new UsersVo();
		Users user=usersService.selUsersById(userid);
		uservo.setUsers(user);
		String pname=posService.selPositionNameById(user.getPositionid());
		uservo.setPname(pname);
		model.addAttribute("uservo", uservo);
		return "addrewards_penalties";
	}
	/**
	 * 奖惩记录添加
	 * @param rewards_penalties
	 * @return
	 */
	@RequestMapping("add")
	public String addRewards_penalties(Rewards_penalties rewards_penalties){
		System.out.println(rewards_penalties.getUserid());
		if(rewards_penalties.getBonus()==null||rewards_penalties.getBonus().equals("")){
			rewards_penalties.setBonus(0.00);
		}
		if(rewards_penalties.getBonus_cause()==null||rewards_penalties.getBonus_cause().equals("")){
			rewards_penalties.setBonus_cause("无");
		}
		if(rewards_penalties.getFine()==null||rewards_penalties.getFine().equals("")){
			rewards_penalties.setFine(0.00);
		}
		if(rewards_penalties.getFine_cause()==null||rewards_penalties.getFine_cause().equals("")){
			rewards_penalties.setFine_cause("无");
		}
		
		rpService.addRewards_penalties(rewards_penalties);
		return "redirect:tosel.do";
	}
	public String getYear() {
		Date date = new Date();
		@SuppressWarnings("deprecation")
		String dd = date.toLocaleString();
		String year = dd.substring(0, dd.indexOf("-"));
		return year;
	}

	public String getMonth() {
		Date date = new Date();
		@SuppressWarnings("deprecation")
		String dd = date.toLocaleString();
		String month = dd.substring(dd.indexOf("-") + 1, dd.lastIndexOf("-"));
		return month;
	}
}
