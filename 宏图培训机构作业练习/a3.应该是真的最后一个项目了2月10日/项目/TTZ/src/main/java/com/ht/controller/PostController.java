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

import com.ht.pojo.BackGroundUser;
import com.ht.pojo.Permission;
import com.ht.pojo.Post;
import com.ht.service.BackgroundUserService;
import com.ht.service.PermissionService;
import com.ht.service.PostService;
import com.ht.util.SystemContant;

/**
 * 后台岗位
 */

@Controller
@RequestMapping("post")
public class PostController {

	@Resource
	PostService postservice;
	
	@RequestMapping("postlist")
	public String postlist(Model model){
		List<Post> plist = postservice.selpostlist();
		model.addAttribute("plist", plist);
		return "../backgroundSystem/postlist.jsp";
	}
	
	
	@RequestMapping("addpost")
	public String addpost(Post post,@RequestParam(value = "checks",required = false)String[] per){
		//权限分为字符串
		String pers = "";
		if(per!=null){
			for(String s:per){
				pers+=s+",";
			}
			post.setP_list(pers);
		}else{
			post.setP_list("");
		}
		postservice.addpost(post);
		return "redirect:../post/postlist.action";
	}
	
	@RequestMapping("delpost")
	public String delpost(Model model,@RequestParam(value = "id")String id){
		postservice.delpost(id);
		return "redirect:../post/postlist.action";
	}
	//去修改
	@RequestMapping("toalert")
	public String toalert(Model model,@RequestParam(value = "id")String id){
		Post post =  postservice.getpost(id);
		//获取的 权限 给换成list
		String qxstring = post.getP_list();
		if(qxstring!=null){
			String qx[] = qxstring.split(",");
			//要指定泛型，不然会。。比如 29, 2 和 9也会去算
			List<Integer> perlist = new ArrayList<Integer>();
			for(int i=0;i<qx.length;i++){
				perlist.add(Integer.parseInt(qx[i]));
			}
			model.addAttribute("perlist", perlist);
		}
		
		model.addAttribute("post", post);
		return "../backgroundSystem/postalert.jsp";
	}
	//修改
	@RequestMapping("alertpost")
	public String alertpost(Post post,@RequestParam(value = "checks",required = false)String[] per){
		//权限分为字符串
		String pers = "";
		if(per!=null){
			for(String s:per){
				pers+=s+",";
			}
			post.setP_list(pers);
		}else{
			post.setP_list("");
		}
		postservice.updpost(post);
		return "redirect:../post/postlist.action";
	}
}
