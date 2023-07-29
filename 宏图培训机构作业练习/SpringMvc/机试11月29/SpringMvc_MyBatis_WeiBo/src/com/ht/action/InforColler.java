package com.ht.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.ModelAndView;

import com.ht.service.UsersI;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.ht.bean.Blog;
import com.ht.bean.Users;
import com.ht.service.BlogI;

@Controller
@RequestMapping("/")
public class InforColler {
	//使用注解完成依赖对象的实例
	@Resource 
	private UsersI us;
	
	@Resource
	private BlogI bl;

	
	@RequestMapping("login")
	@ResponseBody
	public String login(@RequestParam(value = "uname")String uname,@RequestParam(value = "pwd")String pwd,HttpSession session){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("uname", uname);
		map.put("pwd", pwd);
		Users uss =  us.getUsersandlog(map);
		if(uss!=null){
			session.setAttribute("user", uss);
			return "1";
		}else{
			return "0";
		}
	}
	
	@RequestMapping("bloglist")
	public String bloglist(HttpSession session,Map<String, Object> map,
			@RequestParam(value = "cpage")int cpage){
		int currpage = 1;//页
		int pagecount = 2;//数
		int totalcount = bl.selbloglistcount();//总很
		int totalpage = ((totalcount+pagecount)-1)/pagecount;//总页
		
		if(cpage!=0){
			currpage = cpage;
		}
		if(cpage==0){
			currpage=1;
		}
		if(cpage>totalpage){
			currpage = totalpage;
		}
		map.put("currpage", currpage);
		map.put("pagecount", pagecount);
		List<Blog> list = bl.selbloglist(map);
		
		session.setAttribute("bloglist", list);
		session.setAttribute("blcurrpage", currpage);
		session.setAttribute("blpagecount", pagecount);
		session.setAttribute("bltotalcount", totalcount);
		session.setAttribute("bltotalpage", totalpage);
		return "blogmain";
	}
	
	@RequestMapping("userblog")
	public String userblog(Model model,HttpSession session,Map<String, Object> map,
			@RequestParam(value = "cpage")int cpage){
		Users user = (Users)session.getAttribute("user");
		int currpage = 1;//页
		int pagecount = 2;//数
		int totalcount = bl.seluserblogcount(user.getU_id());//总很
		int totalpage = ((totalcount+pagecount)-1)/pagecount;//总页
		
		if(cpage!=0){
			currpage = cpage;
		}
		if(cpage==0){
			currpage=1;
		}
		if(cpage>totalpage){
			currpage = totalpage;
		}
		map.put("currpage", currpage);
		map.put("pagecount", pagecount);
		map.put("id", user.getU_id());
		
		List<Blog> list = bl.seluserblog(map);
		
		model.addAttribute("bloglist",list);
		model.addAttribute("currpage",currpage);
		model.addAttribute("pagecount",pagecount);
		model.addAttribute("totalcount",totalcount);
		model.addAttribute("totalpage",totalpage);
		
		return "userblog";
	}
	@RequestMapping("addblog")
	public String addblog(HttpSession session,
			@RequestParam(value = "tex")String tex){
		Users user = (Users)session.getAttribute("user");
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", user.getU_id());
		map.put("text", tex);
		bl.addblog(map);
		return "redirect:/userblog.do?cpage=1";
	}
	@RequestMapping("delblog")
	public String delblog(@RequestParam(value = "id")Integer id){
		bl.delblog(id);
		return "redirect:/userblog.do?cpage=1";
	}
	//用户
	@RequestMapping("useralert")
	public String useralert(@RequestParam(value = "uname")String uname,@RequestParam(value = "pwd")String pwd,
			HttpSession session){
		Users user = (Users)session.getAttribute("user");
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", user.getU_id());
		map.put("uname", uname);
		map.put("pwd", pwd);
		us.alertuser(map);
		//保存全局
		user.setU_nickname(uname);
		user.setU_password(pwd);
		session.setAttribute("user", user);
		return "success";
	}
	//用户列表
	@RequestMapping("userlists")
	public String userlists(Model model,Map<String, Object> map,
			@RequestParam(value = "cpage")int cpage){
		int currpage = 1;//页
		int pagecount = 2;//数
		int totalcount = us.seluserlistcount();//总很
		int totalpage = ((totalcount+pagecount)-1)/pagecount;//总页
		
		if(cpage!=0){
			currpage = cpage;
		}
		if(cpage==0){
			currpage=1;
		}
		if(cpage>totalpage){
			currpage = totalpage;
		}
		map.put("currpage", currpage);
		map.put("pagecount", pagecount);
		
		List<Users> list = us.userlist(map);
		
		model.addAttribute("userlist", list	);
		model.addAttribute("currpage",currpage);
		model.addAttribute("pagecount",pagecount);
		model.addAttribute("totalcount",totalcount);
		model.addAttribute("totalpage",totalpage);
		
		return "userlist";
	}
	//删除用户
	@RequestMapping("userdel")
	public String userdel(@RequestParam(value = "id")Integer id){
		us.userdel(id);
		return "redirect:/userlists.do?cpage=1";
	}
	//添加用户
	@RequestMapping("useradd")
	public String useradd(HttpServletRequest request,Users users,
			@RequestParam(value = "files")MultipartFile file){
		String path = request.getSession().getServletContext().getRealPath("image");
		String filename = file.getOriginalFilename();
		File files = new File(path,filename);
		try {
			file.transferTo(files);
		} catch (IllegalStateException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		//文件名称保存路径
		users.setU_picpath(request.getContextPath()+"/image/"+filename);
		us.useradd(users);
		
		return "redirect:/userlists.do?cpage=1";
	}
}