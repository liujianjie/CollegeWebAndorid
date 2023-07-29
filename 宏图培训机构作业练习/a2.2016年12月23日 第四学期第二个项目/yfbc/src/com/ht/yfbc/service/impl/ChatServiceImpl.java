package com.ht.yfbc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.ChatDao;
import com.ht.yfbc.pojo.Chat;
import com.ht.yfbc.pojo.Chat2;
import com.ht.yfbc.service.ChatService;
@Service
public class ChatServiceImpl implements ChatService{
	@Resource
	private ChatDao cDao;
	@Override
	public List<Chat2> selChat(String myid, String heid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("setid", myid);
		map.put("getid", heid);
		return cDao.selChat(map);
	}

	@Override
	public int insertChat(Chat chat) {
		// TODO Auto-generated method stub
		return cDao.insertChat(chat);
	}

	@Override
	public List<Chat2> selChatIndex(String getid) {
		// TODO Auto-generated method stub
		return cDao.selChatIndex(getid);
	}

	@Override
	public List<Chat2> selChatIndex2(String getid) {
		// TODO Auto-generated method stub
		return cDao.selChatIndex2(getid);
	}

	@Override
	public List<Chat2> selChatIndex3(String getid) {
		// TODO Auto-generated method stub
		return cDao.selChatIndex3(getid);
	}

}
