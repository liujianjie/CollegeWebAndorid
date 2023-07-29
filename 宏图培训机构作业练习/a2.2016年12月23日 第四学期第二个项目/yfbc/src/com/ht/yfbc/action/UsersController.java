package com.ht.yfbc.action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ht.yfbc.pojo.City;
import com.ht.yfbc.pojo.Position;
import com.ht.yfbc.pojo.Province;
import com.ht.yfbc.pojo.Users;
import com.ht.yfbc.pojo.UsersVo;
import com.ht.yfbc.pojo.Warehouse2;
import com.ht.yfbc.service.CityService;
import com.ht.yfbc.service.PermissionsService;
import com.ht.yfbc.service.PositionService;
import com.ht.yfbc.service.ProvinceService;
import com.ht.yfbc.service.UsersService;
import com.ht.yfbc.service.WarehouseService;
import com.ht.yfbc.util.MyTools;

@Controller
@RequestMapping("user")
public class UsersController {
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
	 * 权限相关的service
	 */
	@Resource
	private PermissionsService permService;
	/**
	 * 全国各省的service
	 */
	@Resource
	private ProvinceService pService;
	/**
	 * 省内城市相关的service
	 */
	@Resource
	private CityService cService;
	/**
	 * 仓库相关的service
	 */
	@Resource
	private WarehouseService warehouseService;
	
	/**
	 * 根据省id查询城市<br>
	 * js中接收json字串
	 * @param provinceid 省的id
	 * @param model
	 * @returnHashMap
	 */
	@ResponseBody
	@RequestMapping("city")
	public Map<String, Object> selCity(@RequestParam(value = "provinceid", required = false) String provinceid,Model model) {

		List<City> list = cService.selbypid(Integer.parseInt(provinceid));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("citys", list);
		return map;
	}
	/**
	 * 用户修改头像
	 * @param file
	 * @return
	 */
	@RequestMapping("updateFace")
	public String updateuserface(HttpServletRequest request,
			@RequestParam(value = "userid", required = false) String userid,
			@RequestParam(value = "file", required = false) MultipartFile file){
		String path = request.getSession().getServletContext().getRealPath("userFace");// 获得上传的路径
		String fileName = file.getOriginalFilename();// 获得上传的文件名
		String newFileName=MyTools.getNewFileName(fileName);
		File tfile = new File(path, newFileName);// 创建目标文件（服务器）
		try {
			file.transferTo(tfile);// 文件转储
		} catch (Exception e) {
			e.printStackTrace();
		}
		String imgUrl = "userFace/" + newFileName;
		Users users=usersService.selUsersById(userid);
		users.setPicpath(imgUrl);
		usersService.updUsers(users);
		request.getSession().setAttribute("user", users);
		return "redirect:/index.jsp";
	}
	
	/**
	 * 去添加用户，查询所需的数据
	 */
	@RequestMapping("toadd")
	private String toadd(Model model){
		List<Position> poses=posService.selPositionList();
		List<Province> Provincelist = pService.selProvince();
		List<Warehouse2> warehouseList=warehouseService.selWarehouseAll();
		model.addAttribute("province", Provincelist);
		model.addAttribute("position", poses);
		model.addAttribute("warehouseList", warehouseList);
		return "user/adduser";
	}
	@RequestMapping("add")
	private String adduser(HttpServletRequest request,
			@RequestParam(value="province") String province,
			@RequestParam(value="city") String city,
			@RequestParam(value = "file", required = false) MultipartFile file,
			Users user,Model model){
		String path = request.getSession().getServletContext().getRealPath("userFace");// 获得上传的路径
		String fileName = file.getOriginalFilename();// 获得上传的文件名
		String newFileName=MyTools.getNewFileName(fileName);
		File tfile = new File(path, newFileName);// 创建目标文件（服务器）
		try {
			file.transferTo(tfile);// 文件转储
		} catch (Exception e) {
			e.printStackTrace();
		}
		String imgUrl = "userFace/" + newFileName;
		
		user.setPicpath(imgUrl);
		
		province=pService.selProvinceNameById(Integer.parseInt(province));
		System.out.println(city);
		city=cService.selcityNameById(Integer.parseInt(city));
		String address=province+""+city;
		user.setAddress(address);
		System.out.println(user.toString());
		usersService.addUsers(user);
		return "redirect:toadd.do";
	}
	
