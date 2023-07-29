package com.ljj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljj.vo.User;

@Controller
public class UserController {
	@RequestMapping("/testJson")
	@ResponseBody
	public User testJson(@RequestBody User user) {
		System.out.println(user);
		return user;
	}
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	@ResponseBody
	public User selectUser(@PathVariable("id") String id) {
		System.out.println("id="+id);
		User user = new User();
		user.setUsername("Json");
		return user;
	}
}
