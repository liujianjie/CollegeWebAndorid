package com.ht.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ht.bean.Informations;
import com.ht.bean.Replies;
import com.ht.common.BaseAction;
import com.ht.service.InformationsI;
import com.ht.service.RepliesI;
import com.ht.serviceimp.Informationsimp;
import com.ht.serviceimp.Repliesimp;
import com.ht.util.MybatisUtil;

public class InforAction extends BaseAction{
	
	InformationsI ss = new Informationsimp();
	RepliesI ss2 = new Repliesimp();
	private int inforid;
	
	public String selinfor(){
		System.out.println("进来了");
		//查询列表
		List<Informations> list = ss.selinforlist();
		
		ToRequest("inforlist", list);
		return "inforlist";
	}
	
	public String selxq(){
		System.out.println(inforid);
		Informations infor = ss.getinfor((long)inforid);
		
		//还有回复列表。。
		List replist = ss2.selrep((long)inforid);
		
		ToRequest("infor", infor);
		ToRequest("replist", replist);
		
		//修改查看人数
		infor.setInViewcount(infor.getInViewcount()+1);
		boolean bln = ss.alertinfor(infor);
		System.out.println(bln);
		
		return "replies";
	}
	private String texts;
	public String adds(){
		System.out.println("进来了"+""+inforid);
		Replies re = new Replies();
		re.setInInforid((long)inforid);
		re.setReContent(texts);
		re.setReReplytime(new Date());
		boolean bln = ss2.add(re);
		
		//修改回复数 和时间
		Informations informations = ss.getinfor((long)inforid);
		informations.setInReplycount(informations.getInReplycount()+1);
		informations.setInLastposttime(new Date());
		bln=ss.alertinfor(informations);
		
		return selxq();
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
