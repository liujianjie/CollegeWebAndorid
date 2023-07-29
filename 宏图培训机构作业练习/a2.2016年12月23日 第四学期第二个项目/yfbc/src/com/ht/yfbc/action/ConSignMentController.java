package com.ht.yfbc.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ht.yfbc.pojo.ConSignMent;
import com.ht.yfbc.service.ConSignMentService;

/**
 * 发货操作层
 * day 2016-12-27
 * @author 刘建杰
 * */
@Controller
@RequestMapping("consignment")
public class ConSignMentController {
	
	@Resource
	private ConSignMentService conservice;
	
	@RequestMapping("list")
	private String list(){
		List<ConSignMent> list = conservice.selConSignMent();
		System.out.println(list.get(0).getConid());
		return null;
	}
}
