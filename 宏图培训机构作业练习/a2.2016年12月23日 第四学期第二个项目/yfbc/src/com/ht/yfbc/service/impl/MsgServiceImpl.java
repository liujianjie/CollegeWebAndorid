package com.ht.yfbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.IMsgDao;
import com.ht.yfbc.pojo.Msg2;
import com.ht.yfbc.pojo.Msgpojo;
import com.ht.yfbc.service.IMsgService;
@Service
public class MsgServiceImpl implements IMsgService{
	@Resource
	private IMsgDao msgdao;
	@Override
	public List<Msgpojo> selmsglist() {
		// TODO Auto-generated method stub
		return msgdao.selmsglist();
	}
	@Override
	public void del(String id) {
		msgdao.del(id);
	}
	@Override
	public void addmsg(Msgpojo msg) {
		// TODO Auto-generated method stub
		msgdao.addmsg(msg);
	}
	@Override
	public Msgpojo toupdmsg(String id) {
		// TODO Auto-generated method stub
		return msgdao.toupdmsg(id);
	}
	@Override
	public void updmsg(Msgpojo msg) {
		// TODO Auto-generated method stub
		msgdao.updmsg(msg);
	}
	@Override
	public List<Msgpojo> findpagelist(Integer pageCount, Integer currPage) {
		// TODO Auto-generated method stub
		return  msgdao.findmsglist(pageCount, currPage);
	}
	@Override
	public int selcount(Integer id) {
		// TODO Auto-generated method stub
		return findbyid(id).size();
	}
	@Override
	public int selcount() {
		// TODO Auto-generated method stub
		return msgdao.selmsglist().size();
	}
	@Override
	public List<Msgpojo> findbyid(Integer id) {
		// TODO Auto-generated method stub
		return msgdao.findbyid(id);
	}
	
	@Override
	public boolean changestatu(String id, String msgstatu) {
		// TODO Auto-generated method stub
		return msgdao.changestatu(id, msgstatu);
	}
	@Override
	public List<Msgpojo> findpagemylist(Integer pageCount, Integer currPage, String username, String statu) {
		// TODO Auto-generated method stub
		return msgdao.findmsgmylist(pageCount, currPage, username, statu);
	}
	@Override
	public List<Msgpojo> selmsgmylist(String username, String statu) {
		// TODO Auto-generated method stub
		return msgdao.selmsgmylist(username, statu);
	}
	@Override
	public List<Msg2> ajaxlist() {
		// TODO Auto-generated method stub
		return msgdao.ajaxlist();
	}
	@Override
	public List<Msg2> ajaxlist2() {
		// TODO Auto-generated method stub
		return msgdao.ajaxlist2();
	}
	


}
