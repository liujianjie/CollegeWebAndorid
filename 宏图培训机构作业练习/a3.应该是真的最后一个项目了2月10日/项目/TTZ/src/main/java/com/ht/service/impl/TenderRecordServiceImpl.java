package com.ht.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.TenderRecordDao;
import com.ht.pojo.MoneyRecord;
import com.ht.pojo.TenderRecord;
import com.ht.service.TenderRecordService;

@Service
public class TenderRecordServiceImpl implements TenderRecordService {

	@Resource
	TenderRecordDao td;

	public List TenderRecordList(Map<String, Object> map) {
		return td.TenderRecordList(map);
	}

	public int TenderRecoreAmount() {
		return td.TenderRecoreAmount();
	}

	public List TenderRecordCompleted(Map<String, Object> map) {
		return td.TenderRecordCompleted(map);
	}

	public int TenderRecordEarnings() {
		return td.TenderRecordEarnings();
	}

	public int TenderRecordPoundage() {
		return td.TenderRecordPoundage();
	}

	public int TenderRecordZhong() {
		return td.TenderRecordZhong();
	}

	public int TenderRecordSum() {
		return td.TenderRecordSum();
	}

	public int SelTenderRecord(Map<String, Object> map) {
		return td.SelTenderRecord(map);
	}

	@Override
	public Double selTenderSumMoney() {
		// TODO Auto-generated method stub
		return td.selTenderSumMoney();
	}

	public List SelHuiKuan(Map<String, Object> map) {
		return td.SelHuiKuan(map);
	}

	public int SelHuiKuanCount(Map<String, Object> map) {
		return td.SelHuiKuanCount(map);
	}

	public int SelTenderRecordCompleted(Map<String, Object> map) {
		return td.SelTenderRecordCompleted(map);
	}

	public List MoHuSelTenderRecord(Map<String, Object> map) {
		return td.MoHuSelTenderRecord(map);
	}

	public List<TenderRecord> sel_tend_list(Map<String, Object> map) {
		return td.sel_tend_list(map);
	}

	public List SelMoneyRecord(Map<String, Object> map) {
		return td.SelMoneyRecord(map);
	}

	public int SelMoneyRecordCount(Map<String, Object> map) {
		return td.SelMoneyRecordCount(map);
	}

	public List TouZiJilu(Map<String, Object> map) {
		return td.TouZiJilu(map);
	}

	public int TouZiJiluCount(Map<String, Object> map) {
		return td.TouZiJiluCount(map);
	}

	@Override
	public List SelMoneyRecordByID(String p_userid) {
		// TODO Auto-generated method stub
		return td.SelMoneyRecordByID(p_userid);
	}

	@Override
	public int SumMoney() {
		return td.SumMoney();
	}

	public List<TenderRecord> selectTenderRecordstatu0(Map<String, Object> map) {

		return td.selectTenderRecordstatu0(map);
	}

	public int selectTenderRecordstatu0Count(String userid) {

		return td.selectTenderRecordstatu0Count(userid);
	}

	// 更改投资的状态()债权转让中
	public int updateTenderRecordstatu5(String tender_id) {

		return td.updateTenderRecordstatu5(tender_id);
	}

	// 债权转让后插入新的投资
	public int insertTenderRecord(TenderRecord ten) {

		return td.insertTenderRecord(ten);
	}

	// 查询单个投资
	public TenderRecord selectOneTenderRecordForTender_id(String tender_id) {

		return td.selectOneTenderRecordForTender_id(tender_id);
	}

	// 更改投资的状态()债权转让完成
	public int updateTenderRecordstatu6(String tender_id) {
		return td.updateTenderRecordstatu6(tender_id);
	}
	
	@Override
	public List SumlistMoney() {
		return td.SumlistMoney();
	}

	@Override
	public List SumInterest() {
		return td.SumInterest();
	}
}
