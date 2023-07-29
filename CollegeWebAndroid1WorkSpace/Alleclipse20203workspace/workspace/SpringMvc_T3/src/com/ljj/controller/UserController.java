package com.ljj.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ljj.po.Orders;
import com.ljj.po.User;
import com.ljj.po.UserVo;

@Controller
//@RequestMapping("/")
public class UserController {
	@RequestMapping("/selectUser")
	public String selectUser(HttpServletRequest request) {
		String id = request.getParameter("id");
		System.out.println("id="+id);
		return "success";
	}
	@RequestMapping("/selectUser2")
	public String selectUser2(Integer id) {
		System.out.println("id="+id);
		return "success";
	}
	
	@RequestMapping("registerUser")
	public String registerUser(User uer) {
		System.out.println(uer.getUsername());
		System.out.println(uer.getPassword());
		return "success";
	}
	@RequestMapping("findOrdersWithUser")
	public String findOrdersWithUser(Orders od) {
		System.out.println(od.getOrdersId());
		System.out.println(od.getUser().getUsername());
		return "success";
	}
	// 日期转换
	@RequestMapping("customDate")
	public String CustomDate(Date date) {
		System.out.println(date);
		return "success";
	}
	// 绑定数组
	@RequestMapping("deleteUsers")
	public String deleteUsers(Integer[] ids) {
		for(Integer id : ids) {
			System.out.println(id);
		}
		return "success";
	}
	// 绑定集合
	@RequestMapping("editUsers")
	public String editUsers(UserVo usersList) {
		for(User user : usersList.getUsers()) {
			System.out.println(user.getId());
			System.out.println(user.getUsername());
		}
		return "success";
	}
}
