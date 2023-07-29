package com.ht.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.util.StringUtil;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ht.pojo.BackGroundUser;
import com.ht.pojo.People;
import com.ht.pojo.Rengzheng;
import com.ht.pojo.Ttzuser;
import com.ht.pojo.Ziliao;
import com.ht.service.BackgroundUserService;
import com.ht.service.DetailRepaymentService;
import com.ht.service.PeopleService;
import com.ht.service.TenderRecordService;
import com.ht.service.TtzuserService;
import com.ht.service.ZiliaoService;
import com.ht.util.SystemContant;

@Controller
@RequestMapping("user")
public class TtzUserController {
	@Resource
	private TtzuserService ttzService;

	@Resource
	private PeopleService peopleService;

	@Resource
	private ZiliaoService ziService;

	@Resource
	private BackgroundUserService backService;

	@Resource
	private TenderRecordService tenderService;

	@Resource
	private DetailRepaymentService detailService;

	@RequestMapping("zhuce")
	public String Zhuce(Ttzuser ttzuser, HttpServletRequest request) {
		String ss = generateString(8);
		ttzuser.setUserid(ss);
		ttzService.Zhuce(ttzuser);
		request.getSession().setAttribute("user", ttzuser);
		ziService.insert(new Ziliao("", ss, "", "", "", "", ""));
		return "../foregroundSystem/register1.jsp";
	}

