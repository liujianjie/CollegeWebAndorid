package com.ht.yfbc.service;

import java.util.List;

import com.ht.yfbc.pojo.Chat;
import com.ht.yfbc.pojo.Chat2;

public interface ChatService {
	public List<Chat2> selChat(String myid,String heid);
	
	public int insertChat(Chat chat);
	
	public List<Chat2> selChatIndex(String getid);
	
	public List<Chat2> selChatIndex2(String getid);
	
	public List<Chat2> selChatIndex3(String getid);
}
