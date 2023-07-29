package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Chat;
import com.ht.yfbc.pojo.Chat2;

public interface ChatDao {
	public List<Chat2> selChat(Map<String, Object> map);
	
	public int insertChat(Chat chat);
	
	public List<Chat2> selChatIndex(String getid);
	
	public List<Chat2> selChatIndex2(String getid);
	
	public List<Chat2> selChatIndex3(String getid);
}
