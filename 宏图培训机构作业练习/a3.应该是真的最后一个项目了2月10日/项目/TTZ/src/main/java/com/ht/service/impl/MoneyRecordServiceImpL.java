package com.ht.service.impl;

import java.util.List;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.MoneyRecordDao;
import com.ht.dao.MoneyRecordDao;
import com.ht.pojo.Bankcard;
import com.ht.pojo.MoneyRecord;
import com.ht.service.MoneyRecordService;

/**
 * 用户资金交易记录 service
 */
@Service
public class MoneyRecordServiceImpL implements MoneyRecordService{
	
	@Resource
	private MoneyRecordDao dao;
	
	@Resource
	private MoneyRecordDao mon;
	
	@Override
	public List<MoneyRecord> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.list(map);
	}

	@Override
	public List<MoneyRecord> count(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.count(map);
	}
	
	@Override
	public List TopupMoner() {
		return mon.TopupMoner();
	}

	@Override
	public Integer TopupCount() {
		return mon.TopupCount();
	}

	@Override
	public Integer TradingCount() {
		return mon.TradingCount();
	}

	@Override
	public List TradingRecord() {
		return mon.TradingRecord();
	}

	@Override
	public void cunchu(Map<String, Object> map) {
		// TODO Auto-generated method stub
		dao.cunchu(map);
	}

	@Override
	public List ConditionQuery(Map<String, Object> map) {
		return mon.ConditionQuery(map);
	}

	@Override
	public List<MoneyRecord> countrow(String id) {
		// TODO Auto-generated method stub
		return dao.countrow(id);
	}

	@Override
	public Double yxmoney(String p_userid) {
		// TODO Auto-generated method stub
		return dao.yxmoney(p_userid);
	}

	@Override
	public List<MoneyRecord> withdrawList() {
		// TODO Auto-generated method stub
		return dao.withdrawList();
	}

	@Override
	public List<MoneyRecord> wdListPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.wdListPage(map);
	}

	@Override
	public Bankcard sel_bank(String bank_id) {
		// TODO Auto-generated method stub
		return dao.sel_bank(bank_id);
	}

	@Override
	public List<MoneyRecord> todayList() {
		// TODO Auto-generated method stub
		return dao.todayList();
	}

	@Override
	public List<MoneyRecord> weekList() {
		// TODO Auto-generated method stub
		return dao.weekList();
	}

	@Override
	public List<MoneyRecord> monthList() {
		// TODO Auto-generated method stub
		return dao.monthList();
	}

	@Override
	public List<MoneyRecord> lastdayList() {
		// TODO Auto-generated method stub
		return dao.lastdayList();
	}

	@Override
	public List<MoneyRecord> lastweekList() {
		// TODO Auto-generated method stub
		return dao.lastweekList();
	}

	@Override
	public List<MoneyRecord> lastmonthList() {
		// TODO Auto-generated method stub
		return dao.lastmonthList();
	}
	
}
