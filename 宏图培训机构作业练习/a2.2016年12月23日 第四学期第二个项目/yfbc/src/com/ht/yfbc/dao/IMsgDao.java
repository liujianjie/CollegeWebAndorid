package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ht.yfbc.pojo.Msg2;
import com.ht.yfbc.pojo.Msgpojo;

public interface IMsgDao {
	public List<Msgpojo> selmsglist();
	
	public List<Msgpojo> selmsgmylist(@Param("username")String username,@Param("statu")String statu);
	
	public List<Msgpojo> findbyid(Integer id);

	public void del(String id);

	public void addmsg(Msgpojo msg);

	public Msgpojo toupdmsg(String id);

	public void updmsg(Msgpojo msg);

	public List<Msgpojo> findmsglist(@Param("pageCount") Integer pageCount, @Param("currPage") Integer currPage);

	public List<Msgpojo> findmsgmylist(@Param("pageCount")Integer pageCount,@Param("currPage")Integer currPage,@Param("username")String username,@Param("statu")String statu);
	//statu
	public boolean changestatu(@Param("id") String id, @Param("msgstatu") String msgstatu);
	
	public List<Msg2> ajaxlist();
	public List<Msg2> ajaxlist2();
}