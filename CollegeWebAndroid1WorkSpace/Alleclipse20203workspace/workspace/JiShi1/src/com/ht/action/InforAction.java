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
		System.out.println("������");
		//��ѯ�б�
		List<Informations> list = ss.selinforlist();
		
		ToRequest("inforlist", list);
		return "ok";
	}
	
	public String selxq(){
		System.out.println("selxq");
		System.out.println(inforid);
		Informations infor = ss.getinfor((long)inforid);
		
		//���лظ��б���ͨ�������������infor��
		List<Replies> replist = infor.getReplieses();
		
		ToRequest("infor", infor);
		ToRequest("replist", replist);
		
		//�޸Ĳ鿴����
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
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		}
//		String tx = request.getParameter("texts");
		System.out.println("������"+""+inforid+""+texts);
		Replies re = new Replies();
		re.setInInforid((long)inforid);
		re.setReContent(texts);
		re.setReReplytime(new Date());
		ss2.add(re);
		
		//�޸Ļظ��� ��ʱ��
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
