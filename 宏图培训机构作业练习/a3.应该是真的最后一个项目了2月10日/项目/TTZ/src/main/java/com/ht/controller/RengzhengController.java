package com.ht.controller;

import java.io.File;
import java.io.IOException;
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

import com.ht.dao.ZilaioDao;
import com.ht.pojo.Rengzheng;
import com.ht.pojo.Rengzheng2;
import com.ht.pojo.Ttzuser;
import com.ht.pojo.Ziliao;
import com.ht.pojo.Ziliao2;
import com.ht.service.RengzhengService;
import com.ht.service.TtzuserService;
import com.ht.service.ZiliaoService;

@Controller
@RequestMapping("rengzheng")
public class RengzhengController {
	@Resource
	private RengzhengService renService;

	@Resource
	private TtzuserService ttzService;

	@Resource
	private ZiliaoService ziService;

	@RequestMapping("add")
	public String upload(HttpServletRequest request,
			@RequestParam(value = "files", required = false) MultipartFile file,
			@RequestParam(value = "type") String type, Model model) {
		String path = request.getSession().getServletContext().getRealPath("upload");// 获得上传的路径
		String fileName = file.getOriginalFilename();// 获得上传的文件名
		File tfile = new File(path, fileName);// 创建目标文件（服务器）
		Ttzuser ttz = (Ttzuser) request.getSession().getAttribute("user");
		try {
			file.transferTo(tfile);// 文件转储
			Ttzuser user = (Ttzuser) request.getSession().getAttribute("user");
			renService.deleteone(user.getTid(), type);
			Rengzheng reng = new Rengzheng("", user.getTid(), type, fileName, null,"",0);
			renService.insert(reng);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		String userid = ttz.getUserid();
		if(type.equals("身份证")){
			ziService.updateSFZ(userid, "2");
		}else if(type.equals("居住证")){
			ziService.updateJZZ(userid, "2");
			
		}else if(type.equals("工作证")){
			ziService.updateGZZ(userid, "2");
			
		}else if(type.equals("收入证明")){
			ziService.updateSRZ(userid, "2");
			
		}else if(type.equals("信用证明")){
			ziService.updateXYZ(userid, "2");
		}
		return "sel.action";
	}

	@RequestMapping("sel")
	public String selreng(HttpServletRequest request, Model model) {
		Ttzuser user = (Ttzuser) request.getSession().getAttribute("user");
		List<Rengzheng> list = renService.sel(user.getTid());
		model.addAttribute("list", list);

		return "../foregroundSystem/ziliaoshangchuan.jsp";

	}

	@RequestMapping("selzilaio")
	public String selzilaio(HttpServletRequest request, Model model) {
		
		List<Ziliao2> list = ziService.selectAll();
		model.addAttribute("list", list);

		return "../backgroundSystem/f_users_mange/ziliao_user_table.jsp";

	}
	
	

	@RequestMapping("selall")
	public String selall(HttpServletRequest request, Model model) {

		List<Rengzheng2> list = renService.selAll();
		model.addAttribute("list", list);

		return "../backgroundSystem/f_users_mange/ren_user_table.jsp";

	}

	@RequestMapping("ziliaorengzheng")
	@ResponseBody
	public Map<String, Object> toziliaorengzheng(HttpServletRequest request,
			@RequestParam(value = "tids", required = false) String tids,
			@RequestParam(value = "rtype", required = false) String rtype) {

		Ttzuser ttz = ttzService.selmyuserid2(tids);
		Rengzheng ren = renService.selone(tids, rtype);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ttzuser", ttz);

		map.put("ren", ren);

		return map;

	}

	@RequestMapping("toziliaorengzheng")
	public String toziliaorengzheng(HttpServletRequest request, Model model,
			@RequestParam(value = "tid", required = false) String tid) {

		model.addAttribute("userid", tid);

		return "../backgroundSystem/ziliaorengzheng.jsp";

	}

	@RequestMapping("shenghe")
	@ResponseBody
	public Map<String, Object> shenghe(HttpServletRequest request, Model model,
			@RequestParam(value = "userid", required = false) String userid,
			@RequestParam(value = "xinyong", required = false) String xinyong,
			@RequestParam(value = "rtype", required = false) String rtype,
			@RequestParam(value = "tid", required = false) String tid){
		renService.updatexyed(Integer.parseInt(xinyong), tid, rtype);
		ttzService.updateSYED(userid, Integer.parseInt(xinyong));
		if(rtype.equals("身份证")){
			ziService.updateSFZ(userid, "3");
		}else if(rtype.equals("居住证")){
			ziService.updateJZZ(userid, "3");
			
		}else if(rtype.equals("工作证")){
			ziService.updateGZZ(userid, "3");
			
		}else if(rtype.equals("收入证明")){
			ziService.updateSRZ(userid, "3");
			
		}else if(rtype.equals("信用证明")){
			ziService.updateXYZ(userid, "3");
		}
		Map<String, Object> map =new HashMap<String, Object>();
		return map;

	}
	
	@RequestMapping("shenghe2")
	@ResponseBody
	public Map<String, Object> shenghe2(HttpServletRequest request, Model model,
			@RequestParam(value = "userid", required = false) String userid,
			@RequestParam(value = "xinyong", required = false) String xinyong,
			@RequestParam(value = "rtype", required = false) String rtype){
		ttzService.updateSYED(userid, Integer.parseInt(xinyong));
		if(rtype.equals("身份证")){
			ziService.updateSFZ(userid, "4");
		}else if(rtype.equals("居住证")){
			ziService.updateJZZ(userid, "4");
			
		}else if(rtype.equals("工作证")){
			ziService.updateGZZ(userid, "4");
			
		}else if(rtype.equals("收入证明")){
			ziService.updateSRZ(userid, "4");
			
		}else if(rtype.equals("信用证明")){
			ziService.updateXYZ(userid, "4");
		}
		Map<String, Object> map =new HashMap<String, Object>();
		return map;

	}

}