	@RequestMapping("login")
	@ResponseBody
	public Map<String, Object> Login(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "pwd", required = false) String pwd, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		Ttzuser ttz = ttzService.Login(username, pwd);
		if (ttz != null) {
			map.put("boolean", true);
			// 保存当前登陆信息
			session.setAttribute("user", ttz);
			SystemContant.tuser = ttz;
			// 保存当前登陆的是前台系统
			session.setAttribute("system", "前台系统");
			SystemContant.System = SystemContant.ForegroundSystem;
		} else {
			map.put("boolean", false);
		}
		return map;
	}

	/**
	 * 生成随机数
	 * 
	 * @param length
	 * @return
	 */
	public static String generateString(int length) {
		String NUMBERCHAR = "0123456789";
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(NUMBERCHAR.charAt(random.nextInt(NUMBERCHAR.length())));
		}
		return sb.toString();
	}

	// 查询已绑定身份信息的会员
	@RequestMapping("selectAllTtzUser")
	public String selectAllTtzUser(Model model) {
		List<Ttzuser> list = ttzService.UserList();

		model.addAttribute("ttzAlllist", list);
		return "../backgroundSystem/f_users_mange/f_user_table.jsp";
	}

	@RequestMapping("seluserbyname")
	public String seluserbyname(Model model, @RequestParam(value = "yonghuming", required = false) String yonghuming) {

		List<Ttzuser> list = ttzService.seluserbyname(yonghuming);

		model.addAttribute("ttzAlllist", list);
		model.addAttribute("yonghuming", yonghuming);
		return "../backgroundSystem/f_users_mange/f_user_table.jsp";
	}

	@RequestMapping("updatetel")
	@ResponseBody
	public Map<String, Object> updatetel(@RequestParam(value = "tel", required = false) String tel,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		Ttzuser ttz = (Ttzuser) request.getSession().getAttribute("user");

		int i = ttzService.updateTel(tel, ttz.getTid());

		if (i > 0) {
			map.put("boolean", true);
			request.getSession().removeAttribute("user");
			ttz.setTel(tel);
			request.getSession().setAttribute("user", ttz);
		} else {
			map.put("boolean", false);
		}
		return map;
	}

	@RequestMapping("updatezsname")
	@ResponseBody
	public Map<String, Object> updatezsname(@RequestParam(value = "zsname", required = false) String zsname,
			@RequestParam(value = "pcard", required = false) String pcard, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		Ttzuser ttz = (Ttzuser) request.getSession().getAttribute("user");
		People people = peopleService.selPeople(zsname, pcard);
		if (people != null) {
			ttzService.updateZsname(zsname, pcard, ttz.getTid());
			map.put("boolean", true);
			request.getSession().removeAttribute("user");
			ttz.setZsname(zsname);
			ttz.setIdcard(pcard);
			request.getSession().setAttribute("user", ttz);
		} else {
			map.put("boolean", false);
		}
		return map;
	}

	@RequestMapping("updatezpwd")
	public String updatezpwd(@RequestParam(value = "zpwd", required = false) String zpwd, HttpServletRequest request) {
		Ttzuser ttz = (Ttzuser) request.getSession().getAttribute("user");
		ttzService.updateZpwd(zpwd, ttz.getTid());
		request.getSession().removeAttribute("user");
		ttz.setZpwd(zpwd);

		request.getSession().setAttribute("user", ttz);

		return "redirect:../foregroundSystem/personal_zhanghushezhi.jsp";
	}

	@RequestMapping("updateemail")
	public String updateemail(@RequestParam(value = "email", required = false) String email,
			HttpServletRequest request) {
		Ttzuser ttz = (Ttzuser) request.getSession().getAttribute("user");
		ttzService.updateemail(email, ttz.getTid());
		request.getSession().removeAttribute("user");
		ttz.setEmail(email);

		request.getSession().setAttribute("user", ttz);

		return "redirect:../foregroundSystem/personal_zhanghushezhi.jsp";
	}

	@RequestMapping("updatepwd")
	public String updatepwd(@RequestParam(value = "newpwd", required = false) String newpwd,
			HttpServletRequest request) {
		Ttzuser ttz = (Ttzuser) request.getSession().getAttribute("user");
		ttzService.updatepwd(newpwd, ttz.getTid());
		request.getSession().removeAttribute("user");
		ttz.setPwd(newpwd);

		request.getSession().setAttribute("user", ttz);

		return "redirect:../foregroundSystem/personal_zhanghushezhi.jsp";
	}

	@RequestMapping("toPesonal_index")
	public String toPesonal_index() {

		return "redirect:../foregroundSystem/pesonal_index.jsp";
	}

	@RequestMapping("newuser")
	public String Newuser(Model model) {
		List<Ttzuser> list = ttzService.selectNewuser();
		List<BackGroundUser> listback = backService.selbackuserlistAll();
		model.addAttribute("user", list);
		model.addAttribute("userback", listback);
		return "../backgroundSystem/f_users_mange/new_user_table.jsp";
	}

	@RequestMapping("updatenewuser")
	public String updatenewuser(@RequestParam(value = "userid", required = false) String userid,
			@RequestParam(value = "shren", required = false) String shren) {
		ttzService.updatenewuser(shren, userid);
		return "newuser.action";

	}

	@RequestMapping("uploadhead")
	public String uploadhead(HttpServletRequest request,
			@RequestParam(value = "files", required = false) MultipartFile file, Model model) {
		String path = request.getSession().getServletContext().getRealPath("upload");// 获得上传的路径
		String fileName = file.getOriginalFilename();// 获得上传的文件名
		File tfile = new File(path, fileName);// 创建目标文件（服务器）

		try {
			Ttzuser ttz = (Ttzuser) request.getSession().getAttribute("user");
			file.transferTo(tfile);// 文件转储
			ttzService.uploadhead(fileName, ttz.getTid());
			ttz.setHead(fileName);
			request.getSession().removeAttribute("user");
			request.getSession().setAttribute("user", ttz);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "../SelHuiKuan.action";
	}

	@RequestMapping("remove")
	public String remove(HttpServletRequest request) {
		request.getSession().removeAttribute("user");

		return "redirect:../foregroundSystem/login.jsp";
	}

	// 验证用户名是否存在
	@ResponseBody
	@RequestMapping("YanZhengUsername")
	public Map<String, Object> YanZhengUsername(HttpServletRequest request) {
		String username = request.getParameter("param");
		Map<String, Object> map = new HashMap<String, Object>();
		int i = ttzService.YanZhengUsername(username);
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