	/**
	 * 去用户详细页面，查询所需的数据
	 */
	@RequestMapping("toinfo")
	private String toinfo(Model model,@RequestParam(value = "id", required = false) String id){
		Users user= usersService.selUsersById(id);
		model.addAttribute("user", user);
		
		
		List<Position> poses=posService.selPositionList();
		model.addAttribute("position", poses);
		return "user/userinfo";
	}
	
	
	@RequestMapping("del")
	public String deluser(String userid){
		usersService.delUsers(userid);
		return "redirect:userlist.do?pageCount=9&currPage=1";
	}
	/**
	 *  因为重定向，所以需要HttpServletRequest获取到session，将用户保存到session中
	 * @param password 密码
	 * @param username 用户名
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("login")
	private String login(@RequestParam(value="password") String password,@RequestParam(value="username") String username,HttpServletRequest request,Model model){
		Map<String, Object> map=new HashMap<String ,Object>();
		map.put("username", username);
		map.put("password", password);
		Users user=usersService.selUserByNameAndPwd(map);
		
		if(user!=null){
			String pname=posService.selPositionNameById(user.getPositionid());
			request.getSession().setAttribute("pname", pname);
			request.getSession().setAttribute("user", user);
			return "redirect:/index.jsp";
		}else{
			return "redirect:/500.jsp";
		}
	}
	/**
	 * 退出登录
	 * @param request
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("user");
		return "redirect:/login.jsp";
	}
	/**
	 * 查询用户列表，分页查询
	 * @param pageCount 每页数据条数
	 * @param currPage 当前页
	 * @param version
	 * @param model
	 * @return
	 */
	@RequestMapping("userlist")
	private String userlist(@RequestParam(value = "pageCount", required = false) Integer pageCount,
			@RequestParam(value="currPage",required=false) Integer currPage,
			@RequestParam(value="v",required=false) String version,Model model){
		
		int totalRow=usersService.selCount();
		int totalPage=(totalRow+pageCount-1)/pageCount;
		if(currPage<1){
			currPage=1;
		}
		if(currPage>totalPage){
			currPage=totalPage;
		}
		System.out.println(pageCount+"currPage"+currPage);
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("pageCount", pageCount);
		map.put("currPage", currPage);
		List<Users> userlist=usersService.selUserListPage(map);
		if(userlist!=null){
			int total=userlist.size();
			//新建users的扩展类的list
			List<UsersVo> usersVoList=new ArrayList<UsersVo>(total);
			
			for (int i=0;i<total;i++) {
				UsersVo uservo=new UsersVo();
				//取出users
				Users user=userlist.get(i);
				uservo.setUsers(userlist.get(i));
				//查出岗位名称、权限列表
				String pname=posService.selPositionNameById(user.getPositionid());
				String lmtlist=permService.selPermissionsByUserId(user.getId());
				uservo.setPname(pname);
				uservo.setLmtlist(lmtlist);
				//添加到list
				usersVoList.add(uservo);
			}
			model.addAttribute("uservolist",usersVoList );
			model.addAttribute("totalRow",totalRow );
			model.addAttribute("totalPage",totalPage );
			model.addAttribute("pageCount", pageCount);
			model.addAttribute("currPage", currPage);
			return "user/userlist";
		}else{
			return "500";
		}
	}
	//index展示页面
	@ResponseBody
	@RequestMapping("userxq")
	public Map<String,Object> userxq(@RequestParam(value = "userid")String userid){
		Users user= usersService.selUsersById(userid);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user", user);
		return map;
	}
}
