package com.dc.controller.card;

import javax.servlet.http.HttpSession;

import com.dc.util.BaseAction;

public class menu extends BaseAction{
	public String menuback(){
		HttpSession sess=this.getSession();
		sess.setAttribute("UserMap", null);
		return "success";
	}
}
