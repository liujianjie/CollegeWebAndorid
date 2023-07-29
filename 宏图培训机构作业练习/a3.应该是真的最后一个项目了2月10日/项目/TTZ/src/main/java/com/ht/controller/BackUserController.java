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
 * ��̨�û����� ���Ʋ�
 * 
 */

@Controller
@RequestMapping("backuser")
public class BackUserController {

	@Resource
	BackgroundUserService backuserservice;

	@Resource
	PostService pservice;// ��̨��λ

	@Resource
	PermissionService permissionservice;// ��̨Ȩ��

	// ��ҳ��ѯ
	@RequestMapping("userlist")
	public String userlist(Model model, @RequestParam(value = "cpage") Integer cpage) {
		Map<String, Object> map = backuserservice.selbackuserlist(cpage);

		model.addAttribute("map", map);
		return "../backgroundSystem/Userlist.jsp";
	}

	// ȥ�޸� ����ֵ
	@RequestMapping("toalert")
	public String toalert(Model model, @RequestParam(value = "id", required = false) String id, HttpSession session)
			throws Exception {
		BackGroundUser user = backuserservice.selBackGroudUser(id);
		List<Post> post = pservice.selpostlist();

		model.addAttribute("user", user);
		model.addAttribute("post", post);
		return "../backgroundSystem/Useralert.jsp";
	}

	// �޸�
	@RequestMapping("alert")
	public String alert(Model model, BackGroundUser bkuser, HttpSession session) {
		backuserservice.updBackGroundUser(bkuser);

		// ����ǵ�¼�� ����ֵ
		BackGroundUser back = (BackGroundUser) session.getAttribute("backuser");
		if (back.getB_id().equals(bkuser.getB_id())) {
			// ���»�ȡ
			BackGroundUser user = backuserservice.selBackGroudUser(bkuser.getB_id());
			session.setAttribute("backuser", user);
		}
		return "redirect:/backuser/toalert.action?id=" + bkuser.getB_id();
	}

	// �޸�ͷ��
	@RequestMapping("updateFace")
	public String updateFace(Model model, HttpSession session, HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = "files") MultipartFile file, @RequestParam(value = "id") String id) {
		// ��ȡ��ǰ���������ļ���·��
		String path = request.getSession().getServletContext().getRealPath("backgroundSystem/image");

		// ��ȡ�ļ�����
		String filename = file.getOriginalFilename();
		// �����ļ�
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
		// �޸����ݿ� ͷ���ļ��洢·��
		BackGroundUser backuser = new BackGroundUser();
		backuser.setB_touxiang("backgroundSystem/image/" + filename);
		backuser.setB_id(id);
		backuserservice.updBackGroundUser(backuser);

		// ����ǵ�¼�� ����ֵ
		BackGroundUser back = (BackGroundUser) session.getAttribute("backuser");
		if (back.getB_id().equals(backuser.getB_id())) {
			// ���»�ȡ
			BackGroundUser user = backuserservice.selBackGroudUser(backuser.getB_id());
			session.setAttribute("backuser", user);
		}
		return "redirect:../backuser/toalert.action?id=" + id;
	}

	// ��index���޸�ͷ��
	@RequestMapping("indexupdateFace")
	public String indexupdateFace(Model model, HttpSession session, HttpServletRequest request,
			@RequestParam(value = "files") MultipartFile file, @RequestParam(value = "id") String id) {
		// ��ȡ��ǰ���������ļ���·��
		String path = request.getSession().getServletContext().getRealPath("backgroundSystem/image");

		// ��ȡ�ļ�����
		String filename = file.getOriginalFilename();

		// �����ļ�
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
		// �޸����ݿ� ͷ���ļ��洢·��
		BackGroundUser backuser = new BackGroundUser();
		backuser.setB_touxiang("backgroundSystem/image/" + filename);
		backuser.setB_id(id);
		backuserservice.updBackGroundUser(backuser);

		// ���»�ȡ
		BackGroundUser user = backuserservice.selBackGroudUser(id);
		session.setAttribute("backuser", user);

		return "redirect:../backgroundSystem/index.jsp";
	}

	@ResponseBody
	@RequestMapping("test")
	public Map<String, Object> test(Model model, HttpSession session, HttpServletRequest request,
			@RequestParam(value = "files") MultipartFile file) {
		Map<String, Object> map = new HashMap<String, Object>();
		// ��ȡ��ǰ���������ļ���·��
		String path = request.getSession().getServletContext().getRealPath("backgroundSystem/image");
		// ��ȡ�ļ�����
		String filename = file.getOriginalFilename();

		// �����ļ�
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

	// ���
	@RequestMapping("toadd")
	public String toadd(Model model) {
		List<Post> post = pservice.selpostlist();

		model.addAttribute("post", post);
		return "../backgroundSystem/Useradd.jsp";
	}

	// ���
	@RequestMapping("add")
	public String add(Model model, HttpServletRequest request, @RequestParam(value = "files") MultipartFile file,
			BackGroundUser backusers) {
		// ��ȡ��ǰ���������ļ���·��
		String path = request.getSession().getServletContext().getRealPath("backgroundSystem/image");

		// ��ȡ�ļ�����
		String filename = file.getOriginalFilename();

		// �����ļ�
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
		// �������
		backusers.setB_touxiang("backgroundSystem/image/" + filename);
		backuserservice.addBackGroundUser(backusers);

		// ѡ���λ��Ȩ��Ҳ��ӽ�ȥ �Ȳ�ѯ ��p_list ��������Ĭ��Ȩ�� Ҫ�ж��Ƿ�Ϊ��
		Post post = pservice.getpost(backusers.getB_positionid());
		if (post != null) {
			String qxstring = post.getP_list();
			if (qxstring != null) {
				String[] qx = qxstring.split(",");
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < qx.length; i++) {// �����ӽ�Permission��ȥ
					map.put("b_id", backusers.getB_id());
					map.put("p_list", Integer.parseInt(qx[i]));
					permissionservice.adduserpermission(map);
				}
			}
		}

		return "redirect:/backuser/userlist.action?cpage=1";
	}

	// ɾ��
	@RequestMapping("del")
	public String del(Model model, HttpServletRequest request, @RequestParam(value = "userid") String id) {
		backuserservice.delBackGroundUser(id);
		// ͬʱɾ��Ȩ�� ��permission
		permissionservice.delpermissionforuserid(id);
		return "redirect:/backuser/userlist.action?cpage=1";
	}

	// ��֤�û����Ƿ����
	@ResponseBody
	@RequestMapping("YanZhengBackUsername")
	public Map<String, Object> YanZhengBackUsername(HttpServletRequest request) {
		String b_username = request.getParameter("param");
		Map<String, Object> map = new HashMap<String, Object>();
		int i = backuserservice.YanZhengBackUsername(b_username);
		if (i > 0) {
			map.put("info", "ϵͳ���Ѿ����ڸ�����");
			map.put("status", "n");
		} else {
			map.put("info", "�����ƿ���");
			map.put("status", "y");
		}
		return map;
	}

}
