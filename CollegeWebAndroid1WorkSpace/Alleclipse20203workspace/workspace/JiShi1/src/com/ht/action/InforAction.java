package com.ht.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ht.bean.Informations;
import com.ht.bean.Replies;
import com.ht.common.BaseAction;
import com.ht.service.InformationsI;
import com.ht.service.RepliesI;
import com.ht.serviceimp.Informationsimp;
import com.ht.serviceimp.Repliesimp;
import com.ht.util.MybatisUtil;

public class InforAction extends BaseAction {
	
	InformationsI ss = new Informationsimp();
	RepliesI ss2 = new Repliesimp();
	private int inforid;
	
	public String selinfor(){
		System.out.println("进来了");
		//查询列表
		List<Informations> list = ss.selinforlist();
		
		ToRequest("inforlist", list);
		return "ok";
	}
	
	public String selxq(){
		System.out.println("selxq");
		System.out.println(inforid);
		Informations infor = ss.getinfor((long)inforid);
		
		//还有回复列表。。通过级联查出都在infor中
		List<Replies> replist = infor.getReplieses();
		
		ToRequest("infor", infor);
		ToRequest("replist", replist);
		
		//修改查看人数
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("view", 1);
		map.put("id",inforid );
		ss.alertinfor(map);
		
		return "ok";
	}
	private String texts;
	public String adds(){
//		HttpServletRequest request=ServletActionContext.getRequest();
//		try {
//			request.setCharacterEncoding("utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		String tx = request.getParameter("texts");
		System.out.println("进来了"+""+inforid+""+texts);
		Replies re = new Replies();
		re.setInInforid((long)inforid);
		re.setReContent(texts);
		re.setReReplytime(new Date());
		ss2.add(re);
		
		//修改回复数 和时间
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("view", 2);
		map.put("id",inforid);
		ss.alertinfor(map);
		
		return "ok";
	}
	public int getInforid() {
		return inforid;
	}
	public void setInforid(int inforid) {
		this.inforid = inforid;
	}
	public String getTexts() {
		return texts;
	}
	public void setTexts(String texts) {
		this.texts = texts;
	}
	
}
