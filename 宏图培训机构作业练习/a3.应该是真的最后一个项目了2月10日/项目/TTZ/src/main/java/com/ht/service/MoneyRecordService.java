package com.ht.service;

import java.util.List;

import java.util.Date;
import java.util.Map;

import com.ht.pojo.Bankcard;
import com.ht.pojo.MoneyRecord;

/**
 * 用户资金交易记录 service
 */
public interface MoneyRecordService {
	List<MoneyRecord> list(Map<String, Object> map);
	List<MoneyRecord> count(Map<String, Object> map);
	// 查询充值记录
	public List TopupMoner();

	// 查询充值记录
	public Integer TopupCount();

	// 查询交易条数
	public Integer TradingCount();

	// 查询交易记录
	public List TradingRecord();
	
	//条件查询
	public List  ConditionQuery(Map<String, Object> map);

	List<MoneyRecord> countrow(String id);
	
	public void cunchu(Map<String, Object> map);

	public Bankcard sel_bank(String bank_id);
	//从记录查出提现总金额
	Double yxmoney(String p_userid);
	//查询提现记录
	public List<MoneyRecord> withdrawList();
	public List<MoneyRecord> wdListPage(Map<String, Object> map);//分页查询
	//查找当天提现记录
	public List<MoneyRecord> todayList();
	//查找本周提现记录
	public List<MoneyRecord> weekList();
	//查找本月提现记录
	public List<MoneyRecord> monthList();
	//查找当天提现记录
	public List<MoneyRecord> lastdayList();
	//查找本周提现记录
	public List<MoneyRecord> lastweekList();
	//查找本月提现记录
	public List<MoneyRecord> lastmonthList();

}
