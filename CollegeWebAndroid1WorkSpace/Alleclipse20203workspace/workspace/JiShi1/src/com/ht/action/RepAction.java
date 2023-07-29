package com.ht.action;


import java.util.Date;

import com.ht.bean.Replies;
import com.ht.service.RepliesI;

import com.ht.serviceimp.Repliesimp;

public class RepAction {
	
	RepliesI ss = new Repliesimp();
	
	public String lists(){
		System.out.println("½øÀ´ÁË list");
		return "success";
	}
	
}
