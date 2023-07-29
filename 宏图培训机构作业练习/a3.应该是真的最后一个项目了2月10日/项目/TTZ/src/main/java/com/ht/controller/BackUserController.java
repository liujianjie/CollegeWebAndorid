package com.ht.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ht.dao.PostDao;
import com.ht.pojo.BackGroundUser;
import com.ht.pojo.Post;
import com.ht.service.BackgroundUserService;
import com.ht.service.PermissionService;
import com.ht.service.PostService;

/**
 * 后台用户操作 控制层
 * 
 */

@Controller
@RequestMapping("backuser")
public class BackUserController {

	@Resource
	BackgroundUserService backuserservice;

	@Resource
	PostService pservice;// 后台岗位

	@Resource
	PermissionService permissionservice;// 后台权限

	// 分页查询
	@RequestMapping("userlist")
	public String userlist(Model model, @RequestParam(value = "cpage") Integer cpage) {
		Map<String, Object> map = backuserservice.selbackuserlist(cpage);

		model.addAttribute("map", map);
		return "../backgroundSystem/Userlist.jsp";
	}

	// 去修改 查找值
	@RequestMapping("toalert")
	public String toalert(Model model, @RequestParam(value = "id", required = false) String id, HttpSession session)
			throws Exception {
		BackGroundUser user = backuserservice.selBackGroudUser(id);
		List<Post> post = pservice.selpostlist();

		model.addAttribute("user", user);
		model.addAttribute("post", post);
		return "../backgroundSystem/Useralert.jsp";
	}

	// 修改
	@RequestMapping("alert")
	public String alert(Model model, BackGroundUser bkuser, HttpSession session) {
		backuserservice.updBackGroundUser(bkuser);

		// 如果是登录者 保存值
		BackGroundUser back = (BackGroundUser) session.getAttribute("backuser");
		if (back.getB_id().equals(bkuser.getB_id())) {
			// 重新获取
			BackGroundUser user = backuserservice.selBackGroudUser(bkuser.getB_id());
			session.setAttribute("backuser", user);
		}
		return "redirect:/backuser/toalert.action?id=" + bkuser.getB_id();
	}

	// 修改头像
	@RequestMapping("updateFace")
	public String updateFace(Model model, HttpSession session, HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = "files") MultipartFile file, @RequestParam(value = "id") String id) {
		// 获取当前服务器的文件夹路径
		String path = request.getSession().getServletContext().getRealPath("backgroundSystem/image");

		// 获取文件名称
		String filename = file.getOriginalFilename();
		// 保存文件
		File files = new File(path, filename);
		try {
			file.transferTo(files);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 修改数据库 头像文件存储路径
		BackGroundUser backuser = new BackGroundUser();
		backuser.setB_touxiang("backgroundSystem/image/" + filename);
		backuser.setB_id(id);
		backuserservice.updBackGroundUser(backuser);

		// 如果是登录者 保存值
		BackGroundUser back = (BackGroundUser) session.getAttribute("backuser");
		if (back.getB_id().equals(backuser.getB_id())) {
			// 重新获取
			BackGroundUser user = backuserservice.selBackGroudUser(backuser.getB_id());
			session.setAttribute("backuser", user);
		}
		return "redirect:../backuser/toalert.action?id=" + id;
	}

	// 在index中修改头像
	@RequestMapping("indexupdateFace")
	public String indexupdateFace(Model model, HttpSession session, HttpServletRequest request,
			@RequestParam(value = "files") MultipartFile file, @RequestParam(value = "id") String id) {
		// 获取当前服务器的文件夹路径
		String path = request.getSession().getServletContext().getRealPath("backgroundSystem/image");

		// 获取文件名称
		String filename = file.getOriginalFilename();

		// 保存文件
		File files = new File(path, filename);
		try {
			file.transferTo(files);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 修改数据库 头像文件存储路径
		BackGroundUser backuser = new BackGroundUser();
		backuser.setB_touxiang("backgroundSystem/image/" + filename);
		backuser.setB_id(id);
		backuserservice.updBackGroundUser(backuser);

		// 重新获取
		BackGroundUser user = backuserservice.selBackGroudUser(id);
		session.setAttribute("backuser", user);

		return "redirect:../backgroundSystem/index.jsp";
	}

	@ResponseBody
	@RequestMapping("test")
	public Map<String, Object> test(Model model, HttpSession session, HttpServletRequest request,
			@RequestParam(value = "files") MultipartFile file) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 获取当前服务器的文件夹路径
		String path = request.getSession().getServletContext().getRealPath("backgroundSystem/image");
		// 获取文件名称
		String filename = file.getOriginalFilename();

		// 保存文件
		File files = new File(path, filename);
		try {
			file.transferTo(files);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("result", 1);
		return map;
	}

	// 添加
	@RequestMapping("toadd")
	public String toadd(Model model) {
		List<Post> post = pservice.selpostlist();

		model.addAttribute("post", post);
		return "../backgroundSystem/Useradd.jsp";
	}

	// 添加
	@RequestMapping("add")
	public String add(Model model, HttpServletRequest request, @RequestParam(value = "files") MultipartFile file,
			BackGroundUser backusers) {
		// 获取当前服务器的文件夹路径
		String path = request.getSession().getServletContext().getRealPath("backgroundSystem/image");

		// 获取文件名称
		String filename = file.getOriginalFilename();

		// 保存文件
		File files = new File(path, filename);
		try {
			file.transferTo(files);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 添加数据
		backusers.setB_touxiang("backgroundSystem/image/" + filename);
		backuserservice.addBackGroundUser(backusers);

		// 选择岗位的权限也添加进去 先查询 出p_list 在逐个添加默认权限 要判断是否为空
		Post post = pservice.getpost(backusers.getB_positionid());
		if (post != null) {
			String qxstring = post.getP_list();
			if (qxstring != null) {
				String[] qx = qxstring.split(",");
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < qx.length; i++) {// 逐个添加进Permission里去
					map.put("b_id", backusers.getB_id());
					map.put("p_list", Integer.parseInt(qx[i]));
					permissionservice.adduserpermission(map);
				}
			}
		}

		return "redirect:/backuser/userlist.action?cpage=1";
	}

	// 删除
	@RequestMapping("del")
	public String del(Model model, HttpServletRequest request, @RequestParam(value = "userid") String id) {
		backuserservice.delBackGroundUser(id);
		// 同时删除权限 是permission
		permissionservice.delpermissionforuserid(id);
		return "redirect:/backuser/userlist.action?cpage=1";
	}

	// 验证用户名是否存在
	@ResponseBody
	@RequestMapping("YanZhengBackUsername")
	public Map<String, Object> YanZhengBackUsername(HttpServletRequest request) {
		String b_username = request.getParameter("param");
		Map<String, Object> map = new HashMap<String, Object>();
		int i = backuserservice.YanZhengBackUsername(b_username);
		if (i > 0) {
			map.put("info", "系统中已经存在该名称");
			map.put("status", "n");
		} else {
			map.put("info", "该名称可用");
			map.put("status", "y");
		}
		return map;
	}

}
