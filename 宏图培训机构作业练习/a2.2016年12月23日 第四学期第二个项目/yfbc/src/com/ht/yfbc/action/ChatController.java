package com.ht.yfbc.action;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
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

import com.ht.yfbc.pojo.Chat;
import com.ht.yfbc.pojo.Chat2;
import com.ht.yfbc.pojo.Chat3;
import com.ht.yfbc.pojo.Users;
import com.ht.yfbc.service.ChatService;
import com.ht.yfbc.service.UsersService;

@Controller
@RequestMapping("chat")
public class ChatController {
	@Resource
	private UsersService uService;

	@Resource
	private ChatService cService;

	@RequestMapping("tochat")
	public String toChat(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		List<Users> list = uService.selUserList();

		model.addAttribute("users", list);
		return "chat_view";

	}

	@ResponseBody
	@RequestMapping("insert")
	public Map<String, Object> Insert(HttpServletRequest request,
			@RequestParam(value = "chtext", required = false) String chtext,
			@RequestParam(value = "heid", required = false) String heid) {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		Chat chat = new Chat("", user.getId(), heid, new Date(), chtext);
		System.out.println(user.getId()+"\t1"+chtext+"2");
		cService.insertChat(chat);


		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user);
		return map;

	}

	@ResponseBody
	@RequestMapping("sel")
	public Map<String, Object> selChat(HttpServletRequest request,
			@RequestParam(value = "heid", required = false) String heid) {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		List<Chat2> lists = cService.selChat(user.getId(), heid);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Chat3> list = new ArrayList<>();
		for (Chat2 chat2 : lists) {
			String dates = format.format(chat2.getSetdate());
			Chat3 chat3 = new Chat3(chat2.getChid(), chat2.getSetid(), chat2.getGetid(), chat2.getSetdate(),
					chat2.getChtext(), chat2.getSetuser(), chat2.getGetuser(), dates);
			list.add(chat3);
		}
		System.out.println("123111");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("myid", user.getId());
		return map;

	}
	
	@ResponseBody
	@RequestMapping("selindex")
	public Map<String, Object> selindex(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		List<Chat2> lists = cService.selChatIndex(user.getId());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Chat3> list = new ArrayList<>();
		for (Chat2 chat2 : lists) {
			String dates = format.format(chat2.getSetdate());
			Chat3 chat3 = new Chat3(chat2.getChid(), chat2.getSetid(), chat2.getGetid(), chat2.getSetdate(),
					chat2.getChtext(), chat2.getSetuser(), chat2.getGetuser(), dates);
			list.add(chat3);
		}
		List<Chat2> list2 = cService.selChatIndex3(user.getId()); 
		int i = list2.size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("myid", user.getId());
		map.put("size", i);
		return map;

	}
	
	@ResponseBody
	@RequestMapping("selindexall")
	public Map<String, Object> selindexAll(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		List<Chat2> lists = cService.selChatIndex2(user.getId());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Chat3> list = new ArrayList<>();
		for (Chat2 chat2 : lists) {
			String dates = format.format(chat2.getSetdate());
			Chat3 chat3 = new Chat3(chat2.getChid(), chat2.getSetid(), chat2.getGetid(), chat2.getSetdate(),
					chat2.getChtext(), chat2.getSetuser(), chat2.getGetuser(), dates);
			list.add(chat3);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("myid", user.getId());
		return map;

	}


}
