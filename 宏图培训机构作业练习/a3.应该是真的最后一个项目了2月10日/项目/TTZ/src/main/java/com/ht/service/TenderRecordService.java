package com.ht.service;

import java.util.List;
import java.util.Map;

import com.ht.pojo.MoneyRecord;
import com.ht.pojo.TenderRecord;

public interface TenderRecordService {
	public List TenderRecordList(Map<String, Object> map);// 查询收益中的标

	public int SelTenderRecord(Map<String, Object> map);

	public int TenderRecoreAmount();// 查询收益中投资金额

	public List TenderRecordCompleted(Map<String, Object> map);// 查询已完成的标

	public int SelTenderRecordCompleted(Map<String, Object> map);

	public int TenderRecordEarnings();// 收益

	public int TenderRecordPoundage();// 手续费

	public int TenderRecordZhong(); // 中标数 、投标数

	public int TenderRecordSum();// 投资金额

	public Double selTenderSumMoney();

	public List SelHuiKuan(Map<String, Object> map);// 查询回款记录

	public int SelHuiKuanCount(Map<String, Object> map);

	public List MoHuSelTenderRecord(Map<String, Object> map);// 模糊查询

	public List<TenderRecord> sel_tend_list(Map<String, Object> map);

	public List SelMoneyRecord(Map<String, Object> map);// 查询资金记录

	public int SelMoneyRecordCount(Map<String, Object> map);// 查询资金记录条数

	public List TouZiJilu(Map<String, Object> map);// 查询投资记录

	public int TouZiJiluCount(Map<String, Object> map);// 查询投资记录条数

	public List SelMoneyRecordByID(String p_userid);

	public int SumMoney();

	public List<TenderRecord> selectTenderRecordstatu0(Map<String, Object> map);

	public int selectTenderRecordstatu0Count(String userid);

	// 更改投资的状态()债权转让中
	public int updateTenderRecordstatu5(String tender_id);

	// 债权转让后插入新的投资
	public int insertTenderRecord(TenderRecord ten);

	// 查询单个投资
	public TenderRecord selectOneTenderRecordForTender_id(String tender_id);

	// 更改投资的状态()债权转让完成
	public int updateTenderRecordstatu6(String tender_id);
	
	//查询投资金额前五名
	public List SumlistMoney();
	
	//查询投资金额前五名
	public List SumInterest();
}
