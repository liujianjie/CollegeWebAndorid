package com.ht.yfbc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ht.yfbc.pojo.Msg2;
import com.ht.yfbc.pojo.Msgpojo;

public interface IMsgService {
	public List<Msgpojo> selmsglist();
	public List<Msgpojo> selmsgmylist(@Param("username")String username,@Param("statu")String statu);
	
	public void del(String id);
	public void addmsg(Msgpojo msg);
	public Msgpojo toupdmsg(String id);
	public void updmsg(Msgpojo msg);
	//fen ye list
	public List<Msgpojo> findpagelist(Integer pageCount,Integer currPage);
	
	public List<Msgpojo> findpagemylist(Integer pageCount,Integer currPage,String username,String statu);
	
	public List<Msgpojo> findbyid(Integer id);
	public int selcount(Integer id);
	public int selcount();//totalrow
	//statu
	public boolean changestatu(String id,String msgstatu);
	
	public List<Msg2> ajaxlist();
	
	public List<Msg2> ajaxlist2();
}