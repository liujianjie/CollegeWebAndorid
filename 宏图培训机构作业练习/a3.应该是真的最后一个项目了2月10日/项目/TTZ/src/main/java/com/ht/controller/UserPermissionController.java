package com.ht.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.ht.pojo.BackGroundUser;
import com.ht.service.BackgroundUserService;
import com.ht.service.PermissionService;
import com.ht.util.SystemContant;


/**
 * 后台用户权限 控制层
 */

@Controller
@RequestMapping("userper")
public class UserPermissionController {
	
	@Resource
	BackgroundUserService backuser;
	@Resource
	PermissionService perservice;
	
	@RequestMapping("userlist")
	public String userlist(Model model,@RequestParam(value = "cpage")Integer cpage){
		Map<String,Object> map = backuser.selbackuserlist(cpage);
		
		model.addAttribute("map", map);
		return "../backgroundSystem/UserAssign.jsp";
	}
	//查询权限
	@RequestMapping("seluserpermissionlist")
	public String seluserpermissionlist(Model model,
			@RequestParam(value = "userid")String userid){
		//查询选择用户拥有的权限
		List list = perservice.selectlistbybid(userid);
		model.addAttribute("userid", userid);
		model.addAttribute("userperlist", list);
		return "../backgroundSystem/UserPermission.jsp";
	}
	
	//保存权限
	@ResponseBody
	@RequestMapping("saveuserpermission")
	public Map<String,Object> saveuserpermission(@RequestParam(value = "checks")String checkss,
			@RequestParam(value = "userid")String userid,HttpSession session){
		//判断是否为''
		Map<String,Object> map1 = new HashMap<String, Object>();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("b_id",userid);
		if(!checkss.equals("")){//不为空的的时候
			String checks[] = checkss.split(","); 
			
			List<Integer> yylist = perservice.selectlistbybid(userid);
			//先查出用户所拥有的 权限 然后对比给去除
			List<Integer> yxlist = new ArrayList<Integer>();//定义为已选的list
			List<Integer> needdellist = new ArrayList<Integer>();//定义为需要删除得权限
			for(int j=0;j<checks.length;j++){
				yxlist.add(Integer.parseInt(checks[j]));
			}
			
			for(int i=0;i<yylist.size();i++){
				boolean bln=false;
				Integer zhi = yylist.get(i);//已有的值
				for(int j=0;j<yxlist.size();j++){
					if(zhi==yxlist.get(j)){
						bln = true;
						yxlist.remove(j);
					}
				}
				if(bln==false){
					needdellist.add(zhi);//添加需要删除得权限
				}
			}
			
			//先删除
			try{
				for(int i=0;i<needdellist.size();i++){
					map.put("p_list", needdellist.get(i));
					perservice.deluserpermission(map);
				}
				
				//再添加
				for(int i=0;i<yxlist.size();i++){
					map.put("p_list", yxlist.get(i));
					perservice.adduserpermission(map);
				}
				map1.put("result", 1);
				//成功修改后，看看这个修改的用户是不是登录用户
				BackGroundUser back = (BackGroundUser) session.getAttribute("backuser");
				if(back.getB_id().equals(userid)){
					//重新获取权限列表
					List<Integer> list = perservice.selectlistbybid(userid);
					session.setAttribute("qxlist", list);
				}
				
			}catch(Exception e){
				map1.put("result", 0);
				e.printStackTrace();
			}
		}else{//为空，直接全部删除
			try{
				perservice.deluserpermission(map);
				map1.put("result", 1);
			}catch(Exception e){
				map1.put("result", 0);
				e.printStackTrace();
			}
		}
		
		return map1;
	}

}
