package com.dc.controller.card;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

import com.dc.dao.card.CardDAO;
import com.dc.dao.card.CardDAOImpl;
import com.dc.util.BaseAction;

public class CardUpdate extends BaseAction{
	
	private String card;
	private List list;
	/*
	 * 修改购物车数量
	 */
	public void updatecard(){
		JSONArray json=JSONArray.fromObject(card);
		List list=JSONArray.toList(json, HashMap.class);
		CardDAO c=new CardDAOImpl();
		c.updatecard(list);
		this.getOut().print("{\"state\":0}");
	}

	/**
	 * @return the card
	 */
	public String getCard() {
		return card;
	}

	/**
	 * @param card the card to set
	 */
	public void setCard(String card) {
		this.card = card;
	}

	/**
	 * @return the list
	 */
	public List getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List list) {
		this.list = list;
	}
	
}
